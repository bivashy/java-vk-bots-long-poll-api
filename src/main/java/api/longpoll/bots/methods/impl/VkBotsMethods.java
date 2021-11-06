package api.longpoll.bots.methods.impl;

/**
 * Provides all VK APIs available for Bots.
 */
public class VkBotsMethods {
    public BoardApi board;
    public DocsApi docs;
    public GroupsApi groups;
    public MarketApi market;
    public MessagesApi messages;
    public PhotosApi photos;
    public StoriesApi stories;
    public UsersApi users;
    public UtilsApi utils;
    public WallApi wall;

    public VkBotsMethods(String accessToken) {
        board = new BoardApi(accessToken);
        docs = new DocsApi(accessToken);
        groups = new GroupsApi(accessToken);
        market = new MarketApi(accessToken);
        messages = new MessagesApi(accessToken);
        photos = new PhotosApi(accessToken);
        stories = new StoriesApi(accessToken);
        users = new UsersApi(accessToken);
        utils = new UtilsApi(accessToken);
        wall = new WallApi(accessToken);
    }
}
