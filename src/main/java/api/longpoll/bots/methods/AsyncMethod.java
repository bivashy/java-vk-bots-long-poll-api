package api.longpoll.bots.methods;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Consumer;

/**
 * Generic method which executes requests to VK API asynchronously.
 *
 * @param <Result> VK API response type.
 */
public abstract class AsyncMethod<Result> extends Method<Result> {
    private static final Logger log = LoggerFactory.getLogger(AsyncMethod.class);
    private static final ExecutorService EXECUTOR_SERVICE = Executors.newCachedThreadPool();
    private static final Consumer<Exception> DEFAULT_EXCEPTION_HANDLER = e -> log.error("Error during async execution.", e);

    /**
     * Executes request to VK API.
     *
     * @return VK API response.
     */
    public CompletableFuture<Result> executeAsync() {
        return executeAsync(DEFAULT_EXCEPTION_HANDLER);
    }

    /**
     * Executes request to VK API.
     *
     * @param exceptionHandler consumer to handle possible errors during async execution.
     * @return VK API response.
     */
    public CompletableFuture<Result> executeAsync(Consumer<Exception> exceptionHandler) {
        return executeAsync(this::execute, exceptionHandler);
    }

    /**
     * Executes request to VK API.
     *
     * @param callable         operation to be done asynchronously.
     * @param exceptionHandler consumer to handle possible errors during async execution.
     * @return VK API response.
     */
    private CompletableFuture<Result> executeAsync(Callable<Result> callable, Consumer<Exception> exceptionHandler) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                return callable.call();
            } catch (Exception e) {
                exceptionHandler.accept(e);
                return null;
            }
        }, EXECUTOR_SERVICE);
    }
}
