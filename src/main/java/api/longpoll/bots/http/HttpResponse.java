package api.longpoll.bots.http;

/**
 * HTTP response wrapper.
 */
public class HttpResponse {
    /**
     * HTTP status code.
     */
    private final int statusCode;

    /**
     * Response body.
     */
    private final String body;

    public HttpResponse(int statusCode, String body) {
        this.statusCode = statusCode;
        this.body = body;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getBody() {
        return body;
    }

    @Override
    public String toString() {
        return String.format(
                "Status Code=%d, Body=%s",
                statusCode,
                body
        );
    }
}
