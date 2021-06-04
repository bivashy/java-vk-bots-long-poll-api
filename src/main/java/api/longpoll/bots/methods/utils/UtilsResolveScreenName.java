package api.longpoll.bots.methods.utils;

import api.longpoll.bots.methods.VkApiGetMethod;
import api.longpoll.bots.methods.VkApi;
import api.longpoll.bots.model.response.utils.UtilsResolveScreenNameResult;
import org.jsoup.Connection;

import java.util.stream.Stream;

/**
 * Implements <b>utils.resolveScreenName</b> method.
 *
 * Detects a type of object (e.g., user, community, application) and its ID by screen name.
 *
 * @see <a href="https://vk.com/dev/utils.resolveScreenName">https://vk.com/dev/utils.resolveScreenName</a>
 */
public class UtilsResolveScreenName extends VkApiGetMethod<UtilsResolveScreenNameResult> {
    /**
     * Screen name of the user, community (e.g., apiclub, andrew, or rules_of_war), or application.
     */
    private String screenName;

    public UtilsResolveScreenName(String accessToken) {
        super(accessToken);
    }

    @Override
    protected String getApi() {
        return VkApi.getInstance().utilsResolveScreenName();
    }

    @Override
    protected Stream<Connection.KeyVal> getKeyValStream() {
        return Stream.of(keyVal("screen_name", screenName));
    }

    @Override
    protected Class<? extends UtilsResolveScreenNameResult> getResultType() {
        return null;
    }

    public UtilsResolveScreenName setScreenName(String screenName) {
        this.screenName = screenName;
        return this;
    }
}
