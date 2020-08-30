package api.longpoll.bots.methods.messages;

import api.longpoll.bots.LongPollBot;
import api.longpoll.bots.converters.GenericConverterFactory;
import api.longpoll.bots.converters.JsonToPojoConverter;
import api.longpoll.bots.methods.GetMethod;
import api.longpoll.bots.methods.VkApi;
import api.longpoll.bots.model.response.other.GenericResult;
import com.google.gson.reflect.TypeToken;
import org.jsoup.Connection;

import java.util.stream.Stream;

/**
* Implements <b>messages.editChat</b> method.
* @see <a href="https://vk.com/dev/messages.editChat">https://vk.com/dev/messages.editChat</a>
*/
public class MessagesEditChat extends GetMethod<GenericResult<Integer>> {
    /**
     * Chat ID.
     */
    private Integer chatId;

    /**
     * New title of the chat.
     */
    private String title;

    public MessagesEditChat(LongPollBot bot) {
        super(bot);
    }

    /**
	* {@inheritDoc}
	*/
	@Override
    protected String getApi() {
        return VkApi.getInstance().messagesEditChat();
    }

    /**
	* {@inheritDoc}
	*/
	@Override
    protected JsonToPojoConverter<GenericResult<Integer>> getConverter() {
        return GenericConverterFactory.get(new TypeToken<GenericResult<Integer>>(){}.getType());
    }

    /**
	* {@inheritDoc}
	*/
	@Override
    protected Stream<Connection.KeyVal> getKeyValStream() {
        return Stream.of(
                keyVal("chat_id", chatId),
                keyVal("title", title)
        );
    }

    public Integer getChatId() {
        return chatId;
    }

    public MessagesEditChat setChatId(Integer chatId) {
        this.chatId = chatId;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public MessagesEditChat setTitle(String title) {
        this.title = title;
        return this;
    }
}
