package api.longpoll.bots.http.impl;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.BufferedSink;
import okio.Okio;
import okio.Source;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.nio.file.Path;

public class PathRequestBody extends RequestBody {
    private final Path path;
    private final MediaType contentType;

    public PathRequestBody(Path path) {
        this.path = path;
        this.contentType = MediaType.get(HttpURLConnection.guessContentTypeFromName(path.getFileName().toString()));
    }

    @Nullable
    @Override
    public MediaType contentType() {
        return contentType;
    }

    @Override
    public void writeTo(@NotNull BufferedSink bufferedSink) throws IOException {
        try (Source source = Okio.source(path)) {
            bufferedSink.writeAll(source);
        }
    }
}
