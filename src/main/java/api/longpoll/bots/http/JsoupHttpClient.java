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
    public void setMethod(String method) {
        switch (method.toLowerCase()) {
            case "get":
                this.method = Connection.Method.GET;
                break;

            case "post":
                this.method = Connection.Method.POST;
                break;
        }
    }

    @Override
    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public void setParams(Map<String, String> params) {
        this.params = params;
    }

    @Override
    public void setFile(String key, String fileName, File file) {
        multipartData = new MultipartData(key, fileName, file);
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
        private final String key;

        /**
         * File name.
         */
        private final String fileName;

        /**
         * File to upload.
         */
        private final File file;

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
