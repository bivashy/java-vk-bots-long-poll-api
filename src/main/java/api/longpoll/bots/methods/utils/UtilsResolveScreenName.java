package api.longpoll.bots.methods.utils;

import api.longpoll.bots.LongPollBot;
import api.longpoll.bots.converters.GenericConverterFactory;
import api.longpoll.bots.converters.JsonToPojoConverter;
import api.longpoll.bots.methods.GetMethod;
import api.longpoll.bots.methods.VkApi;
import api.longpoll.bots.model.response.utils.UtilsResolveScreenNameResult;
import org.jsoup.Connection;

import java.util.stream.Stream;

public class UtilsResolveScreenName extends GetMethod<UtilsResolveScreenNameResult> {
    private String screenName;

    public UtilsResolveScreenName(LongPollBot bot) {
        super(bot);
    }

    @Override
    protected String getApi() {
        return VkApi.getInstance().utilsResolveScreenName();
    }

    @Override
    protected JsonToPojoConverter<UtilsResolveScreenNameResult> getConverter() {
        return GenericConverterFactory.get(UtilsResolveScreenNameResult.class);
    }

    @Override
    protected Stream<Connection.KeyVal> getKeyValStream() {
        return Stream.of(keyVal("screen_name", screenName));
    }

    public String getScreenName() {
        return screenName;
    }

    public UtilsResolveScreenName setScreenName(String screenName) {
        this.screenName = screenName;
        return this;
    }
}
