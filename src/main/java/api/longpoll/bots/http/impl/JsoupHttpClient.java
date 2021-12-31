package api.longpoll.bots.http.impl;

import api.longpoll.bots.http.HttpClient;
import api.longpoll.bots.http.HttpRequest;
import api.longpoll.bots.http.HttpResponse;
import org.jsoup.Connection;
import org.jsoup.Jsoup;

import java.io.IOException;

/**
 * Implementation of {@link HttpClient} based on {@link Jsoup}.
 */
public class JsoupHttpClient implements HttpClient {
    @Override
    public HttpResponse execute(HttpRequest httpRequest) throws IOException {
        Connection connection = Jsoup.connect(httpRequest.getUrl())
                .ignoreContentType(true)
                .timeout(0)
                .method(getMethod(httpRequest.getRequestMethod()));

        if (httpRequest.getParams() != null && !httpRequest.getParams().isEmpty()) {
            connection.data(httpRequest.getParams());
        }

        if (httpRequest.getMultipartFormData() != null) {
            connection.data(
                    httpRequest.getMultipartFormData().getKey(),
                    httpRequest.getMultipartFormData().getFilename(),
                    httpRequest.getMultipartFormData().getInputStream()
            );
        }

        Connection.Response response = connection.execute();
        return new HttpResponse(response.statusCode(), response.body());

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
