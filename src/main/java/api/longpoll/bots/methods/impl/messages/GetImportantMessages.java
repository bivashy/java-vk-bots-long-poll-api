package api.longpoll.bots.methods.impl.messages;

import api.longpoll.bots.http.params.BoolInt;
import api.longpoll.bots.methods.AuthorizedVkApiMethod;
import api.longpoll.bots.model.objects.basic.Message;
import api.longpoll.bots.model.response.ExtendedVkList;
import api.longpoll.bots.model.response.GenericResponse;

import java.util.Arrays;
import java.util.List;

/**
 * Implements <b>messages.getImportantMessages</b> method.
 * <p>
 * Returns important messages.
 *
 * @see <a href="https://vk.com/dev/messages.getImportantMessages">https://vk.com/dev/messages.getImportantMessages</a>
 */
public class GetImportantMessages extends AuthorizedVkApiMethod<GetImportantMessages.Response> {
    public GetImportantMessages(String accessToken) {
        super(accessToken);
    }

    @Override
    protected String getUrl() {
        return null;
    }

    @Override
    protected Class<Response> getResponseType() {
        return null;
    }

    public GetImportantMessages setCount(int count) {
        addParam("count", count);
        return this;
    }

    public GetImportantMessages setOffset(int offset) {
        addParam("offset", offset);
        return this;
    }

    public GetImportantMessages setStartMessageId(int startMessageId) {
        addParam("start_message_id", startMessageId);
        return this;
    }

    public GetImportantMessages setPreviewLength(int previewLength) {
        addParam("preview_length", previewLength);
        return this;
    }

    public GetImportantMessages setFields(String... fields) {
        return setFields(Arrays.asList(fields));
    }

    public GetImportantMessages setFields(List<String> fields) {
        addParam("fields", fields);
        return this;
    }

    public GetImportantMessages setExtended(boolean extended) {
        addParam("extended", new BoolInt(extended));
        return this;
    }

    public GetImportantMessages setGroupId(int groupId) {
        addParam("group_id", groupId);
        return this;
    }

    /**
     * Response to <b>messages.getImportantMessages</b> request.
     */
    public static class Response extends GenericResponse<ExtendedVkList<Message>> {
    }
}
