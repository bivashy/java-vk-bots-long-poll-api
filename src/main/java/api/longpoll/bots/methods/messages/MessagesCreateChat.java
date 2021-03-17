package api.longpoll.bots.methods.messages;

import api.longpoll.bots.LongPollBot;
import api.longpoll.bots.converters.JsonToPojoConverter;
import api.longpoll.bots.converters.JsonToPojoConverterFactory;
import api.longpoll.bots.methods.GetMethod;
import api.longpoll.bots.methods.VkApi;
import api.longpoll.bots.model.response.GenericResult;
import com.google.gson.reflect.TypeToken;
import org.jsoup.Connection;

import java.util.List;
import java.util.stream.Stream;

/**
 * Implements <b>messages.createChat</b> method.
 *
 * @see <a href="https://vk.com/dev/messages.createChat">https://vk.com/dev/messages.createChat</a>
 */
public class MessagesCreateChat extends GetMethod<GenericResult<Integer>> {
    /**
     * IDs of the users to be added to the chat.
     */
    private List<Integer> userIds;

    /**
     * Chat title.
     */
    private String title;

    /**
     * Community ID.
     */
    private Integer groupId;

    public MessagesCreateChat(LongPollBot bot) {
        super(bot);
    }

    @Override
    protected String getApi() {
        return VkApi.getInstance().messagesCreateChat();
    }

    @Override
    protected JsonToPojoConverter<GenericResult<Integer>> getConverter() {
        return JsonToPojoConverterFactory.get(new TypeToken<GenericResult<Integer>>(){}.getType());
    }

    @Override
    protected Stream<Connection.KeyVal> getKeyValStream() {
        return Stream.of(
                keyVal("user_ids", userIds),
                keyVal("title", title),
                keyVal("group_id", groupId)
        );
    }

    public List<Integer> getUserIds() {
        return userIds;
    }

    public MessagesCreateChat setUserIds(List<Integer> userIds) {
        this.userIds = userIds;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public MessagesCreateChat setTitle(String title) {
        this.title = title;
        return this;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public MessagesCreateChat setGroupId(Integer groupId) {
        this.groupId = groupId;
        return this;
    }
}
