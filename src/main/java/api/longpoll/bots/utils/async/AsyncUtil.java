package api.longpoll.bots.utils.async;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;

/**
 * Async executor.
 */
public class AsyncUtil {
    /**
     * Executes async operation.
     *
     * @param callable operation to be done.
     * @param <T>      operation type.
     * @return operation result.
     */
    public static <T> CompletableFuture<T> callAsync(Callable<T> callable) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                return callable.call();
            } catch (Exception e) {
                throw new CompletionException(e);
            }
        });
    }
}
