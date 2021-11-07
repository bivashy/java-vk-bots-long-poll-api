package api.longpoll.bots.methods;

import api.longpoll.bots.methods.impl.users.Get;

/**
 * Provides Users methods.
 */
public class UsersMethods {
    /**
     * Access token.
     */
    private final String accessToken;

    public UsersMethods(String accessToken) {
        this.accessToken = accessToken;
    }

    public Get get() {
        return new Get(accessToken);
    }
}
