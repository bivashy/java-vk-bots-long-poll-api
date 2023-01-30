package api.longpoll.bots.methods.impl;

import api.longpoll.bots.exceptions.VkApiException;
import api.longpoll.bots.helpers.properties.VkProperties;
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

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Executes generic HTTP request to VK API.
 *
 * @param <VkResponse> VK API response type.
 */
public abstract class VkMethod<VkResponse> {
    /**
     * Path to VK methods list.
     */
    private static final String VK_PROPERTIES_PATH = "/vk/vk_methods.properties";

    /**
     * Access token key.
     */
    private static final String ACCESS_TOKEN_KEY = "access_token";

    private static final long CALL_TIMEOUT = 50;

    /**
     * VK API version key.
     */
    private static final String API_VERSION_KEY = "v";

    /**
     * VK API version value.
     */
    private static final String API_VERSION_VALUE = "5.131";

    /**
     * VK methods.
     */
    private static final VkProperties VK_PROPERTIES = new VkProperties(VK_PROPERTIES_PATH);

    /**
     * Validator to check if VK API response is valid.
     */
    private final Predicate<String> responseBodyValidator = new VkResponseBodyValidator();

    /**
     * {@link Gson} instance.
     */
    private final Gson gson = new Gson();

    private final Request.Builder requestBuilder = new Request.Builder();

    private final FormBody.Builder formBodyBuilder = new FormBody.Builder();

    private final OkHttpClient okHttpClient = new OkHttpClient.Builder()
            .callTimeout(CALL_TIMEOUT, TimeUnit.SECONDS)
            .build();

    /**
     * Access token.
     */
    private String accessToken;

    public VkMethod(String url, String accessToken) {
        this.requestBuilder.url(url);
        this.accessToken = accessToken;
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
     * Gets request URI.
     *
     * @return request URI.
     */
    public abstract String getUri();

    private Request newRequest() {
        return requestBuilder.post(newRequestBody()).build();
    }

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

    /**
     * Gets {@link VkMethod#gson} object.
     *
     * @return {@link VkMethod#gson} object.
     */
    protected Gson getGson() {
        return gson;
    }

    /**
     * Converts list of objects to comma separated values.
     *
     * @param values list of objects.
     * @return comma separated values.
     */
    protected String csv(List<?> values) {
        return values.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(","));
    }

    /**
     * Gets a property from {@link VkMethod#VK_PROPERTIES}.
     *
     * @param key property key.
     * @return property value.
     */
    protected static String property(String key) {
        return VK_PROPERTIES.getProperty(key);
    }

    /**
     * Gets {@link VkMethod#accessToken}.
     *
     * @return {@link VkMethod#accessToken}.
     */
    protected String getAccessToken() {
        return accessToken;
    }
}
