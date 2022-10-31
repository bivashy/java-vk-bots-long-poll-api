package api.longpoll.bots.methods.impl;

import api.longpoll.bots.async.AsyncCaller;
import api.longpoll.bots.async.DefaultAsyncCaller;
import api.longpoll.bots.exceptions.VkApiException;
import api.longpoll.bots.exceptions.VkApiHttpException;
import api.longpoll.bots.exceptions.VkApiResponseException;
import api.longpoll.bots.helpers.properties.VkProperties;
import api.longpoll.bots.http.HttpClient;
import api.longpoll.bots.http.HttpRequest;
import api.longpoll.bots.http.HttpResponse;
import api.longpoll.bots.http.RequestBody;
import api.longpoll.bots.http.impl.DefaultHttpClient;
import api.longpoll.bots.http.impl.FormUrlencoded;
import api.longpoll.bots.http.impl.PostRequest;
import api.longpoll.bots.validator.VkResponseBodyValidator;
import api.longpoll.bots.validator.VkResponseValidator;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Executes generic HTTP request to VK API.
 *
 * @param <ResponseBody> VK API response type.
 */
public abstract class VkMethod<ResponseBody> {
    /**
     * Path to VK methods list.
     */
    private static final String VK_PROPERTIES_PATH = "/vk/vk_methods.properties";

    /**
     * Access token key.
     */
    private static final String ACCESS_TOKEN_KEY = "access_token";

    /**
     * VK API version key.
     */
    private static final String API_VERSION_KEY = "v";

    /**
     * VK API version value.
     */
    private static final String API_VERSION_VALUE = "5.131";

    /**
     * VK methods.
     */
    private static final VkProperties VK_PROPERTIES = new VkProperties(VK_PROPERTIES_PATH);

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
     * HTTP response validator.
     */
    private final Predicate<HttpResponse> httpResponseValidator = new VkResponseValidator();

    /**
     * Validator to check if VK API response is valid.
     */
    private final Predicate<String> responseBodyValidator = new VkResponseBodyValidator();

    /**
     * {@link Gson} instance.
     */
    private final Gson gson = new Gson();

    /**
     * Access token.
     */
    private String accessToken;

    public VkMethod(String accessToken) {
        this.accessToken = accessToken;
        addParam(ACCESS_TOKEN_KEY, accessToken);
        addParam(API_VERSION_KEY, API_VERSION_VALUE);
    }

    public VkMethod() {
    }

    /**
     * Executes request to VK API asynchronously.
     *
     * @return VK API response wrapped to CompletableFuture
     */
    public CompletableFuture<ResponseBody> executeAsync() {
        return asyncCaller.call(this::execute);
    }

    /**
     * Executes request to VK API.
     *
     * @return VK API response.
     * @throws VkApiException if errors occur.
     */
    public ResponseBody execute() throws VkApiException {
        try {
            HttpRequest request = new PostRequest.Builder(getUri())
                    .setRequestBody(getRequestBody())
                    .build();
            HttpResponse response = httpClient.execute(request);

            if (httpResponseValidator.negate().test(response)) {
                throw new VkApiHttpException(response.toString());
            }

            if (responseBodyValidator.test(response.getBody())) {
                return gson.fromJson(response.getBody(), getResponseClass());
            }
            throw new VkApiResponseException(response.getBody());
        } catch (IOException e) {
            throw new VkApiException(e);
        }
    }

    /**
     * Gets a class of VK API response.
     * This value is used during deserialization of received JSON.
     *
     * @return a class of VK API response.
     */
    protected abstract Class<ResponseBody> getResponseClass();

    /**
     * Gets request URI.
     *
     * @return request URI.
     */
    public abstract String getUri();

    /**
     * Gets HTTP request body.
     *
     * @return HTTP request body.
     */
    protected RequestBody getRequestBody() {
        return new FormUrlencoded(params);
    }

    /**
     * Adds URL parameter to HTTP request.
     *
     * @param key   URL parameter key.
     * @param value URL parameter value.
     * @return current instance.
     */
    public VkMethod<ResponseBody> addParam(String key, Object value) {
        params.put(key, String.valueOf(value));
        return this;
    }

    /**
     * Gets {@link VkMethod#gson} object.
     *
     * @return {@link VkMethod#gson} object.
     */
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

    /**
     * Gets a property from {@link VkMethod#VK_PROPERTIES}.
     *
     * @param key property key.
     * @return property value.
     */
    protected String property(String key) {
        return VK_PROPERTIES.getProperty(key);
    }

    /**
     * Gets {@link VkMethod#accessToken}.
     *
     * @return {@link VkMethod#accessToken}.
     */
    protected String getAccessToken() {
        return accessToken;
    }

    @Override
    public String toString() {
        return "VkMethod{" +
                "params=" + params +
                '}';
    }
}
