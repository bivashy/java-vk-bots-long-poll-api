package api.longpoll.bots.methods.impl.messages;

import api.longpoll.bots.methods.impl.VkMethod;
import api.longpoll.bots.model.response.IntegerResponseBody;
import api.longpoll.bots.utils.ParamUtils;
import api.longpoll.bots.utils.VkMethods;

import java.util.Arrays;

/**
 * Implements <b>messages.createChat</b> method.
 * <p>
 * Creates a chat with several participants.
 *
 * @see <a href="https://vk.com/dev/messages.createChat">https://vk.com/dev/messages.createChat</a>
 */
public class CreateChat extends VkMethod<IntegerResponseBody> {
    public CreateChat(String accessToken) {
        super(VkMethods.get("messages.createChat"), accessToken);
    }

    @Override
    protected Class<IntegerResponseBody> getResponseClass() {
        return IntegerResponseBody.class;
    }

    public CreateChat setUserIds(Integer... userIds) {
        return setUserIds(Arrays.asList(userIds));
    }

    public CreateChat setUserIds(Iterable<Integer> userIds) {
        return addParam("user_ids", ParamUtils.csv(userIds));
    }

    public CreateChat setTitle(String title) {
        return addParam("title", title);
    }

    public CreateChat setGroupId(int groupId) {
        return addParam("group_id", groupId);
    }

    @Override
    public CreateChat addParam(String key, Object value) {
        return (CreateChat) super.addParam(key, value);
    }
}
