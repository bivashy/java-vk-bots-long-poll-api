package api.longpoll.bots.validator;

import api.longpoll.bots.http.HttpResponse;

import java.net.HttpURLConnection;
import java.util.function.Predicate;

/**
 * Validates Vk HTTP response.
 */
public class VkResponseValidator implements Predicate<HttpResponse> {
    @Override
    public boolean test(HttpResponse response) {
        return response.getResponseCode() < HttpURLConnection.HTTP_BAD_REQUEST;
    }
}
