package api.longpoll.bots.http.impl;

import api.longpoll.bots.http.HttpClient;
import api.longpoll.bots.http.HttpRequest;
import api.longpoll.bots.http.HttpResponse;
import api.longpoll.bots.http.RequestBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

/**
 * Default implementation of HTTP client.
 */
public class DefaultHttpClient implements HttpClient {
    /**
     * {@link Logger} object.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(DefaultHttpClient.class);

    /**
     * New line.
     */
    private static final String CRLF = "\r\n";

    @Override
    public HttpResponse execute(HttpRequest httpRequest) throws IOException {
        if (!"POST".equals(httpRequest.getRequestMethod())) {
            throw new UnsupportedOperationException("Sending " + httpRequest.getRequestMethod() + " requests is not supported.");
        }

        HttpURLConnection httpURLConnection = null;
        try {
            long startTime = System.currentTimeMillis();
            httpURLConnection = (HttpURLConnection) new URL(httpRequest.getUri()).openConnection();
            httpURLConnection.setRequestMethod(httpRequest.getRequestMethod());
            httpURLConnection.setDoOutput(true);

            httpRequest.getHeaders().forEach(httpURLConnection::setRequestProperty);
            RequestBody requestBody = httpRequest.getRequestBody();

            if (requestBody instanceof FormUrlencoded) {
                sendFormUrlencoded(httpURLConnection, (FormUrlencoded) requestBody);
            } else if (requestBody instanceof MultipartFormData) {
                sendMultipartFormData(httpURLConnection, (MultipartFormData) requestBody);
            } else {
                throw new UnsupportedOperationException("RequestBody " + requestBody.getClass() + " is not supported.");
            }

            HttpResponse httpResponse = readResponse(httpURLConnection);
            long endTime = System.currentTimeMillis();
            logExecution(httpRequest, httpResponse, endTime - startTime);
            return httpResponse;
        } finally {
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
        }
    }

    /**
     * Reads response from {@link HttpURLConnection}.
     *
     * @param httpURLConnection response source.
     * @return HTTP response.
     * @throws IOException if errors occur.
     */
    private HttpResponse readResponse(HttpURLConnection httpURLConnection) throws IOException {
        DefaultHttpResponse.Builder httpResponseBuilder = new DefaultHttpResponse.Builder()
                .setResponseCode(httpURLConnection.getResponseCode())
                .setResponseMessage(httpURLConnection.getResponseMessage());

        httpURLConnection.getHeaderFields().forEach((key, value) -> httpResponseBuilder.addHeader(key, String.join(",", value)));

        InputStream inputStream = httpURLConnection.getResponseCode() < HttpURLConnection.HTTP_BAD_REQUEST
                ? httpURLConnection.getInputStream()
                : httpURLConnection.getErrorStream();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8))) {
            httpResponseBuilder.setBody(reader.lines().collect(Collectors.joining()));
        }

        return httpResponseBuilder.build();
    }

    /**
     * Sends multipart/form-data.
     *
     * @param httpURLConnection destination.
     * @param requestBody       data to send.
     * @throws IOException if errors occur.
     */
    private void sendMultipartFormData(HttpURLConnection httpURLConnection, MultipartFormData requestBody) throws IOException {
        if (!(requestBody.getFormInput() instanceof FileInput)) {
            throw new UnsupportedOperationException("FormInput " + requestBody.getFormInput().getClass() + " is not supported.");
        }

        try (PrintWriter writer = new PrintWriter(new OutputStreamWriter(httpURLConnection.getOutputStream(), StandardCharsets.UTF_8), true)) {
            FileInput fileInput = (FileInput) requestBody.getFormInput();
            writer.append("--").append(requestBody.getBoundary()).append(CRLF);
            writer.append("Content-Disposition: form-data; name=\"").append(fileInput.getName()).append("\"; filename=\"").append(fileInput.getFilename()).append("\"").append(CRLF);
            writer.append("Content-Type: ").append(HttpURLConnection.guessContentTypeFromName(fileInput.getFilename())).append(CRLF);
            writer.append("Content-Transfer-Encoding: binary").append(CRLF);
            writer.append(CRLF);
            writer.flush();

            copy(fileInput.getInputStream(), httpURLConnection.getOutputStream());

            writer.append(CRLF);
            writer.append("--").append(requestBody.getBoundary()).append("--").append(CRLF);
            writer.flush();
        }
    }

    /**
     * Sends application/x-www-form-urlencoded data.
     *
     * @param httpURLConnection destination.
     * @param requestBody       data to send.
     * @throws IOException if errors occur.
     */
    private void sendFormUrlencoded(HttpURLConnection httpURLConnection, FormUrlencoded requestBody) throws IOException {
        try (DataOutputStream output = new DataOutputStream(httpURLConnection.getOutputStream())) {
            output.writeBytes(requestBody.getBody());
            output.flush();
        }
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

    /**
     * Logs execution info.
     *
     * @param request       executed request.
     * @param response      received response.
     * @param executionTime execution time.
     */
    private void logExecution(HttpRequest request, HttpResponse response, long executionTime) {
        RequestBody requestBody = request.getRequestBody();
        LOGGER.debug(
                "\nRequest:\n\tHeaders: {}\n\tMethod: {}\n\tURI: {}\n\tPayload: {}\n\tTime: {}\nResponse:\n\tStatus: {}\n\tHeaders: {}\n\tBody: {}",
                request.getHeaders(),
                request.getRequestMethod(),
                request.getUri(),
                requestBody instanceof FormUrlencoded ? ((FormUrlencoded) requestBody).getBody() : "-",
                executionTime,
                response.getResponseMessage(),
                response.getHeaders(),
                response.getBody()
        );
    }
}
