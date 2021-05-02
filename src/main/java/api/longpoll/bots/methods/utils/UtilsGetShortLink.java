package api.longpoll.bots.methods.utils;

import api.longpoll.bots.methods.VkApiGetMethod;
import api.longpoll.bots.methods.VkApi;
import api.longpoll.bots.model.response.utils.UtilsGetShortLinkResult;

import java.util.Map;
import java.util.stream.Stream;

/**
 * Implements <b>utils.getShortLink</b> method.
 *
 * @see <a href="https://vk.com/dev/utils.getShortLink">https://vk.com/dev/utils.getShortLink</a>
 */
public class UtilsGetShortLink extends VkApiGetMethod<UtilsGetShortLinkResult> {
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
    protected Stream<Map.Entry<String, Object>> getParamsStream() {
        return Stream.of(
                param("url", url),
                param("private", isPrivate, true)
        );
    }

    @Override
    protected Class<? extends UtilsGetShortLinkResult> getResultType() {
        return UtilsGetShortLinkResult.class;
    }

    public UtilsGetShortLink setUrl(String url) {
        this.url = url;
        return this;
    }

    public UtilsGetShortLink setPrivate(Boolean aPrivate) {
        isPrivate = aPrivate;
        return this;
    }
}
