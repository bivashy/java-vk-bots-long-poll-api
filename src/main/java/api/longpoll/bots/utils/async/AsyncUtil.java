package api.longpoll.bots.utils.async;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AsyncUtil {
    private static final ExecutorService EXECUTOR_SERVICE = Executors.newCachedThreadPool();

    public static <T> CompletableFuture<T> callAsync(Callable<T> callable) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                return callable.call();
            } catch (Exception e) {
                throw new CompletionException(e);
            }
        }, EXECUTOR_SERVICE);
    }

    public static void stopChildProcesses() {
        EXECUTOR_SERVICE.shutdown();
    }
}
