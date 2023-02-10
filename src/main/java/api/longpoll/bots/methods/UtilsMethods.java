package api.longpoll.bots.methods;

import api.longpoll.bots.methods.impl.utils.CheckLink;
import api.longpoll.bots.methods.impl.utils.GetLinkStats;
import api.longpoll.bots.methods.impl.utils.GetServerTime;
import api.longpoll.bots.methods.impl.utils.GetShortLink;
import api.longpoll.bots.methods.impl.utils.ResolveScreenName;

import java.util.function.Supplier;

/**
 * Provides Utils methods.
 */
public class UtilsMethods {
    /**
     * {@code access_token}.
     */
    private final Supplier<String> accessTokenSupplier;

    public UtilsMethods(Supplier<String> accessTokenSupplier) {
        this.accessTokenSupplier = accessTokenSupplier;
    }

    public CheckLink checkLink() {
        return new CheckLink(accessTokenSupplier.get());
    }

    public GetLinkStats getLinkStats() {
        return new GetLinkStats(accessTokenSupplier.get());
    }

    public GetServerTime getServerTime() {
        return new GetServerTime(accessTokenSupplier.get());
    }

    public GetShortLink getShortLink() {
        return new GetShortLink(accessTokenSupplier.get());
    }

    public ResolveScreenName resolveScreenName() {
        return new ResolveScreenName(accessTokenSupplier.get());
    }
}
