package api.longpoll.bots.methods.impl.messages;

import api.longpoll.bots.adapters.deserializers.MessagesSendResultDeserializer;
import api.longpoll.bots.http.params.AttachableParam;
import api.longpoll.bots.http.params.BoolInt;
import api.longpoll.bots.methods.AuthorizedVkApiMethod;
import api.longpoll.bots.methods.VkApiProperties;
import api.longpoll.bots.model.objects.additional.Keyboard;
import api.longpoll.bots.model.objects.additional.Template;
import api.longpoll.bots.model.response.GenericResponse;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;

import java.util.Arrays;
import java.util.List;

/**
 * Implements <b>messages.send</b> method.
 * <p>
 * Sends a message.
 *
 * @see <a href="https://vk.com/dev/messages.send">https://vk.com/dev/messages.send</a>
 */
public class Send extends AuthorizedVkApiMethod<Send.Response> {
    public Send(String accessToken) {
        super(accessToken);
        addParam("random_id", (int) System.currentTimeMillis());
    }

    @Override
    protected String getUrl() {
        return VkApiProperties.get("messages.send");
    }

    @Override
    protected Class<Response> getResponseType() {
        return Response.class;
    }

    public Send setAttachments(AttachableParam... attachments) {
        return setAttachments(Arrays.asList(attachments));
    }

    public Send setAttachments(List<AttachableParam> attachments) {
        addParam("attachment", attachments);
        return this;
    }

    public Send setUserId(int userId) {
        addParam("user_id", userId);
        return this;
    }

    public Send setRandomId(int randomId) {
        addParam("random_id", randomId);
        return this;
    }

    public Send setPeerId(int peerId) {
        addParam("peer_id", peerId);
        return this;
    }

    public Send setDomain(String domain) {
        addParam("domain", domain);
        return this;
    }

    public Send setChatId(int chatId) {
        addParam("chat_id", chatId);
        return this;
    }

    public Send setUserIds(Integer... userIds) {
        return setUserIds(Arrays.asList(userIds));
    }

    public Send setUserIds(List<Integer> userIds) {
        addParam("user_ids", userIds);
        return this;
    }

    public Send setMessage(String message) {
        addParam("message", message);
        return this;
    }

    public Send setLatitude(float latitude) {
        addParam("lat", latitude);
        return this;
    }

    public Send setLongitude(float longitude) {
        addParam("long", longitude);
        return this;
    }

    public Send setReplyTo(int replyTo) {
        addParam("reply_to", replyTo);
        return this;
    }

    public Send setForwardMessages(Integer... forwardMessages) {
        return setForwardMessages(Arrays.asList(forwardMessages));
    }

    public Send setForwardMessages(List<Integer> forwardMessages) {
        addParam("forward_messages", forwardMessages);
        return this;
    }

    public Send setStickerId(int stickerId) {
        addParam("sticker_id", stickerId);
        return this;
    }

    public Send setDontParseLinks(boolean dontParseLinks) {
        addParam("dont_parse_links", new BoolInt(dontParseLinks));
        return this;
    }

    public Send setDisableMentions(boolean disableMentions) {
        addParam("disable_mentions", new BoolInt(disableMentions));
        return this;
    }

    public Send setKeyboard(Keyboard keyboard) {
        addParam("keyboard", keyboard);
        return this;
    }

    public Send setTemplate(Template template) {
        addParam("template", template);
        return this;
    }

    /**
     * Result to <b>messages.send</b> request.
     */
    @JsonAdapter(MessagesSendResultDeserializer.class)
    public static class Response extends GenericResponse<Object> {
        /**
         * Response object.
         */
        public static class ResponseObject {
            /**
             * Peer ID.
             */
            @SerializedName("peer_id")
            private Integer peerId;

            /**
             * Message ID.
             */
            @SerializedName("message_id")
            private Integer messageId;

            /**
             * Error message, if message is not delivered.
             */
            @SerializedName("error")
            private String error;

            public Integer getPeerId() {
                return peerId;
            }

            public void setPeerId(Integer peerId) {
                this.peerId = peerId;
            }

            public Integer getMessageId() {
                return messageId;
            }

            public void setMessageId(Integer messageId) {
                this.messageId = messageId;
            }

            public String getError() {
                return error;
            }

            public void setError(String error) {
                this.error = error;
            }

            @Override
            public String toString() {
                return "ResponseObject{" +
                        "peerId=" + peerId +
                        ", messageId=" + messageId +
                        ", error='" + error + '\'' +
                        '}';
            }
        }
    }
}
