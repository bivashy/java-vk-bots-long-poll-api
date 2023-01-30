package api.longpoll.bots.http.impl;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.BufferedSink;
import okio.Okio;
import okio.Source;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.IOException;
import java.io.InputStream;
import java.net.URLConnection;

public class InputStreamRequestBody extends RequestBody {
    private final MediaType contentType;

    /**
     * File.
     */
    private final InputStream file;

    public InputStreamRequestBody(String filename, InputStream file) {
        this.contentType = MediaType.get(URLConnection.guessContentTypeFromName(filename));
        this.file = file;
    }

    @Nullable
    @Override
    public MediaType contentType() {
        return contentType;
    }

    @Override
    public void writeTo(@NotNull BufferedSink bufferedSink) throws IOException {
        try (Source source = Okio.source(file)) {
            bufferedSink.writeAll(source);
        }
    }
}
