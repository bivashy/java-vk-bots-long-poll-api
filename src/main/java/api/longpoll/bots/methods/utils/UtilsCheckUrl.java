package api.longpoll.bots.methods.utils;

import api.longpoll.bots.LongPollBot;
import api.longpoll.bots.converters.GenericConverterFactory;
import api.longpoll.bots.converters.JsonToPojoConverter;
import api.longpoll.bots.methods.GetMethod;
import api.longpoll.bots.methods.VkApi;
import api.longpoll.bots.model.response.utils.UtilsCheckLinkResult;
import org.jsoup.Connection;

import java.util.stream.Stream;

public class UtilsCheckUrl extends GetMethod<UtilsCheckLinkResult> {
    private String url;

    public UtilsCheckUrl(LongPollBot bot) {
        super(bot);
    }

    @Override
    protected String getApi() {
        return VkApi.getInstance().utilsCheckLink();
    }

    @Override
    protected JsonToPojoConverter<UtilsCheckLinkResult> getConverter() {
        return GenericConverterFactory.get(UtilsCheckLinkResult.class);
    }

    @Override
    protected Stream<Connection.KeyVal> getKeyValStream() {
        return Stream.of(keyVal("url", url));
    }

    public String getUrl() {
        return url;
    }

    public UtilsCheckUrl setUrl(String url) {
        this.url = url;
        return this;
    }
}
