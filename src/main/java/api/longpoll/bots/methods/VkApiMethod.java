package api.longpoll.bots.methods;

import api.longpoll.bots.exceptions.BotsLongPollAPIException;
import api.longpoll.bots.exceptions.BotsLongPollException;
import api.longpoll.bots.utils.async.AsyncUtil;
import api.longpoll.bots.validators.Validator;
import api.longpoll.bots.validators.VkApiResponseValidator;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import kong.unirest.HttpRequest;
import kong.unirest.Unirest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.AbstractMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Executes generic HTTP request to VK API.
 *
 * @param <Result> VK API response type.
 */
public abstract class VkApiMethod<Result> {
    /**
     * Logger object.
     */
    private static final Logger log = LoggerFactory.getLogger(VkApiMethod.class);

    /**
     * Gson object.
     */
    private static final Gson GSON = new Gson();

    /**
     * Validator to check if VK API response is valid.
     */
    private static final Validator<JsonObject> VALIDATOR = new VkApiResponseValidator();

    /**
     * Executes request to VK API asynchronously.
     *
     * @return VK API response wrapped to CompletableFuture
     */
    public CompletableFuture<Result> executeAsync() {
        return AsyncUtil.callAsync(this::execute);
    }

    /**
     * Executes request to VK API.
     *
     * @return VK API response.
     * @throws BotsLongPollAPIException if VK API returns invalid JSON response.
     * @throws BotsLongPollException    if other errors occur.
     */
    public Result execute() throws BotsLongPollAPIException, BotsLongPollException {
        return execute(getResultType());
    }

    /**
     * Executes request to VK API.
     *
     * @param responseType VK API response type.
     *                     This value is used during deserialization of received JSON.
     * @return VK API response.
     * @throws BotsLongPollAPIException if VK API returns invalid JSON response.
     * @throws BotsLongPollException    if other errors occur.
     */
    private Result execute(Class<? extends Result> responseType) throws BotsLongPollAPIException, BotsLongPollException {
        JsonObject jsonResponse = GSON.fromJson(sendRequest(), JsonObject.class);

        if (VALIDATOR.isValid(jsonResponse)) {
            return GSON.fromJson(jsonResponse, responseType);
        }

        throw new BotsLongPollAPIException(jsonResponse);
    }

    /**
     * Sends HTTP request to VK API.
     *
     * @return VK API {@code String} response.
     * @throws BotsLongPollException if error occurs.
     */
    private String sendRequest() throws BotsLongPollException {
        try {
            String api = getApi();
            Map<String, Object> data = getData();

            log.debug("Sending: api={}, data={}", api, data);

            Unirest.config().defaultBaseUrl(VkApi.getInstance().apiBaseUrl());
            String body = execute(httpRequest().queryString(data));

            log.debug("Received: {}", body);

            return body;
        } catch (IOException e) {
            throw new BotsLongPollException(e);
        }
    }

    /**
     * Executes HTTP request to VK API.
     *
     * @param httpRequest request data.
     * @return HTTP response.
     * @throws IOException if error occurs.
     */
    protected String execute(HttpRequest<?> httpRequest) throws IOException {
        return httpRequest.asString().getBody();
    }

    /**
     * Collects request params to be sent to VK API.
     *
     * @return request params.
     */
    protected Map<String, Object> getData() {
        return getParamsStream()
                .filter(Objects::nonNull)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    /**
     * Creates a request parameter to be sent to VK API.
     *
     * @param key     parameter name.
     * @param value   parameter value.
     * @param boolint <b>true</b> if boolean value should be represented as 0 or 1.
     * @return request parameter.
     */
    protected Map.Entry<String, Object> param(String key, Object value, boolean boolint) {
        if (value == null) {
            return null;
        }

        if (value instanceof List) {
            if (((List<?>) value).isEmpty()) {
                return null;
            }
            value = ((List<?>) value).stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(","));
        }

        if (boolint && value instanceof Boolean) {
            value = (Boolean) value ? 1 : 0;
        }

        return new AbstractMap.SimpleEntry<>(key, String.valueOf(value));
    }

    /**
     * Creates a request parameter to be sent to VK API.
     *
     * @param key   parameter name.
     * @param value parameter value.
     * @return request parameter.
     */
    protected Map.Entry<String, Object> param(String key, Object value) {
        return param(key, value, false);
    }

    /**
     * Gets VK API URL.
     *
     * @return VK API URL.
     */
    protected abstract String getApi();

    /**
     * Instantiates HTTP request. (E.g. {@link Unirest#get(String)} or {@link Unirest#post(String)})
     *
     * @return HTTP request.
     */
    protected abstract HttpRequest<?> httpRequest();

    /**
     * Gets stream of request parameters.
     * This stream is used during collecting request data in {@link VkApiMethod#getData()}.
     *
     * @return stream of request parameters.
     */
    protected abstract Stream<Map.Entry<String, Object>> getParamsStream();

    /**
     * Gets type of VK API response.
     * This value is used during deserialization of received JSON.
     *
     * @return type of VK API response.
     */
    protected abstract Class<? extends Result> getResultType();
}
