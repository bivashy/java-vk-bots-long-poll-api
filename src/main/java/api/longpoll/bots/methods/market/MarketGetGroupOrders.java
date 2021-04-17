package api.longpoll.bots.methods.market;

import api.longpoll.bots.converters.JsonToPojoConverter;
import api.longpoll.bots.converters.JsonToPojoConverterFactory;
import api.longpoll.bots.methods.GetMethod;
import api.longpoll.bots.methods.VkApi;
import api.longpoll.bots.model.objects.additional.VkList;
import api.longpoll.bots.model.objects.basic.MarketOrder;
import api.longpoll.bots.model.response.GenericResult;
import com.google.gson.reflect.TypeToken;
import org.jsoup.Connection;

import java.util.stream.Stream;

/**
 * Implements <b>market.getGroupOrders</b> method.
 *
 * @see <a href="https://vk.com/dev/market.getGroupOrders">https://vk.com/dev/market.getGroupOrders</a>
 */
public class MarketGetGroupOrders extends GetMethod<GenericResult<VkList<MarketOrder>>> {
    /**
     * ID of the community that owns the items market.
     */
    private Integer groupId;

    /**
     * Offset needed to return a specific subset of orders.
     */
    private Integer offset;

    /**
     * Number of orders to return.
     */
    private Integer count;

    public MarketGetGroupOrders(String accessToken) {
        super(accessToken);
    }

    @Override
    protected String getApi() {
        return VkApi.getInstance().marketGetGroupOrders();
    }

    @Override
    protected JsonToPojoConverter<GenericResult<VkList<MarketOrder>>> getConverter() {
        return JsonToPojoConverterFactory.get(new TypeToken<GenericResult<VkList<MarketOrder>>>(){}.getType());
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
