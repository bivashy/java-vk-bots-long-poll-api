package api.longpoll.bots.methods.utils;

import api.longpoll.bots.methods.GetMethod;
import api.longpoll.bots.methods.VkApi;
import api.longpoll.bots.model.response.utils.UtilsGetShortLinkResult;
import org.jsoup.Connection;

import java.util.stream.Stream;

/**
 * Implements <b>utils.getShortLink</b> method.
 *
 * @see <a href="https://vk.com/dev/utils.getShortLink">https://vk.com/dev/utils.getShortLink</a>
 */
public class UtilsGetShortLink extends GetMethod<UtilsGetShortLinkResult> {
    /**
     * URL to be shortened.
     */
    private String url;

    /**
     * <b>true</b> — private stats, <b>false</b> — public stats.
     */
    private Boolean isPrivate;

    public UtilsGetShortLink(String accessToken) {
        super(accessToken);
    }

    @Override
    protected String getApi() {
        return VkApi.getInstance().utilsGetShortLink();
    }

    @Override
    protected Stream<Connection.KeyVal> getKeyValStream() {
        return Stream.of(
                keyVal("url", url),
                keyVal("private", isPrivate, true)
        );
    }

    @Override
    protected Class<? extends UtilsGetShortLinkResult> getResultType() {
        return UtilsGetShortLinkResult.class;
    }

    public String getUrl() {
        return url;
    }

    public UtilsGetShortLink setUrl(String url) {
        this.url = url;
        return this;
    }

    public Boolean getPrivate() {
        return isPrivate;
    }

    public UtilsGetShortLink setPrivate(Boolean aPrivate) {
        isPrivate = aPrivate;
        return this;
    }
}
