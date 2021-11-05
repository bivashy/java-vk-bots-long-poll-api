package api.longpoll.bots.methods;

import api.longpoll.bots.converters.json.GsonConverter;
import api.longpoll.bots.converters.json.JsonConverter;
import api.longpoll.bots.converters.params.DefaultVkApiParamsConverter;
import api.longpoll.bots.converters.params.VkApiParamsConverter;
import api.longpoll.bots.exceptions.VkApiException;
import api.longpoll.bots.exceptions.VkApiResponseException;
import api.longpoll.bots.http.HttpClient;
import api.longpoll.bots.http.JsoupHttpClient;
import api.longpoll.bots.utils.async.AsyncCaller;
import api.longpoll.bots.utils.async.DefaultAsyncCaller;
import api.longpoll.bots.validators.DefaultVkApiResponseValidator;
import api.longpoll.bots.validators.VkApiResponseValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * Executes generic HTTP request to VK API.
 *
 * @param <Response> VK API response type.
 */
public abstract class VkApiMethod<Response> {
    /**
     * Logger object.
     */
    private static final Logger log = LoggerFactory.getLogger(VkApiMethod.class);

    /**
     * Converts JSON string to POJO.
     */
    private JsonConverter jsonConverter;

    /**
     * Validator to check if VK API response is valid.
     */
    private VkApiResponseValidator vkApiResponseValidator;

    /**
     * Request params.
     */
    private Map<String, String> params;

    /**
     * Params converter.
     */
    private VkApiParamsConverter vkApiParamsConverter;

    /**
     * HTTP client.
     */
    private HttpClient httpClient;

    /**
     * HTTP method. Default value is POST.
     */
    private String method;

    /**
     * Async executor.
     */
    private AsyncCaller asyncCaller;

    /**
     * Executes request to VK API asynchronously.
     *
     * @return VK API response wrapped to CompletableFuture
     */
    public CompletableFuture<Response> executeAsync() {
        return getAsyncCaller().call(this::execute);
    }

    /**
     * Executes request to VK API.
     *
     * @return VK API response.
     * @throws VkApiException if errors occur.
     */
    public Response execute() throws VkApiException {
        log.debug("Sending: method={}, url={}, params={}", getMethod(), getUrl(), params);

        HttpClient vkApiHttpClient = getVkApiHttpClient();
        vkApiHttpClient.setMethod(getMethod());
        vkApiHttpClient.setUrl(getUrl());
        vkApiHttpClient.setParams(params);

        try {
            String body = vkApiHttpClient.execute();
            log.debug("Received: {}", body);

            if (getVkApiResponseValidator().isValid(body)) {
                return getJsonConverter().convert(body, getResponseType());
            }

            throw new VkApiResponseException(body);
        } catch (IOException e) {
            throw new VkApiException(e);
        }
    }

    /**
     * Gets VK API URL.
     *
     * @return VK API URL.
     */
    protected abstract String getUrl();

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
    public VkApiMethod<Response> addParam(String key, Object value) {
        getParams().put(key, String.valueOf(value));
        return this;
    }

    public JsonConverter getJsonConverter() {
        if (jsonConverter == null) {
            jsonConverter = new GsonConverter();
        }
        return jsonConverter;
    }

    public void setJsonConverter(JsonConverter jsonConverter) {
        this.jsonConverter = jsonConverter;
    }

    public VkApiResponseValidator getVkApiResponseValidator() {
        if (vkApiResponseValidator == null) {
            vkApiResponseValidator = new DefaultVkApiResponseValidator();
        }
        return vkApiResponseValidator;
    }

    public void setVkApiResponseValidator(VkApiResponseValidator vkApiResponseValidator) {
        this.vkApiResponseValidator = vkApiResponseValidator;
    }

    public Map<String, String> getParams() {
        if (params == null) {
            params = new HashMap<>();
        }
        return params;
    }

    public void setParams(Map<String, String> params) {
        this.params = params;
    }

    public HttpClient getVkApiHttpClient() {
        if (httpClient == null) {
            httpClient = new JsoupHttpClient();
        }
        return httpClient;
    }

    public void setVkApiHttpClient(HttpClient httpClient) {
        this.httpClient = httpClient;
    }

    public String getMethod() {
        if (method == null) {
            method = "POST";
        }
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public VkApiParamsConverter getVkApiParamsConverter() {
        if (vkApiParamsConverter == null) {
            vkApiParamsConverter = new DefaultVkApiParamsConverter();
        }
        return vkApiParamsConverter;
    }

    public void setVkApiParamsConverter(VkApiParamsConverter vkApiParamsConverter) {
        this.vkApiParamsConverter = vkApiParamsConverter;
    }

    public AsyncCaller getAsyncCaller() {
        if (asyncCaller == null) {
            asyncCaller = new DefaultAsyncCaller();
        }
        return asyncCaller;
    }

    public void setAsyncCaller(AsyncCaller asyncCaller) {
        this.asyncCaller = asyncCaller;
    }
}
