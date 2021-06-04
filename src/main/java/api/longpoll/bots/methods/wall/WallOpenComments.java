package api.longpoll.bots.methods.wall;

import api.longpoll.bots.methods.VkApiGetMethod;
import api.longpoll.bots.methods.VkApi;
import api.longpoll.bots.model.response.IntegerResult;
import org.jsoup.Connection;

import java.util.stream.Stream;

/**
 * Implements <b>wall.openComments</b> method.
 *
 * @see <a href="https://vk.com/dev/wall.openComments">https://vk.com/dev/wall.openComments</a>
 */
public class WallOpenComments extends VkApiGetMethod<IntegerResult> {
    /**
     * Wall owner ID.
     */
    private Integer ownerId;

    /**
     * Wall post ID.
     */
    private Integer postId;

    public WallOpenComments(String accessToken) {
        super(accessToken);
    }

    @Override
    protected String getApi() {
        return VkApi.getInstance().wallOpenComments();
    }

    @Override
    protected Stream<Connection.KeyVal> getParamsStream() {
        return Stream.of(
                keyVal("owner_id", ownerId),
                keyVal("post_id", postId)
        );
    }

    @Override
    protected Class<? extends IntegerResult> getResultType() {
        return IntegerResult.class;
    }

    public WallOpenComments setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
        return this;
    }

    public WallOpenComments setPostId(Integer postId) {
        this.postId = postId;
        return this;
    }
}
