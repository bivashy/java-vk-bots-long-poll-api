package api.longpoll.bots.http;

import java.util.Map;

/**
 * HTTP request wrapper.
 */
public interface HttpRequest {
    /**
     * Gets HTTP method. E.g. GET or POST.
     *
     * @return HTTP method.
     */
    String getRequestMethod();

    /**
     * Gets HTTP request URL.
     *
     * @return HTTP request URL.
     */
    String getUrl();

    /**
     * Gets HTTP request URL params.
     *
     * @return HTTP request URL params.
     */
    Map<String, String> getParams();

    /**
     * Get HTTP request multipart form data.
     *
     * @return HTTP request multipart form data.
     */
    MultipartFormData getMultipartFormData();

    /**
     * Whether this request has params.
     *
     * @return <b>true</b> if this request has params, <b>false</b> otherwise.
     */
    default boolean hasParams() {
        return getParams() != null && !getParams().isEmpty();
    }

    /**
     * Whether this request has Multipart Form Data.
     *
     * @return <b>true</b> if this request has Multipart Form Data, <b>false</b> otherwise.
     */
    default boolean hasMultipartFormData() {
        return getMultipartFormData() != null;
    }
}
