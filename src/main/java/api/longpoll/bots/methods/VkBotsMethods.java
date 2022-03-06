package api.longpoll.bots.methods;

import java.util.function.Supplier;

/**
 * Provides all VK APIs available for Bots.
 */
public class VkBotsMethods {
    public final BoardMethods board;
    public final DocsMethods docs;
    public final GroupsMethods groups;
    public final MarketMethods market;
    public final MessagesMethods messages;
    public final PhotosMethods photos;
    public final StoriesMethods stories;
    public final UsersMethods users;
    public final UtilsMethods utils;
    public final WallMethods wall;

    public VkBotsMethods(String accessToken) {
        this(() -> accessToken);
    }

    public VkBotsMethods(Supplier<String> accessTokenSupplier) {
        board = new BoardMethods(accessTokenSupplier);
        docs = new DocsMethods(accessTokenSupplier);
        groups = new GroupsMethods(accessTokenSupplier);
        market = new MarketMethods(accessTokenSupplier);
        messages = new MessagesMethods(accessTokenSupplier);
        photos = new PhotosMethods(accessTokenSupplier);
        stories = new StoriesMethods(accessTokenSupplier);
        users = new UsersMethods(accessTokenSupplier);
        utils = new UtilsMethods(accessTokenSupplier);
        wall = new WallMethods(accessTokenSupplier);
    }
}
