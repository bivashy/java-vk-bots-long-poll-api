package api.longpoll.bots.methods.docs;

import api.longpoll.bots.methods.VkApiGetMethod;
import api.longpoll.bots.methods.VkApi;
import api.longpoll.bots.model.response.docs.DocsGetUploadServerResult;
import org.jsoup.Connection;

import java.util.stream.Stream;

/**
 * Implements <b>docs.getWallUploadServer</b> method.
 *
 * @see <a href="https://vk.com/dev/docs.getWallUploadServer">https://vk.com/dev/docs.getWallUploadServer</a>
 */
public class DocsGetWallUploadServer extends VkApiGetMethod<DocsGetUploadServerResult> {
    /**
     * Community ID
     */
    private Integer groupId;

    public DocsGetWallUploadServer(String accessToken) {
        super(accessToken);
    }

    @Override
    protected String getApi() {
        return VkApi.getInstance().docsGetWallUploadServer();
    }

    @Override
    protected Stream<Connection.KeyVal> getParamsStream() {
        return Stream.of(keyVal("group_id", groupId));
    }

    @Override
    protected Class<? extends DocsGetUploadServerResult> getResultType() {
        return DocsGetUploadServerResult.class;
    }

    public DocsGetWallUploadServer setGroupId(Integer groupId) {
        this.groupId = groupId;
        return this;
    }
}
