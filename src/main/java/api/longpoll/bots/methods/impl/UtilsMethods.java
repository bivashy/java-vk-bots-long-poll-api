package api.longpoll.bots.methods.impl;

import api.longpoll.bots.methods.impl.utils.CheckLink;
import api.longpoll.bots.methods.impl.utils.GetLinkStats;
import api.longpoll.bots.methods.impl.utils.GetServerTime;
import api.longpoll.bots.methods.impl.utils.GetShortLink;
import api.longpoll.bots.methods.impl.utils.ResolveScreenName;

/**
 * Provides Utils methods.
 */
public class UtilsMethods {
    /**
     * Access token.
     */
    private final String accessToken;

    public UtilsMethods(String accessToken) {
        this.accessToken = accessToken;
    }

    public CheckLink checkLink() {
        return new CheckLink(accessToken);
    }

    public GetLinkStats getLinkStats() {
        return new GetLinkStats(accessToken);
    }

    public GetServerTime getServerTime() {
        return new GetServerTime(accessToken);
    }

    public GetShortLink getShortLink() {
        return new GetShortLink(accessToken);
    }

    public ResolveScreenName resolveScreenName() {
        return new ResolveScreenName(accessToken);
    }
}
