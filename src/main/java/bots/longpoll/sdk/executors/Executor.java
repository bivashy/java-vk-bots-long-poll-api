package bots.longpoll.sdk.executors;

import bots.longpoll.sdk.converters.Converter;
import bots.longpoll.sdk.converters.JsonToPojoConverter;
import bots.longpoll.sdk.converters.StringToJsonConverterImpl;
import bots.longpoll.sdk.exceptions.ApiException;
import bots.longpoll.sdk.exceptions.ApiHttpException;
import bots.longpoll.sdk.validators.Validator;
import bots.longpoll.sdk.validators.impl.ResponseValidator;
import com.google.gson.JsonObject;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.helper.HttpConnection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public abstract class Executor<Response> {
	private static final Logger log = LoggerFactory.getLogger(Executor.class);

	private Converter<String, JsonObject> jsonConverter = new StringToJsonConverterImpl();
	private Validator validator = new ResponseValidator();

	protected Map<String, Object> params = new HashMap<>();

	public Response execute() throws ApiHttpException {
		return execute(getConverter());
	}

	private Response execute(JsonToPojoConverter<Response> converter) throws ApiHttpException {
		String stringResponse = send();

		JsonObject responseJson = jsonConverter.convert(stringResponse);

		if (validator.isValid(responseJson)) {
			return converter.convert(responseJson);
		}

		throw new ApiException(responseJson.toString());
	}

	private String send() throws ApiHttpException {
		try {
			String api = getApi();
			Connection.Method method = getMethod();
			List<Connection.KeyVal> data = getData();

			log.debug("Sending: method={}, api={}, data={}", method, api, data);

			String body = Jsoup.connect(api)
					.ignoreContentType(true)
					.timeout(0)
					.method(method)
					.data(data)
					.execute()
					.body();

			log.debug("Received: {}", body);

			return body;
		} catch (IOException e) {
			log.error("Failed to send request {}.", getMethod(), e);
			throw new ApiHttpException(e);
		}
	}

	protected List<Connection.KeyVal> getData() {
		return params.entrySet()
				.stream()
				.map(entry -> keyVal(entry.getKey(), entry.getValue()))
				.collect(Collectors.toList());
	}

	protected Connection.KeyVal keyVal(String key, Object value) {
		if (value instanceof List) {
			value = ((List) value).stream().map(String::valueOf).collect(Collectors.joining(","));
		}
		return HttpConnection.KeyVal.create(key, String.valueOf(value));
	}

	protected Connection.KeyVal keyVal(String key, String name, InputStream inputStream) {
		return HttpConnection.KeyVal.create(key, name, inputStream);
	}

	protected abstract String getApi();

	protected abstract Connection.Method getMethod();

	protected abstract JsonToPojoConverter<Response> getConverter();
}
