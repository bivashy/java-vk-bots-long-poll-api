package api.longpoll.bots.http;

/**
 * HTTP response wrapper.
 */
public class HttpResponse {
    /**
     * HTTP status code.
     */
    private int statusCode;

    /**
     * Response body.
     */
    private String body;

    public HttpResponse(int statusCode) {
        this.statusCode = statusCode;
    }

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

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public void setBody(String body) {
        this.body = body;
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
