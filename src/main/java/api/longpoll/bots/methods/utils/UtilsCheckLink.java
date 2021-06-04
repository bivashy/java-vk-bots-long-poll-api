package api.longpoll.bots.methods.utils;

import api.longpoll.bots.methods.VkApiGetMethod;
import api.longpoll.bots.methods.VkApi;
import api.longpoll.bots.model.response.utils.UtilsCheckLinkResult;
import org.jsoup.Connection;

import java.util.stream.Stream;

/**
 * Implements <b>utils.checkLink</b> method.
 *
 * Checks whether a link is blocked in VK.
 *
 * @see <a href="https://vk.com/dev/utils.checkLink">https://vk.com/dev/utils.checkLink</a>
 */
public class UtilsCheckLink extends VkApiGetMethod<UtilsCheckLinkResult> {
    /**
     * Link to check (e.g., http://google.com).
     */
    private String url;

    public UtilsCheckLink(String accessToken) {
        super(accessToken);
    }

    @Override
    protected String getApi() {
        return VkApi.getInstance().utilsCheckLink();
    }

    @Override
    protected Stream<Connection.KeyVal> getParamsStream() {
        return Stream.of(keyVal("url", url));
    }

    @Override
    protected Class<? extends UtilsCheckLinkResult> getResultType() {
        return UtilsCheckLinkResult.class;
    }

    public UtilsCheckLink setUrl(String url) {
        this.url = url;
        return this;
    }
}
