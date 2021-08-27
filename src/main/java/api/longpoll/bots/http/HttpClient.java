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
     * @return {@link HttpClient} instance.
     */
    HttpClient setMethod(String method);

    /**
     * Sets request URL.
     *
     * @param url request URL.
     * @return {@link HttpClient} instance.
     */
    HttpClient setUrl(String url);

    /**
     * Sets request URL params.
     *
     * @param params URL params.
     * @return {@link HttpClient} instance.
     */
    HttpClient setParams(Map<String, String> params);

    /**
     * Sets file to be uploaded.
     *
     * @param key      param name.
     * @param fileName file name.
     * @param file     file to upload.
     * @return {@link HttpClient} instance.
     */
    HttpClient setFile(String key, String fileName, File file);

    /**
     * Executes HTTP request.
     *
     * @return response bode.
     * @throws IOException if errors occur.
     */
    String execute() throws IOException;
}
