package api.longpoll.bots.http;

/**
 * HTTP request body wrapper.
 */
public interface RequestBody {
    /**
     * Gets Content-Type.
     *
     * @return Content-Type.
     */
    String getContentType();
}
