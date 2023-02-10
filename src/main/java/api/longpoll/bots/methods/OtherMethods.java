package api.longpoll.bots.methods;

import api.longpoll.bots.methods.impl.other.Execute;

import java.util.function.Supplier;

/**
 * Provides other methods.
 */
public class OtherMethods {
    /**
     * {@code access_token}.
     */
    private final Supplier<String> accessTokenSupplier;

    public OtherMethods(Supplier<String> accessTokenSupplier) {
        this.accessTokenSupplier = accessTokenSupplier;
    }

    public Execute execute() {
        return new Execute(accessTokenSupplier.get());
    }
}
