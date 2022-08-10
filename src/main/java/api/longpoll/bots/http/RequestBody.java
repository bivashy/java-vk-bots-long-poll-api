package api.longpoll.bots.http;

import java.util.Map;

/**
 * HTTP request body wrapper.
 */
public interface RequestBody {
    /**
     * Gets request body headers.
     *
     * @return HTTP headers.
     */
    Map<String, String> getHeaders();
}
