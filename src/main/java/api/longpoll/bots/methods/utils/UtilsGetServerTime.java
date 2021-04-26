package api.longpoll.bots.methods.utils;

import api.longpoll.bots.methods.GetMethod;
import api.longpoll.bots.methods.VkApi;
import api.longpoll.bots.model.response.IntegerResult;
import org.jsoup.Connection;

import java.util.stream.Stream;

/**
 * Implements <b>utils.getServerTime</b> method.
 *
 * @see <a href="https://vk.com/dev/utils.getServerTime">https://vk.com/dev/utils.getServerTime</a>
 */
public class UtilsGetServerTime extends GetMethod<IntegerResult> {
    public UtilsGetServerTime(String accessToken) {
        super(accessToken);
    }

    @Override
    protected String getApi() {
        return VkApi.getInstance().utilsGetServerTime();
    }

    @Override
    protected Stream<Connection.KeyVal> getKeyValStream() {
        return Stream.of();
    }

    @Override
    protected Class<? extends IntegerResult> getResultType() {
        return IntegerResult.class;
    }
}
