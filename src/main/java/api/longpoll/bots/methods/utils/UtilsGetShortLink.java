package api.longpoll.bots.methods.utils;

import api.longpoll.bots.LongPollBot;
import api.longpoll.bots.converters.GenericConverterFactory;
import api.longpoll.bots.converters.JsonToPojoConverter;
import api.longpoll.bots.methods.GetMethod;
import api.longpoll.bots.methods.VkApi;
import api.longpoll.bots.model.response.utils.UtilsGetShortLinkResult;
import org.jsoup.Connection;

import java.util.stream.Stream;

public class UtilsGetShortLink extends GetMethod<UtilsGetShortLinkResult> {
    private String url;
    private Boolean isPrivate;

    public UtilsGetShortLink(LongPollBot bot) {
        super(bot);
    }

    @Override
    protected String getApi() {
        return VkApi.getInstance().utilsGetShortLink();
    }

    @Override
    protected JsonToPojoConverter<UtilsGetShortLinkResult> getConverter() {
        return GenericConverterFactory.get(UtilsGetShortLinkResult.class);
    }

    @Override
    protected Stream<Connection.KeyVal> getKeyValStream() {
        return Stream.of(
                keyVal("url", url),
                keyVal("private", isPrivate, true)
        );
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
