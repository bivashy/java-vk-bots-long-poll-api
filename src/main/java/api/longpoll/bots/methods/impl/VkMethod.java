package api.longpoll.bots.methods.impl;

import api.longpoll.bots.exceptions.VkApiException;
import api.longpoll.bots.http.LoggerInterceptor;
import api.longpoll.bots.validator.VkResponseBodyValidator;
import com.google.gson.Gson;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.function.Predicate;

/**
 * Executes generic HTTP request to VK API.
 *
 * @param <VkResponse> VK API response type.
 */
public abstract class VkMethod<VkResponse> {
    /**
     * {@link Logger} instance.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(VkMethod.class);

    /**
     * Access token key.
     */
    private static final String ACCESS_TOKEN_KEY = "access_token";

    /**
     * VK API version key.
     */
    private static final String API_VERSION_KEY = "v";

    /**
     * VK API version value.
     */
    private static final String API_VERSION_VALUE = "5.131";

    /**
     * Validator to check if VK API response is valid.
     */
    private final Predicate<String> responseBodyValidator = new VkResponseBodyValidator();

    /**
     * {@link Gson} instance.
     */
    private final Gson gson = new Gson();

    /**
     * {@link Request} builder.
     */
    private final Request.Builder requestBuilder = new Request.Builder();

    /**
     * {@link FormBody} builder.
     */
    private final FormBody.Builder formBodyBuilder = new FormBody.Builder();

    /**
     * HTTP client.
     */
    private final OkHttpClient okHttpClient = new OkHttpClient.Builder()
            .callTimeout(32, TimeUnit.SECONDS)
            .readTimeout(32, TimeUnit.SECONDS)
            .addInterceptor(new LoggerInterceptor(LOGGER))
            .build();

    public VkMethod(String url, String accessToken) {
        this(url);
        addParam(ACCESS_TOKEN_KEY, accessToken);
        addParam(API_VERSION_KEY, API_VERSION_VALUE);
    }

    public VkMethod(String url) {
        this.requestBuilder.url(url);
    }

    /**
     * Executes request to VK API asynchronously.
     *
     * @return VK API response wrapped to CompletableFuture
     */
    public CompletableFuture<VkResponse> executeAsync() {
        CompletableFuture<VkResponse> completableFuture = new CompletableFuture<>();
        okHttpClient.newCall(newRequest()).enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                completableFuture.completeExceptionally(e);
                okHttpClient.dispatcher().executorService().shutdown();
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                try {
                    completableFuture.complete(extractResponse(response));
                } catch (VkApiException e) {
                    completableFuture.completeExceptionally(e);
                }
                okHttpClient.dispatcher().executorService().shutdown();
            }
        });
        return completableFuture;
    }

    /**
     * Executes request to VK API.
     *
     * @return VK API response.
     * @throws VkApiException if errors occur.
     */
    public VkResponse execute() throws VkApiException {
        try (Response response = okHttpClient.newCall(newRequest()).execute()) {
            return extractResponse(response);
        } catch (IOException e) {
            throw new VkApiException(e);
        }
    }

    /**
     * Gets {@link VkResponse} from {@link Response}.
     *
     * @param response HTTP response.
     * @return {@link VkResponse}.
     * @throws VkApiException if errors occur.
     * @throws IOException    if errors occur.
     */
    private VkResponse extractResponse(Response response) throws VkApiException, IOException {
        if (!response.isSuccessful()) {
            throw new VkApiException("Response code: " + response.code());
        }

        ResponseBody responseBody = response.body();
        if (responseBody == null) {
            throw new VkApiException("Response body is null.");
        }

        String stringBody = responseBody.string();
        if (responseBodyValidator.negate().test(stringBody)) {
            throw new VkApiException(stringBody);
        }

        return gson.fromJson(stringBody, getResponseClass());
    }

    /**
     * Gets a class of VK API response.
     * This value is used during deserialization of received JSON.
     *
     * @return a class of VK API response.
     */
    protected abstract Class<VkResponse> getResponseClass();

    /**
     * Supplies new HTTP request.
     *
     * @return HTTP request.
     */
    private Request newRequest() {
        return requestBuilder.post(newRequestBody()).build();
    }

    /**
     * Supplies new request body.
     *
     * @return request body.
     */
    protected RequestBody newRequestBody() {
        return formBodyBuilder.build();
    }

    /**
     * Adds URL parameter to HTTP request.
     *
     * @param key   URL parameter key.
     * @param value URL parameter value.
     * @return current instance.
     */
    public VkMethod<VkResponse> addParam(String key, Object value) {
        formBodyBuilder.add(key, String.valueOf(value));
        return this;
    }
}
