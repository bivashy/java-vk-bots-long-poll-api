package api.longpoll.bots.methods;

import api.longpoll.bots.methods.impl.users.Get;

import java.util.function.Supplier;

/**
 * Provides Users methods.
 */
public class UsersMethods {
    /**
     * Access token.
     */
    private final Supplier<String> accessTokenSupplier;

    public UsersMethods(Supplier<String> accessTokenSupplier) {
        this.accessTokenSupplier = accessTokenSupplier;
    }

    public Get get() {
        return new Get(accessTokenSupplier.get());
    }
}
