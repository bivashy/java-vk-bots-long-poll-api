package api.longpoll.bots.http;

import java.io.InputStream;

public class MultipartFormData {
    private String key;
    private String filename;
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
