package api.longpoll.bots.methods;

import api.longpoll.bots.converter.GsonConverter;
import api.longpoll.bots.converter.JsonConverter;
import api.longpoll.bots.exceptions.BotsLongPollAPIException;
import api.longpoll.bots.exceptions.BotsLongPollException;
import api.longpoll.bots.utils.async.AsyncUtil;
import api.longpoll.bots.validators.VkApiResponseValidator;
import api.longpoll.bots.validators.VkApiResponseValidatorImpl;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.helper.HttpConnection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.HashMap;
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
     * @throws BotsLongPollException if errors occur.
     */
    public Result execute() throws BotsLongPollException {
        String body = sendRequest();

        if (getVkApiResponseValidator().isValid(body)) {
            return getJsonConverter().convert(body, getResultType());
        }

        throw new BotsLongPollAPIException(body);
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
            Connection.Method method = getMethod();
            List<Connection.KeyVal> params = collectParams();

            log.debug("Sending: method={}, api={}, params={}", method, api, params);

            Connection connection = Jsoup.connect(api)
                    .ignoreContentType(true)
                    .timeout(0)
                    .method(method);

            if (!params.isEmpty()) {
                connection.data(params);
            }

            String body = execute(connection).body();

            log.debug("Received: {}", body);

            return body;
        } catch (IOException e) {
            throw new BotsLongPollException(e);
        }
    }

    /**
     * Executes HTTP request to VK API.
     *
     * @param connection request data.
     * @return HTTP response.
     * @throws IOException if error occurs.
     */
    protected Connection.Response execute(Connection connection) throws IOException {
        return connection.execute();
    }

    /**
     * Collects request params to be sent to VK API.
     *
     * @return list of request params.
     */
    protected List<Connection.KeyVal> collectParams() {
        return getParamsStream()
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    /**
     * Creates a request parameter to be sent to VK API.
     *
     * @param key     parameter name.
     * @param value   parameter value.
     * @param boolint <b>true</b> if boolean value should be represented as 0 or 1.
     * @return request parameter.
     */
    protected Connection.KeyVal keyVal(String key, Object value, boolean boolint) {
        if (value == null) {
            return null;
        }

        if (value instanceof List) {
            if (((List<?>) value).isEmpty()) {
                return null;
            }
            value = ((List<?>) value).stream().map(String::valueOf).collect(Collectors.joining(","));
        }

        if (boolint && value instanceof Boolean) {
            value = (Boolean) value ? 1 : 0;
        }

        return HttpConnection.KeyVal.create(key, String.valueOf(value));
    }

    /**
     * Creates a request parameter to be sent to VK API.
     *
     * @param key   parameter name.
     * @param value parameter value.
     * @return request parameter.
     */
    protected Connection.KeyVal keyVal(String key, Object value) {
        return keyVal(key, value, false);
    }

    /**
     * Gets VK API URL.
     *
     * @return VK API URL.
     */
    protected abstract String getApi();

    /**
     * Gets HTTP method. (E.g. {@link Connection.Method#GET} or {@link Connection.Method#POST})
     *
     * @return HTTP method.
     */
    protected abstract Connection.Method getMethod();

    /**
     * Gets stream of request parameters.
     * This stream is used during collecting request data in {@link VkApiMethod#collectParams()}.
     *
     * @return stream of request parameters.
     */
    protected abstract Stream<Connection.KeyVal> getParamsStream();

    /**
     * Gets type of VK API response.
     * This value is used during deserialization of received JSON.
     *
     * @return type of VK API response.
     */
    protected abstract Class<? extends Result> getResultType();

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
            vkApiResponseValidator = new VkApiResponseValidatorImpl();
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

    public void addParam(String key, Object value) {
        addParam(key, value, false);
    }

    public void addParam(String key, Object value, boolean boolint) {
        addNonNullParam(key, value, boolint);
    }

    private void addNonNullParam(String key, Object value, boolean boolint) {
        if (value != null) {
            if (value instanceof List) {
                if (((List<?>) value).isEmpty()) {
                    return;
                }
                value = ((List<?>) value).stream()
                        .filter(Objects::nonNull)
                        .map(String::valueOf)
                        .collect(Collectors.joining(","));
            }

            if (boolint && value instanceof Boolean) {
                value = (Boolean) value ? 1 : 0;
            }

            getParams().put(key, value.toString());
        }
    }
}
