package api.longpoll.bots.methods.market;

import api.longpoll.bots.LongPollBot;
import api.longpoll.bots.converters.GenericConverterFactory;
import api.longpoll.bots.converters.JsonToPojoConverter;
import api.longpoll.bots.methods.GetMethod;
import api.longpoll.bots.methods.VkApi;
import api.longpoll.bots.model.objects.additional.VkList;
import api.longpoll.bots.model.objects.basic.MarketOrder;
import api.longpoll.bots.model.response.other.GenericResult;
import com.google.gson.reflect.TypeToken;
import org.jsoup.Connection;

import java.util.stream.Stream;

public class MarketGetGroupOrders extends GetMethod<GenericResult<VkList<MarketOrder>>> {
    private Integer groupId;
    private Integer offset;
    private Integer count;

    public MarketGetGroupOrders(LongPollBot bot) {
        super(bot);
    }

    @Override
    protected String getApi() {
        return VkApi.getInstance().marketGetGroupOrders();
    }

    @Override
    protected JsonToPojoConverter<GenericResult<VkList<MarketOrder>>> getConverter() {
        return GenericConverterFactory.get(new TypeToken<GenericResult<VkList<MarketOrder>>>(){}.getType());
    }

    @Override
    protected Stream<Connection.KeyVal> getKeyValStream() {
        return Stream.of(
                keyVal("group_id", groupId),
                keyVal("offset", offset),
                keyVal("count", count)
        );
    }

    public Integer getGroupId() {
        return groupId;
    }

    public MarketGetGroupOrders setGroupId(Integer groupId) {
        this.groupId = groupId;
        return this;
    }

    public Integer getOffset() {
        return offset;
    }

    public MarketGetGroupOrders setOffset(Integer offset) {
        this.offset = offset;
        return this;
    }

    public Integer getCount() {
        return count;
    }

    public MarketGetGroupOrders setCount(Integer count) {
        this.count = count;
        return this;
    }
}
