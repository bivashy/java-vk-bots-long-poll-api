package api.longpoll.bots.methods.impl.messages;

import api.longpoll.bots.adapters.deserializers.SendResponseBodyDeserializer;
import api.longpoll.bots.exceptions.VkApiException;
import api.longpoll.bots.helpers.attachments.InputStreamUploadableMessageDoc;
import api.longpoll.bots.helpers.attachments.InputStreamUploadableMessagePhoto;
import api.longpoll.bots.helpers.attachments.PathUploadableMessageDoc;
import api.longpoll.bots.helpers.attachments.PathUploadableMessagePhoto;
import api.longpoll.bots.helpers.attachments.UploadableFile;
import api.longpoll.bots.helpers.attachments.UploadableFilesSupplier;
import api.longpoll.bots.methods.impl.VkMethod;
import api.longpoll.bots.model.objects.additional.Forward;
import api.longpoll.bots.model.objects.additional.Keyboard;
import api.longpoll.bots.model.objects.additional.Template;
import api.longpoll.bots.model.objects.additional.UploadedFile;
import api.longpoll.bots.model.response.GenericResponseBody;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;

import java.io.File;
import java.io.InputStream;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Implements <b>messages.send</b> method.
 * <p>
 * Sends a message.
 *
 * @see <a href="https://vk.com/dev/messages.send">https://vk.com/dev/messages.send</a>
 */
public class Send extends VkMethod<Send.ResponseBody> {
    /**
     * Supplies a list of {@link UploadableFile}.
     */
    private final UploadableFilesSupplier uploadableFilesSupplier = new UploadableFilesSupplier();

    public Send(String accessToken) {
        super(accessToken);
        addParam("random_id", (int) System.currentTimeMillis());
    }

    @Override
    public String getUri() {
        return property("messages.send");
    }

    @Override
    protected Class<ResponseBody> getResponseClass() {
        return ResponseBody.class;
    }

    @Override
    public ResponseBody execute() throws VkApiException {
        List<UploadedFile> uploadedFiles = new ArrayList<>();
        for (UploadableFile uploadableFile : uploadableFilesSupplier.get()) {
            uploadedFiles.add(uploadableFile.upload());
        }
        if (!uploadedFiles.isEmpty()) {
            setAttachment(uploadedFiles);
        }
        return super.execute();
    }

    public Send addPhoto(File photo) {
        return addPhoto(photo.toPath());
    }

    public Send addPhoto(Path photo) {
        uploadableFilesSupplier.addUploadableFileFactory(peerId -> new PathUploadableMessagePhoto(
                photo,
                peerId,
                getAccessToken()
        ));
        return this;
    }

    public Send addPhoto(InputStream photo, String filename) {
        uploadableFilesSupplier.addUploadableFileFactory(peerId -> new InputStreamUploadableMessagePhoto(
                photo,
                filename,
                peerId,
                getAccessToken()
        ));
        return this;
    }

    public Send addDoc(File doc) {
        return addDoc(doc.toPath());
    }

    public Send addDoc(Path doc) {
        uploadableFilesSupplier.addUploadableFileFactory(peerId -> new PathUploadableMessageDoc(
                doc,
                peerId,
                getAccessToken()
        ));
        return this;
    }

    public Send addDoc(InputStream doc, String filename) {
        uploadableFilesSupplier.addUploadableFileFactory(peerId -> new InputStreamUploadableMessageDoc(
                doc,
                filename,
                peerId,
                getAccessToken()
        ));
        return this;
    }

    public Send setAttachment(UploadedFile... uploadedFiles) {
        return setAttachment(Arrays.asList(uploadedFiles));
    }

    public Send setAttachment(List<UploadedFile> uploadedFiles) {
        return setAttachment(csv(uploadedFiles));
    }

    public Send setAttachment(String attachment) {
        return addParam("attachment", attachment);
    }

    public Send setUserId(int userId) {
        uploadableFilesSupplier.addPeerId(userId);
        return addParam("user_id", userId);
    }

    public Send setRandomId(int randomId) {
        return addParam("random_id", randomId);
    }

    public Send setPeerId(int peerId) {
        uploadableFilesSupplier.addPeerId(peerId);
        return addParam("peer_id", peerId);
    }

    public Send setPeerIds(Integer... peerIds) {
        return setPeerIds(Arrays.asList(peerIds));
    }

    public Send setPeerIds(List<Integer> peerIds) {
        uploadableFilesSupplier.addPeerIds(peerIds);
        return addParam("peer_ids", csv(peerIds));
    }

    public Send setDomain(String domain) {
        return addParam("domain", domain);
    }

    public Send setChatId(int chatId) {
        return addParam("chat_id", chatId);
    }

    public Send setUserIds(Integer... userIds) {
        return setUserIds(Arrays.asList(userIds));
    }

    public Send setUserIds(List<Integer> userIds) {
        uploadableFilesSupplier.addPeerIds(userIds);
        return addParam("user_ids", csv(userIds));
    }

    public Send setMessage(String message) {
        return addParam("message", message);
    }

    public Send setLatitude(float latitude) {
        return addParam("lat", latitude);
    }

    public Send setLongitude(float longitude) {
        return addParam("long", longitude);
    }

    public Send setReplyTo(int replyTo) {
        return addParam("reply_to", replyTo);
    }

    public Send setForwardMessages(Integer... forwardMessages) {
        return setForwardMessages(Arrays.asList(forwardMessages));
    }

    public Send setForwardMessages(List<Integer> forwardMessages) {
        return addParam("forward_messages", csv(forwardMessages));
    }

    public Send setStickerId(int stickerId) {
        return addParam("sticker_id", stickerId);
    }

    public Send setDontParseLinks(boolean dontParseLinks) {
        return addParam("dont_parse_links", dontParseLinks ? 1 : 0);
    }

    public Send setDisableMentions(boolean disableMentions) {
        return addParam("disable_mentions", disableMentions ? 1 : 0);
    }

    public Send setKeyboard(Keyboard keyboard) {
        return addParam("keyboard", keyboard);
    }

    public Send setTemplate(Template template) {
        return addParam("template", getGson().toJson(template));
    }

    public Send setForward(Forward forward) {
        return addParam("forward", getGson().toJson(forward));
    }

    public Send setPayload(JsonElement payload) {
        return addParam("payload", getGson().toJson(payload));
    }

    @Override
    public Send addParam(String key, Object value) {
        return (Send) super.addParam(key, value);
    }

    /**
     * Result to <b>messages.send</b> request.
     */
    @JsonAdapter(SendResponseBodyDeserializer.class)
    public static class ResponseBody extends GenericResponseBody<Object> {
        /**
         * Response object.
         */
        public static class Response {
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

            @SerializedName("conversation_message_id")
            private Integer conversationMessageId;

            /**
             * Error object, if message is not delivered.
             */
            @SerializedName("error")
            private JsonObject error;

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

            public Integer getConversationMessageId() {
                return conversationMessageId;
            }

            public void setConversationMessageId(Integer conversationMessageId) {
                this.conversationMessageId = conversationMessageId;
            }

            public JsonObject getError() {
                return error;
            }

            public void setError(JsonObject error) {
                this.error = error;
            }

            @Override
            public String toString() {
                return "Response{" +
                        "peerId=" + peerId +
                        ", messageId=" + messageId +
                        ", conversationMessageId=" + conversationMessageId +
                        ", error=" + error +
                        '}';
            }
        }
    }
}
