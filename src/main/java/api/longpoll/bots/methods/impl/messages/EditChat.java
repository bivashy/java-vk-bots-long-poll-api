package api.longpoll.bots.methods.impl.messages;

import api.longpoll.bots.methods.impl.VkMethod;
import api.longpoll.bots.model.response.IntegerResponseBody;

/**
 * Implements <b>messages.editChat</b> method.
 * <p>
 * Edits the title of a chat.
 *
 * @see <a href="https://vk.com/dev/messages.editChat">https://vk.com/dev/messages.editChat</a>
 */
public class EditChat extends VkMethod<IntegerResponseBody> {
    public EditChat(String accessToken) {
        super(accessToken);
    }

    @Override
    public String getUri() {
        return VK_METHODS.getProperty("messages.editChat");
    }

    @Override
    protected Class<IntegerResponseBody> getResponseType() {
        return IntegerResponseBody.class;
    }

    public EditChat setChatId(int chatId) {
        return addParam("chat_id", chatId);
    }

    public EditChat setTitle(String title) {
        return addParam("title", title);
    }

    @Override
    public EditChat addParam(String key, Object value) {
        return (EditChat) super.addParam(key, value);
    }
}
