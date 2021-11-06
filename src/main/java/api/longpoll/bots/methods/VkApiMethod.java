package api.longpoll.bots.methods;

import api.longpoll.bots.config.VkBotsConfig;
import api.longpoll.bots.converter.Converter;
import api.longpoll.bots.exceptions.VkApiException;
import api.longpoll.bots.exceptions.VkApiResponseException;
import api.longpoll.bots.http.HttpClient;
import api.longpoll.bots.http.HttpRequest;
import api.longpoll.bots.http.MultipartFormData;
import api.longpoll.bots.async.AsyncCaller;
import api.longpoll.bots.validators.VkResponseValidator;
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
public abstract class VkApiMethod<Response> implements HttpRequest {
    /**
     * Logger object.
     */
    private static final Logger log = LoggerFactory.getLogger(VkApiMethod.class);

    /**
     * Request params.
     */
    private final Map<String, String> params = new HashMap<>();

    /**
     * Async executor.
     */
    private final AsyncCaller asyncCaller = VkBotsConfig.getInstance().getAsyncCaller();

    /**
     * HTTP client.
     */
    private final HttpClient httpClient = VkBotsConfig.getInstance().getHttpClient();

    /**
     * Validator to check if VK API response is valid.
     */
    private final VkResponseValidator vkResponseValidator = VkBotsConfig.getInstance().getVkResponseValidator();

    /**
     * Converts JSON string to POJO.
     */
    private final Converter<String, Response> jsonConverter = VkBotsConfig.getInstance().getJsonConverterFactory().get(getResponseType());

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
            log.debug("Sending: method={}, url={}, params={}", getRequestMethod(), getUrl(), params);

            String body = httpClient.execute(this);
            log.debug("Received: {}", body);

            if (vkResponseValidator.isValid(body)) {
                return jsonConverter.convert(body);
            }

            throw new VkApiResponseException(body);
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
    public VkApiMethod<Response> addParam(String key, Object value) {
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
        return null;
    }
}
