package api.longpoll.bots.methods.impl;

import api.longpoll.bots.methods.impl.utils.CheckLink;
import api.longpoll.bots.methods.impl.utils.GetLinkStats;
import api.longpoll.bots.methods.impl.utils.GetServerTime;
import api.longpoll.bots.methods.impl.utils.GetShortLink;
import api.longpoll.bots.methods.impl.utils.ResolveScreenName;

/**
 * Provides Utils methods.
 */
public class UtilsApi extends AbstractVkApi {
    public UtilsApi(String accessToken) {
        super(accessToken);
    }

    public CheckLink checkLink() {
        return new CheckLink(getAccessToken());
    }

    public GetLinkStats getLinkStats() {
        return new GetLinkStats(getAccessToken());
    }

    public GetServerTime getServerTime() {
        return new GetServerTime(getAccessToken());
    }

    public GetShortLink getShortLink() {
        return new GetShortLink(getAccessToken());
    }

    public ResolveScreenName resolveScreenName() {
        return new ResolveScreenName(getAccessToken());
    }
}
