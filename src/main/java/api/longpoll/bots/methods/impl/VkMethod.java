package api.longpoll.bots.methods.impl;

import api.longpoll.bots.async.AsyncCaller;
import api.longpoll.bots.async.DefaultAsyncCaller;
import api.longpoll.bots.exceptions.VkApiException;
import api.longpoll.bots.exceptions.VkApiResponseException;
import api.longpoll.bots.http.HttpClient;
import api.longpoll.bots.http.HttpRequest;
import api.longpoll.bots.http.HttpResponse;
import api.longpoll.bots.http.MultipartFormData;
import api.longpoll.bots.http.impl.DefaultHttpClient;
import api.longpoll.bots.reader.impl.PropertiesReader;
import api.longpoll.bots.validator.Validator;
import api.longpoll.bots.validator.VkResponseValidator;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
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
public abstract class VkMethod<Response> implements HttpRequest {
    /**
     * Logger object.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(VkMethod.class);

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

    /**
     * Multipart object.
     */
    private MultipartFormData multipartFormData;

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
            LOGGER.debug("Request: {}", this);

            HttpResponse httpResponse = httpClient.execute(this);
            LOGGER.debug("Response: {}", httpResponse);

            if (httpResponse.getStatusCode() >= 200 && httpResponse.getStatusCode() < 300) {
                JsonElement jsonElement = gson.fromJson(httpResponse.getBody(), JsonElement.class);
                if (vkResponseValidator.isValid(jsonElement)) {
                    return gson.fromJson(jsonElement, getResponseType());
                }
            }

            throw new VkApiResponseException(httpResponse.toString());
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

    @Override
    public String getRequestMethod() {
        return "POST";
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }

    @Override
    public MultipartFormData getMultipartFormData() {
        return multipartFormData;
    }

    public VkMethod<Response> setMultipartFormData(MultipartFormData multipartFormData) {
        this.multipartFormData = multipartFormData;
        return this;
    }

    public Gson getGson() {
        return gson;
    }

    /**
     * Hides <i>access_token</i> from logging.
     *
     * @return non-sensitive params.
     */
    private Map<String, String> getNonSensitiveParams() {
        return new HashMap<String, String>(params) {{
            computeIfPresent(
                    "access_token",
                    (key, value) -> value.replaceAll(".", "*")
            );
        }};
    }

    /**
     * Converts list of objects to comma separated values.
     *
     * @param values list of objects.
     * @return comma separated values.
     */
    protected String toCommaSeparatedValues(List<?> values) {
        return values.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(","));
    }

    @Override
    public String toString() {
        return String.format(
                "Method=%s, URL=%s, Params=%s",
                getRequestMethod(),
                getUrl(),
                getNonSensitiveParams()
        );
    }
}
