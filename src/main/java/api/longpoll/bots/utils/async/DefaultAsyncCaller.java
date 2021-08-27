package api.longpoll.bots.utils.async;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;

/**
 * Default async caller.
 */
public class DefaultAsyncCaller implements AsyncCaller {
    @Override
    public <T> CompletableFuture<T> call(Callable<T> callable) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                return callable.call();
            } catch (Exception e) {
                throw new CompletionException(e);
            }
        });
    }
}
