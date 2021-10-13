package api.longpoll.bots.methods.impl.photos;

import api.longpoll.bots.methods.AuthorizedVkApiMethod;
import api.longpoll.bots.methods.VkApiProperties;

/**
 * Implements <b>photos.getChatUploadServer</b> method.
 * <p>
 * Returns an upload link for chat cover pictures.
 *
 * @see <a href="https://vk.com/dev/photos.getChatUploadServer">https://vk.com/dev/photos.getChatUploadServer</a>
 */
public class GetChatUploadServer extends AuthorizedVkApiMethod<GetChatUploadServer.Response> {
    public GetChatUploadServer(String accessToken) {
        super(accessToken);
    }

    @Override
    protected String getUrl() {
        return VkApiProperties.get("photos.getChatUploadServer");
    }

    @Override
    protected Class<Response> getResponseType() {
        return Response.class;
    }

    public GetChatUploadServer setChatId(int chatId) {
        return addParam("chat_id", chatId);
    }

    public GetChatUploadServer setCropX(int cropX) {
        return addParam("crop_x", cropX);
    }

    public GetChatUploadServer setCropY(int cropY) {
        return addParam("crop_y", cropY);
    }

    public GetChatUploadServer setCropWidth(int cropWidth) {
        return addParam("crop_width", cropWidth);
    }

    @Override
    public GetChatUploadServer addParam(String key, Object value) {
        return (GetChatUploadServer) super.addParam(key, value);
    }

    /**
     * Response to <b>photos.getChatUploadServer</b> request.
     */
    public static class Response extends GetOwnerCoverPhotoUploadServer.Response {
    }
}
