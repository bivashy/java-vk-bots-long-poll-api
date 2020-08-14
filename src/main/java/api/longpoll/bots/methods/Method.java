package api.longpoll.bots.methods;

import api.longpoll.bots.converters.Converter;
import api.longpoll.bots.converters.JsonToPojoConverter;
import api.longpoll.bots.converters.StringToJsonConverterImpl;
import api.longpoll.bots.exceptions.ApiException;
import api.longpoll.bots.exceptions.ApiHttpException;
import api.longpoll.bots.validators.Validator;
import api.longpoll.bots.validators.impl.ResponseValidator;
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

public abstract class Method<Result> {
	private static final Logger log = LoggerFactory.getLogger(Method.class);

	private Converter<String, JsonObject> jsonConverter = new StringToJsonConverterImpl();
	private Validator validator = new ResponseValidator();

	public Result execute() throws ApiHttpException {
		return execute(getConverter());
	}

	private Result execute(JsonToPojoConverter<Result> converter) throws ApiHttpException {
		String stringResponse = sendRequest();

		JsonObject responseJson = jsonConverter.convert(stringResponse);

		if (validator.isValid(responseJson)) {
			return converter.convert(responseJson);
		}

		throw new ApiException(responseJson.toString());
	}

	private String sendRequest() throws ApiHttpException {
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
			throw new ApiHttpException(e);
		}
	}

	protected Connection.Response execute(Connection connection) throws IOException {
		return connection.execute();
	}

	protected List<Connection.KeyVal> getData() {
		return getKeyValStream()
				.filter(Objects::nonNull)
				.collect(Collectors.toList());
	}

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

	protected Connection.KeyVal keyVal(String key, Object value) {
		return keyVal(key, value, false);
	}

	protected abstract String getApi();

	protected abstract Connection.Method getMethod();

	protected abstract JsonToPojoConverter<Result> getConverter();

	protected abstract Stream<Connection.KeyVal> getKeyValStream();
}
