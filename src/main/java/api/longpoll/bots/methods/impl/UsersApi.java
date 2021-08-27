package api.longpoll.bots.methods.impl;

import api.longpoll.bots.methods.impl.users.Get;

/**
 * Provides Users methods.
 */
public class UsersApi extends AbstractVkApi {
    public UsersApi(String accessToken) {
        super(accessToken);
    }

    public Get get() {
        return new Get(getAccessToken());
    }
}
