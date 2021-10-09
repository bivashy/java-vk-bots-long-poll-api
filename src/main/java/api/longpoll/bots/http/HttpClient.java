package api.longpoll.bots.http;

import java.io.File;
import java.io.IOException;
import java.util.Map;

/**
 * HTTP client to send HTTP requests.
 */
public interface HttpClient {
    /**
     * Sets HTTP method. E.g. "GET" or "POST".
     *
     * @param method HTTP method.
     */
    void setMethod(String method);

    /**
     * Sets request URL.
     *
     * @param url request URL.
     */
    void setUrl(String url);

    /**
     * Sets request URL params.
     *
     * @param params URL params.
     */
    void setParams(Map<String, String> params);

    /**
     * Sets file to be uploaded.
     *
     * @param key      param name.
     * @param fileName file name.
     * @param file     file to upload.
     */
    void setFile(String key, String fileName, File file);

    /**
     * Executes HTTP request.
     *
     * @return response body.
     * @throws IOException if errors occur.
     */
    String execute() throws IOException;
}
