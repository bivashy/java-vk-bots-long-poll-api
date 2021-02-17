package api.longpoll.bots.methods.docs;

import api.longpoll.bots.LongPollBot;
import api.longpoll.bots.converters.CachedConverterFactory;
import api.longpoll.bots.converters.JsonToPojoConverter;
import api.longpoll.bots.methods.GetMethod;
import api.longpoll.bots.methods.VkApi;
import api.longpoll.bots.model.response.docs.DocsGetUploadServerResponse;
import org.jsoup.Connection;

import java.util.stream.Stream;

/**
 * Implements <b>docs.getWallUploadServer</b> method.
 *
 * @see <a href="https://vk.com/dev/docs.getWallUploadServer">https://vk.com/dev/docs.getWallUploadServer</a>
 */
public class DocsGetWallUploadServer extends GetMethod<DocsGetUploadServerResponse> {
    /**
     * Community ID
     */
    private Integer groupId;

    public DocsGetWallUploadServer(LongPollBot bot) {
        super(bot);
    }

    @Override
    protected String getApi() {
        return VkApi.getInstance().docsGetWallUploadServer();
    }

    @Override
    protected JsonToPojoConverter<DocsGetUploadServerResponse> getConverter() {
        return CachedConverterFactory.getConverter(DocsGetUploadServerResponse.class);
    }

    @Override
    protected Stream<Connection.KeyVal> getKeyValStream() {
        return Stream.of(keyVal("group_id", groupId));
    }

    public Integer getGroupId() {
        return groupId;
    }

    public DocsGetWallUploadServer setGroupId(Integer groupId) {
        this.groupId = groupId;
        return this;
    }
}
