package api.longpoll.bots.methods.wall;

import api.longpoll.bots.LongPollBot;
import api.longpoll.bots.converters.GenericConverterFactory;
import api.longpoll.bots.converters.JsonToPojoConverter;
import api.longpoll.bots.methods.GetMethod;
import api.longpoll.bots.methods.VkApi;
import api.longpoll.bots.model.response.GenericResult;
import com.google.gson.reflect.TypeToken;
import org.jsoup.Connection;

import java.util.stream.Stream;

/**
 * Implements <b>wall.closeComments</b> method.
 *
 * @see <a href="https://vk.com/dev/wall.closeComments">https://vk.com/dev/wall.closeComments</a>
 */
public class WallCloseComments extends GetMethod<GenericResult<Integer>> {
    /**
     * Wall owner ID.
     */
    private Integer ownerId;

    /**
     * Wall post ID.
     */
    private Integer postId;

    public WallCloseComments(LongPollBot bot) {
        super(bot);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected String getApi() {
        return VkApi.getInstance().wallCloseComments();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected JsonToPojoConverter<GenericResult<Integer>> getConverter() {
        return GenericConverterFactory.get(new TypeToken<GenericResult<Integer>>() {}.getType());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Stream<Connection.KeyVal> getKeyValStream() {
        return Stream.of(
                keyVal("owner_id", ownerId),
                keyVal("post_id", postId)
        );
    }

    public Integer getOwnerId() {
        return ownerId;
    }

    public WallCloseComments setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
        return this;
    }

    public Integer getPostId() {
        return postId;
    }

    public WallCloseComments setPostId(Integer postId) {
        this.postId = postId;
        return this;
    }
}
