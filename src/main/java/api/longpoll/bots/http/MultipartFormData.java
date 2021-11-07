package api.longpoll.bots.http;

import java.io.InputStream;

/**
 * Multipart form data wrapper.
 */
public class MultipartFormData {
    /**
     * Form data key.
     */
    private String key;

    /**
     * Name of file.
     */
    private String filename;

    /**
     * File {@link InputStream}.
     */
    private InputStream inputStream;

    public MultipartFormData(String key, String filename, InputStream inputStream) {
        this.key = key;
        this.filename = filename;
        this.inputStream = inputStream;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public InputStream getInputStream() {
        return inputStream;
    }

    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }


    @Override
    public String toString() {
        return "MultipartFormData{" +
                "key='" + key + '\'' +
                ", filename='" + filename + '\'' +
                ", inputStream=" + inputStream +
                '}';
    }
}
