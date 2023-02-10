package api.longpoll.bots.methods.impl.messages;

import api.longpoll.bots.methods.impl.VkMethod;
import api.longpoll.bots.model.objects.basic.Message;
import api.longpoll.bots.model.response.ExtendedVkList;
import api.longpoll.bots.model.response.GenericResponseBody;
import api.longpoll.bots.utils.ParamUtils;
import api.longpoll.bots.utils.VkMethods;

import java.util.Arrays;

/**
 * Implements <b>messages.getImportantMessages</b> method.
 * <p>
 * Returns important messages.
 *
 * @see <a href="https://vk.com/dev/messages.getImportantMessages">https://vk.com/dev/messages.getImportantMessages</a>
 */
public class GetImportantMessages extends VkMethod<GetImportantMessages.ResponseBody> {
    public GetImportantMessages(String accessToken) {
        super(VkMethods.get("messages.getImportantMessages"), accessToken);
    }

    @Override
    protected Class<ResponseBody> getResponseClass() {
        return ResponseBody.class;
    }

    public GetImportantMessages setCount(int count) {
        return addParam("count", count);
    }

    public GetImportantMessages setOffset(int offset) {
        return addParam("offset", offset);
    }

    public GetImportantMessages setStartMessageId(int startMessageId) {
        return addParam("start_message_id", startMessageId);
    }

    public GetImportantMessages setPreviewLength(int previewLength) {
        return addParam("preview_length", previewLength);
    }

    public GetImportantMessages setFields(String... fields) {
        return setFields(Arrays.asList(fields));
    }

    public GetImportantMessages setFields(Iterable<String> fields) {
        return addParam("fields", ParamUtils.csv(fields));
    }

    public GetImportantMessages setExtended(boolean extended) {
        return addParam("extended", extended ? 1 : 0);
    }

    public GetImportantMessages setGroupId(int groupId) {
        return addParam("group_id", groupId);
    }

    @Override
    public GetImportantMessages addParam(String key, Object value) {
        return (GetImportantMessages) super.addParam(key, value);
    }

    /**
     * Response to <b>messages.getImportantMessages</b> request.
     */
    public static class ResponseBody extends GenericResponseBody<ExtendedVkList<Message>> {
    }
}
