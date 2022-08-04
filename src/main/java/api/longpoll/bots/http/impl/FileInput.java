package api.longpoll.bots.http.impl;

import api.longpoll.bots.http.FormInput;

import java.io.InputStream;

/**
 * {@code <input type="file">} wrapper.
 */
public class FileInput implements FormInput {
    /**
     * Input name.
     */
    private final String name;

    /**
     * Filename.
     */
    private final String filename;

    /**
     * File {@link InputStream}.
     */
    private final InputStream inputStream;

    public FileInput(String name, String filename, InputStream inputStream) {
        this.name = name;
        this.filename = filename;
        this.inputStream = inputStream;
    }

    public String getName() {
        return name;
    }

    public String getFilename() {
        return filename;
    }

    public InputStream getInputStream() {
        return inputStream;
    }

    @Override
    public String toString() {
        return "FileInput{" +
                "name='" + name + '\'' +
                ", filename='" + filename + '\'' +
                ", inputStream=" + inputStream +
                '}';
    }
}
