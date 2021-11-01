package api.longpoll.bots.methods.impl;

/**
 * Abstract VK API which requires access token.
 */
public abstract class AbstractVkApi {
    /**
     * Access token.
     */
    private String accessToken;

    public AbstractVkApi(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }
}
