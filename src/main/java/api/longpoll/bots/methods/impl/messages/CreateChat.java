package api.longpoll.bots.methods.impl.messages;

import api.longpoll.bots.methods.AuthorizedVkApiMethod;
import api.longpoll.bots.methods.VkApiProperties;
import api.longpoll.bots.model.response.IntegerResponse;

import java.util.Arrays;
import java.util.List;

/**
 * Implements <b>messages.createChat</b> method.
 * <p>
 * Creates a chat with several participants.
 *
 * @see <a href="https://vk.com/dev/messages.createChat">https://vk.com/dev/messages.createChat</a>
 */
public class CreateChat extends AuthorizedVkApiMethod<IntegerResponse> {
    public CreateChat(String accessToken) {
        super(accessToken);
    }

    @Override
    protected String getUrl() {
        return VkApiProperties.get("messages.createChat");
    }

    @Override
    protected Class<IntegerResponse> getResultType() {
        return IntegerResponse.class;
    }

    public CreateChat setUserIds(Integer... userIds) {
        return setUserIds(Arrays.asList(userIds));
    }

    public CreateChat setUserIds(List<Integer> userIds) {
        addParam("user_ids", userIds);
        return this;
    }

    public CreateChat setTitle(String title) {
        addParam("title", title);
        return this;
    }

    public CreateChat setGroupId(int groupId) {
        addParam("group_id", groupId);
        return this;
    }
}
