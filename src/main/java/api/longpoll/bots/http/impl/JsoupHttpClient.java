package api.longpoll.bots.http.impl;

import api.longpoll.bots.http.HttpClient;
import api.longpoll.bots.http.HttpRequest;
import org.jsoup.Connection;
import org.jsoup.Jsoup;

import java.io.IOException;

/**
 * Implementation of {@link HttpClient} based on {@link Jsoup}.
 */
public class JsoupHttpClient implements HttpClient {
    @Override
    public String execute(HttpRequest httpRequest) throws IOException {
        Connection connection = Jsoup.connect(httpRequest.getUrl())
                .ignoreContentType(true)
                .timeout(0)
                .method(getMethod(httpRequest.getRequestMethod()));

        if (httpRequest.getParams() != null && !httpRequest.getParams().isEmpty()) {
            connection.data(httpRequest.getParams());
        }

        if (httpRequest.getMultipartFormData() != null) {
            return connection.data(
                            httpRequest.getMultipartFormData().getKey(),
                            httpRequest.getMultipartFormData().getFilename(),
                            httpRequest.getMultipartFormData().getInputStream()
                    )
                    .execute()
                    .body();
        }

        return connection.execute().body();

    }

    public Connection.Method getMethod(String method) {
        switch (method) {
            case "POST":
                return Connection.Method.POST;
            case "GET":
            default:
                return Connection.Method.GET;
        }
    }
}
