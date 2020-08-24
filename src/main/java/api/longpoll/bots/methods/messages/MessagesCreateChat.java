package api.longpoll.bots.methods.messages;

import api.longpoll.bots.LongPollBot;
import api.longpoll.bots.converters.GenericConverterFactory;
import api.longpoll.bots.converters.JsonToPojoConverter;
import api.longpoll.bots.methods.GetMethod;
import api.longpoll.bots.methods.VkApi;
import api.longpoll.bots.model.response.other.GenericResult;
import com.google.gson.reflect.TypeToken;
import org.jsoup.Connection;

import java.util.List;
import java.util.stream.Stream;

public class MessagesCreateChat extends GetMethod<GenericResult<Integer>> {
    private List<Integer> userIds;
    private String title;
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
        return GenericConverterFactory.get(new TypeToken<GenericResult<Integer>>(){}.getType());
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
