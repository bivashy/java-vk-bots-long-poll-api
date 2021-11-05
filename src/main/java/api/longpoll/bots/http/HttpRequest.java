package api.longpoll.bots.http;

import java.util.Map;

public interface HttpRequest {
    String getRequestMethod();
    String getUrl();
    Map<String, String> getParams();
    MultipartFormData getMultipartFormData();
}
