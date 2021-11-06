package api.longpoll.bots.methods.impl;

/**
 * Provides all VK APIs available for Bots.
 */
public class VkBotsMethods {
    public BoardMethods board;
    public DocsMethods docs;
    public GroupsMethods groups;
    public MarketMethods market;
    public MessagesMethods messages;
    public PhotosMethods photos;
    public StoriesMethods stories;
    public UsersMethods users;
    public UtilsMethods utils;
    public WallMethods wall;

    public VkBotsMethods(String accessToken) {
        board = new BoardMethods(accessToken);
        docs = new DocsMethods(accessToken);
        groups = new GroupsMethods(accessToken);
        market = new MarketMethods(accessToken);
        messages = new MessagesMethods(accessToken);
        photos = new PhotosMethods(accessToken);
        stories = new StoriesMethods(accessToken);
        users = new UsersMethods(accessToken);
        utils = new UtilsMethods(accessToken);
        wall = new WallMethods(accessToken);
    }
}
