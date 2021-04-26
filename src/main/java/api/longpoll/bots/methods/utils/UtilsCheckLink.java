package api.longpoll.bots.methods.utils;

import api.longpoll.bots.methods.GetMethod;
import api.longpoll.bots.methods.VkApi;
import api.longpoll.bots.model.response.utils.UtilsCheckLinkResult;
import org.jsoup.Connection;

import java.util.stream.Stream;

/**
 * Implements <b>utils.checkLink</b> method.
 *
 * @see <a href="https://vk.com/dev/utils.checkLink">https://vk.com/dev/utils.checkLink</a>
 */
public class UtilsCheckLink extends GetMethod<UtilsCheckLinkResult> {
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
    protected Stream<Connection.KeyVal> getKeyValStream() {
        return Stream.of(keyVal("url", url));
    }

    @Override
    protected Class<? extends UtilsCheckLinkResult> getResultType() {
        return UtilsCheckLinkResult.class;
    }

    public String getUrl() {
        return url;
    }

    public UtilsCheckLink setUrl(String url) {
        this.url = url;
        return this;
    }
}
