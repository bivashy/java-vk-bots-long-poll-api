package api.longpoll.bots.methods.wall;

import api.longpoll.bots.methods.VkApiGetMethod;
import api.longpoll.bots.methods.VkApi;
import api.longpoll.bots.model.response.IntegerResult;
import org.jsoup.Connection;

import java.util.stream.Stream;

/**
 * Implements <b>wall.closeComments</b> method.
 *
 * @see <a href="https://vk.com/dev/wall.closeComments">https://vk.com/dev/wall.closeComments</a>
 */
public class WallCloseComments extends VkApiGetMethod<IntegerResult> {
    /**
     * Wall owner ID.
     */
    private Integer ownerId;

    /**
     * Wall post ID.
     */
    private Integer postId;

    public WallCloseComments(String accessToken) {
        super(accessToken);
    }

    @Override
    protected String getApi() {
        return VkApi.getInstance().wallCloseComments();
    }

    @Override
    protected Stream<Connection.KeyVal> getKeyValStream() {
        return Stream.of(
                keyVal("owner_id", ownerId),
                keyVal("post_id", postId)
        );
    }

    @Override
    protected Class<? extends IntegerResult> getResultType() {
        return IntegerResult.class;
    }

    public WallCloseComments setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
        return this;
    }

    public WallCloseComments setPostId(Integer postId) {
        this.postId = postId;
        return this;
    }
}
