package api.longpoll.bots.http.impl;

import api.longpoll.bots.http.HttpClient;
import api.longpoll.bots.http.HttpRequest;
import api.longpoll.bots.http.HttpResponse;
import api.longpoll.bots.http.MultipartFormData;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * Default implementation of HTTP client.
 */
public class DefaultHttpClient implements HttpClient {
    /**
     * New line.
     */
    private static final String CRLF = "\r\n";

    @Override
    public HttpResponse execute(HttpRequest httpRequest) throws IOException {
        HttpURLConnection httpURLConnection = null;
        try {
            httpURLConnection = (HttpURLConnection) new URL(httpRequest.getUrl()).openConnection();
            httpURLConnection.setRequestMethod(httpRequest.getRequestMethod());
            httpURLConnection.setDoOutput(true);

            if (httpRequest.hasParams()) {
                try (DataOutputStream output = new DataOutputStream(httpURLConnection.getOutputStream())) {
                    output.writeBytes(toUrlParams(httpRequest.getParams()));
                    output.flush();
                }
            } else if (httpRequest.hasMultipartFormData()) {
                MultipartFormData multipartFormData = httpRequest.getMultipartFormData();
                String boundary = UUID.randomUUID().toString();
                httpURLConnection.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundary);

                try (PrintWriter writer = new PrintWriter(new OutputStreamWriter(httpURLConnection.getOutputStream(), StandardCharsets.UTF_8), true)) {
                    writer.append("--").append(boundary).append(CRLF);
                    writer.append("Content-Disposition: form-data; name=\"").append(multipartFormData.getKey()).append("\"; filename=\"").append(multipartFormData.getFilename()).append("\"").append(CRLF);
                    writer.append("Content-Type: ").append(HttpURLConnection.guessContentTypeFromName(multipartFormData.getFilename())).append(CRLF);
                    writer.append("Content-Transfer-Encoding: binary").append(CRLF);
                    writer.append(CRLF);
                    writer.flush();

                    copy(multipartFormData.getInputStream(), httpURLConnection.getOutputStream());

                    writer.append(CRLF);
                    writer.append("--").append(boundary).append("--").append(CRLF);
                    writer.flush();
                }
            }

            HttpResponse httpResponse = new HttpResponse(httpURLConnection.getResponseCode());
            if (httpResponse.getStatusCode() >= 200 && httpResponse.getStatusCode() < 300) {
                try (BufferedReader reader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream(), StandardCharsets.UTF_8))) {
                    httpResponse.setBody(reader.lines().collect(Collectors.joining()));
                }
            }
            return httpResponse;
        } finally {
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
        }
    }

    /**
     * Converts params Map to URL params.
     *
     * @param params params Map.
     * @return URL params.
     * @throws UnsupportedEncodingException when failed to encode params.
     */
    private String toUrlParams(Map<String, String> params) throws UnsupportedEncodingException {
        List<String> paramsList = new ArrayList<>(params.size());
        for (Map.Entry<String, String> entry : params.entrySet()) {
            paramsList.add(encode(entry.getKey()) + "=" + encode(entry.getValue()));
        }
        return String.join("&", paramsList);
    }

    /**
     * Encodes string value with UTF-8 encoding.
     *
     * @param s string to encode.
     * @return encoded string.
     * @throws UnsupportedEncodingException when failed to encode.
     */
    private String encode(String s) throws UnsupportedEncodingException {
        return URLEncoder.encode(s, "UTF-8");
    }

    /**
     * Reads data from {@link InputStream} and writes to {@link OutputStream}.
     *
     * @param from source.
     * @param to   target.
     * @throws IOException when errors occur.
     */
    private void copy(InputStream from, OutputStream to) throws IOException {
        byte[] buffer = new byte[4096];
        int bytesRead;
        while ((bytesRead = from.read(buffer)) != -1) {
            to.write(buffer, 0, bytesRead);
        }
        to.flush();
    }
}
