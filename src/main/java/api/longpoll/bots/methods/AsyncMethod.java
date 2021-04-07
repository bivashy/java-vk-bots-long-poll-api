package api.longpoll.bots.methods;

import api.longpoll.bots.exceptions.BotsLongPollAPIException;
import api.longpoll.bots.exceptions.BotsLongPollException;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Generic method which executes requests to VK API asynchronously.
 *
 * @param <Result> VK API response type.
 */
public abstract class AsyncMethod<Result> extends Method<Result> {
    private static final ExecutorService EXECUTOR_SERVICE = Executors.newCachedThreadPool();

    /**
     * Executes request to VK API.
     *
     * @return VK API response.
     */
    public CompletableFuture<Result> executeAsync() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                return execute();
            } catch (BotsLongPollAPIException | BotsLongPollException e) {
                throw new CompletionException(e);
            }
        }, EXECUTOR_SERVICE);
    }
}
