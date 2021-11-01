package api.longpoll.bots.methods.impl.messages;

import api.longpoll.bots.methods.AuthorizedVkApiMethod;
import api.longpoll.bots.methods.VkApiProperties;
import api.longpoll.bots.model.response.IntegerResponse;

/**
 * Implements <b>messages.editChat</b> method.
 * <p>
 * Edits the title of a chat.
 *
 * @see <a href="https://vk.com/dev/messages.editChat">https://vk.com/dev/messages.editChat</a>
 */
public class EditChat extends AuthorizedVkApiMethod<IntegerResponse> {
    public EditChat(String accessToken) {
        super(accessToken);
    }

    @Override
    protected String getUrl() {
        return VkApiProperties.get("messages.editChat");
    }

    @Override
    protected Class<IntegerResponse> getResponseType() {
        return IntegerResponse.class;
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
