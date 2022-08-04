package api.longpoll.bots.methods.impl;

import api.longpoll.bots.async.AsyncCaller;
import api.longpoll.bots.async.DefaultAsyncCaller;
import api.longpoll.bots.exceptions.VkApiException;
import api.longpoll.bots.exceptions.VkApiHttpException;
import api.longpoll.bots.exceptions.VkApiResponseException;
import api.longpoll.bots.http.HttpClient;
import api.longpoll.bots.http.HttpResponse;
import api.longpoll.bots.http.RequestBody;
import api.longpoll.bots.http.impl.DefaultHttpClient;
import api.longpoll.bots.http.impl.FormUrlencoded;
import api.longpoll.bots.http.impl.PostRequest;
import api.longpoll.bots.reader.impl.PropertiesReader;
import api.longpoll.bots.validator.Validator;
import api.longpoll.bots.validator.VkResponseValidator;
import com.google.gson.Gson;
import com.google.gson.JsonElement;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

/**
 * Executes generic HTTP request to VK API.
 *
 * @param <Response> VK API response type.
 */
public abstract class VkMethod<Response> {
    /**
     * Path to VK methods list.
     */
    private static final String VK_METHODS_PROPERTIES_PATH = "/vk/vk_methods.properties";

    /**
     * VK methods.
     */
    public static final Properties VK_METHODS = new PropertiesReader().read(VK_METHODS_PROPERTIES_PATH);

    /**
     * VK API version.
     */
    private static final String API_VERSION = "5.131";

    /**
     * Request params.
     */
    private final Map<String, String> params = new HashMap<>();
    /**
     * Async executor.
     */
    private final AsyncCaller asyncCaller = new DefaultAsyncCaller();
    /**
     * HTTP client.
     */
    private final HttpClient httpClient = new DefaultHttpClient();

    /**
     * Validator to check if VK API response is valid.
     */
    private final Validator<JsonElement> vkResponseValidator = new VkResponseValidator();
    /**
     * {@link Gson} instance.
     */
    private final Gson gson = new Gson();

    public VkMethod(String accessToken) {
        addParam("access_token", accessToken);
        addParam("v", API_VERSION);
    }

    public VkMethod() {
    }

    /**
     * Executes request to VK API asynchronously.
     *
     * @return VK API response wrapped to CompletableFuture
     */
    public CompletableFuture<Response> executeAsync() {
        return asyncCaller.call(this::execute);
    }

    /**
     * Executes request to VK API.
     *
     * @return VK API response.
     * @throws VkApiException if errors occur.
     */
    public Response execute() throws VkApiException {
        try {
            PostRequest request = new PostRequest(getUri()).setRequestBody(getRequestBody());
            HttpResponse httpResponse = httpClient.execute(request);

            if (httpResponse.getResponseCode() >= HttpURLConnection.HTTP_BAD_REQUEST) {
                throw new VkApiHttpException(httpResponse.toString());
            }

            JsonElement jsonElement = gson.fromJson(httpResponse.getBody(), JsonElement.class);
            if (vkResponseValidator.isValid(jsonElement)) {
                return gson.fromJson(jsonElement, getResponseType());
            }
            throw new VkApiResponseException(httpResponse.getBody(), jsonElement.getAsJsonObject());
        } catch (IOException e) {
            throw new VkApiException(e);
        }
    }

    /**
     * Gets type of VK API response.
     * This value is used during deserialization of received JSON.
     *
     * @return type of VK API response.
     */
    protected abstract Class<Response> getResponseType();

    public abstract String getUri();

    protected RequestBody getRequestBody() {
        FormUrlencoded requestBody = new FormUrlencoded();
        params.forEach(requestBody::addParam);
        return requestBody;
    }

    /**
     * Adds URL parameter to HTTP request.
     *
     * @param key   URL parameter key.
     * @param value URL parameter value.
     * @return current instance.
     */
    public VkMethod<Response> addParam(String key, Object value) {
        params.put(key, String.valueOf(value));
        return this;
    }

    public Map<String, String> getParams() {
        return params;
    }

    protected Gson getGson() {
        return gson;
    }

    /**
     * Converts list of objects to comma separated values.
     *
     * @param values list of objects.
     * @return comma separated values.
     */
    protected String csv(List<?> values) {
        return values.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(","));
    }

    @Override
    public String toString() {
        return "VkMethod{" +
                "params=" + params +
                '}';
    }
}
