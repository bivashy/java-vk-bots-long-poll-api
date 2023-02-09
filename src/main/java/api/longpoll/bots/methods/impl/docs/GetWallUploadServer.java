package api.longpoll.bots.methods.impl.docs;

import api.longpoll.bots.methods.impl.VkMethod;
import api.longpoll.bots.utils.VkMethods;

/**
 * Implements <b>docs.getWallUploadServer</b> method.
 *
 * @see <a href="https://vk.com/dev/docs.getWallUploadServer">https://vk.com/dev/docs.getWallUploadServer</a>
 */
public class GetWallUploadServer extends VkMethod<GetWallUploadServer.ResponseBody> {
    public GetWallUploadServer(String accessToken) {
        super(VkMethods.get("docs.getWallUploadServer"), accessToken);
    }

    @Override
    protected Class<ResponseBody> getResponseClass() {
        return ResponseBody.class;
    }

    public GetWallUploadServer setGroupId(int groupId) {
        return addParam("group_id", groupId);
    }

    @Override
    public GetWallUploadServer addParam(String key, Object value) {
        return (GetWallUploadServer) super.addParam(key, value);
    }

    /**
     * Response to <b>docs.getWallUploadServer</b> request.
     */
    public static class ResponseBody extends GetMessagesUploadServer.ResponseBody {
    }
}
