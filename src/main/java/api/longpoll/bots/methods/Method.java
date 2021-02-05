package api.longpoll.bots.methods;

import api.longpoll.bots.converters.Converter;
import api.longpoll.bots.converters.JsonToPojoConverter;
import api.longpoll.bots.converters.StringToJsonConverter;
import api.longpoll.bots.exceptions.BotsLongPollException;
import api.longpoll.bots.exceptions.BotsLongPollHttpException;
import api.longpoll.bots.validators.Validator;
import api.longpoll.bots.validators.ResponseValidator;
import com.google.gson.JsonObject;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.helper.HttpConnection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Generic method which executes requests to VK API.
 *
 * @param <Result> VK API response type.
 */
public abstract class Method<Result> {
    /**
     * Logger object.
     */
    private static final Logger log = LoggerFactory.getLogger(Method.class);

    /**
     * Converter object that converts String to JsonObject.
     */
    private static final Converter<String, JsonObject> STRING_TO_JSON_CONVERTER = new StringToJsonConverter();

    /**
     * Validator that checks VK API response.
     */
    private static final Validator VALIDATOR = new ResponseValidator();

    public Method() {

    }

    /**
     * Executes request to VK API.
     *
     * @return VK API response.
     * @throws BotsLongPollHttpException if error occurs.
     */
    public Result execute() throws BotsLongPollHttpException, BotsLongPollException {
        return execute(getConverter());
    }

    /**
     * Executes request to VK API.
     *
     * @param converter converter which converts JsonObject to required Result type.
     * @return VK API response.
     * @throws BotsLongPollHttpException if error occurs.
     */
    private Result execute(JsonToPojoConverter<Result> converter) throws BotsLongPollHttpException, BotsLongPollException {
        String stringResponse = sendRequest();

        JsonObject responseJson = STRING_TO_JSON_CONVERTER.convert(stringResponse);

        if (VALIDATOR.isValid(responseJson)) {
            return converter.convert(responseJson);
        }

        throw new BotsLongPollException(responseJson.toString());
    }

    /**
     * Sends HTTP request.
     *
     * @return String response.
     * @throws BotsLongPollHttpException if error occurs.
     */
    private String sendRequest() throws BotsLongPollHttpException {
        try {
            String api = getApi();
            Connection.Method method = getMethod();
            List<Connection.KeyVal> data = getData();

            log.debug("Sending: method={}, api={}, data={}", method, api, data);

            Connection connection = Jsoup.connect(api)
                    .ignoreContentType(true)
                    .timeout(0)
                    .method(method);

            if (!data.isEmpty()) {
                connection.data(data);
            }

            String body = execute(connection).body();

            log.debug("Received: {}", body);

            return body;
        } catch (IOException e) {
            log.error("Failed to send request {}.", getMethod(), e);
            throw new BotsLongPollHttpException(e);
        }
    }

    /**
     * Executes HTTP request.
     *
     * @param connection destination params.
     * @return HTTP response.
     * @throws IOException if error occurs.
     */
    protected Connection.Response execute(Connection connection) throws IOException {
        return connection.execute();
    }

    /**
     * Collects request params.
     *
     * @return list of request params.
     */
    protected List<Connection.KeyVal> getData() {
        return getKeyValStream()
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    /**
     * Creates request parameter.
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
            value = ((List) value).stream().map(String::valueOf).collect(Collectors.joining(","));
        }

        if (boolint && value instanceof Boolean) {
            value = (Boolean) value ? 1 : 0;
        }

        return HttpConnection.KeyVal.create(key, String.valueOf(value));
    }

    /**
     * Creates request parameter.
     *
     * @param key   parameter name.
     * @param value parameter value.
     * @return request parameter.
     */
    protected Connection.KeyVal keyVal(String key, Object value) {
        return keyVal(key, value, false);
    }

    /**
     * Gets VK API method URL.
     *
     * @return method URL.
     */
    protected abstract String getApi();

    /**
     * Gets request method type.
     *
     * @return request method type.
     */
    protected abstract Connection.Method getMethod();

    /**
     * Gets JsonObject to POJO converter.
     *
     * @return JsonObject to POJO converter.
     */
    protected abstract JsonToPojoConverter<Result> getConverter();

    /**
     * Get stream of request parameters.
     *
     * @return stream of request parameters.
     */
    protected abstract Stream<Connection.KeyVal> getKeyValStream();
}
