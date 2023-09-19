package api.longpoll.bots.http;

import okhttp3.FormBody;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;

import java.io.IOException;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Logs HTTP request and response to provided {@link Logger}.
 */
public class LoggerInterceptor implements Interceptor {
    /**
     * {@link Logger} instance.
     */
    private final Logger logger;

    public LoggerInterceptor(Logger logger) {
        this.logger = logger;
    }

    @NotNull
    @Override
    public Response intercept(@NotNull Chain chain) throws IOException {
        Request request = chain.request();

        RequestBody body = request.body();
        logger.debug(
                "--> {} {} {} {}",
                request.method(),
                request.url() + getQueryParams(body),
                body != null ? "Content-Type: " + body.contentType() : "",
                body != null ? "Content-Length: " + body.contentLength() : ""
        );

        long start = System.currentTimeMillis();
        Response response = chain.proceed(request);
        long end = System.currentTimeMillis();

        ResponseBody responseBody = response.body();
        String stringBody = responseBody != null ? responseBody.string() : "{}";

        logger.debug(
                "<-- {}ms: {} {}",
                end - start,
                response.code(),
                stringBody
        );

        ResponseBody responseBodyCopy = responseBody != null
                ? ResponseBody.create(stringBody, responseBody.contentType())
                : ResponseBody.create(new byte[0], null);
        response.close();
        return response.newBuilder().body(responseBodyCopy).build();
    }

    /**
     * Gets query params as {@link String} if {@link RequestBody} is instance of {@link FormBody}.
     * Returns empty string ({@code ""}) otherwise.
     *
     * @param requestBody request body.
     * @return query params as {@link String} if {@link RequestBody} is instance of {@link FormBody}, and empty string
     * ({@code ""}) otherwise.
     */
    private String getQueryParams(RequestBody requestBody) {
        if (requestBody instanceof FormBody) {
            FormBody formBody = (FormBody) requestBody;
            int size = formBody.size();
            if (size > 0) {
                return "?" + IntStream.range(0, size)
                        .mapToObj(i -> formBody.encodedName(i) + "=" + formBody.encodedValue(i))
                        .collect(Collectors.joining("&"));
            }
        }
        return "";
    }
}
