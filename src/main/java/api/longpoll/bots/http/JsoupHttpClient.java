package api.longpoll.bots.http;

import org.jsoup.Connection;
import org.jsoup.Jsoup;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

/**
 * Implementation of {@link HttpClient} based on {@link Jsoup}.
 */
public class JsoupHttpClient implements HttpClient {
    private Connection.Method method;
    private String url;
    private Map<String, String> params;
    private MultipartData multipartData;

    @Override
    public HttpClient setMethod(String method) {
        switch (method.toLowerCase()) {
            case "get":
                this.method = Connection.Method.GET;
                break;

            case "post":
                this.method = Connection.Method.POST;
                break;
        }
        return this;
    }

    @Override
    public HttpClient setUrl(String url) {
        this.url = url;
        return this;
    }

    @Override
    public HttpClient setParams(Map<String, String> params) {
        this.params = params;
        return this;
    }

    @Override
    public HttpClient setFile(String key, String fileName, File file) {
        multipartData = new MultipartData(key, fileName, file);
        return this;
    }

    @Override
    public String execute() throws IOException {
        Connection connection = Jsoup.connect(url)
                .ignoreContentType(true)
                .timeout(0)
                .method(this.method);

        if (params != null && !params.isEmpty()) {
            connection.data(params);
        }

        if (multipartData != null) {
            try (InputStream inputStream = new FileInputStream(multipartData.getFile())) {
                return connection.data(multipartData.getKey(), multipartData.getFileName(), inputStream)
                        .execute()
                        .body();
            }
        }

        return connection.execute().body();

    }

    /**
     * Multipart data to be uploaded.
     */
    private static class MultipartData {
        /**
         * Param name.
         */
        private String key;

        /**
         * File name.
         */
        private String fileName;

        /**
         * File to upload.
         */
        private File file;

        public MultipartData(String key, String fileName, File file) {
            this.key = key;
            this.fileName = fileName;
            this.file = file;
        }

        public String getKey() {
            return key;
        }

        public String getFileName() {
            return fileName;
        }

        public File getFile() {
            return file;
        }
    }
}