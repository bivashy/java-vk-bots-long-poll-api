package api.longpoll.bots.methods.impl;

/**
 * Provides all VK APIs available for Bots.
 */
public class VkBotsApi {
    /**
     * Bot access token.
     */
    private final String accessToken;

    public VkBotsApi(String accessToken) {
        this.accessToken = accessToken;
    }

    public BoardApi board() {
        return new BoardApi(accessToken);
    }

    public DocsApi docs() {
        return new DocsApi(accessToken);
    }

    public GroupsApi groups() {
        return new GroupsApi(accessToken);
    }

    public MarketApi market() {
        return new MarketApi(accessToken);
    }

    public MessagesApi messages() {
        return new MessagesApi(accessToken);
    }

    public PhotosApi photos() {
        return new PhotosApi(accessToken);
    }

    public StoriesApi stories() {
        return new StoriesApi(accessToken);
    }

    public UsersApi users() {
        return new UsersApi(accessToken);
    }

    public UtilsApi utils() {
        return new UtilsApi(accessToken);
    }

    public WallApi wall() {
        return new WallApi(accessToken);
    }
}
