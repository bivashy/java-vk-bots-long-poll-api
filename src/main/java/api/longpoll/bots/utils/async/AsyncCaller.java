package api.longpoll.bots.utils.async;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;

/**
 * Async caller.
 */
public interface AsyncCaller {
    /**
     * Calls operation asynchronously.
     *
     * @param callable operation to be done.
     * @param <T>      operation type.
     * @return operation result.
     */
    <T> CompletableFuture<T> call(Callable<T> callable);
}
