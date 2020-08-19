package api.longpoll.bots.methods.messages;

import api.longpoll.bots.LongPollBot;
import api.longpoll.bots.converters.GenericConverterFactory;
import api.longpoll.bots.converters.JsonToPojoConverter;
import api.longpoll.bots.exceptions.ApiHttpException;
import api.longpoll.bots.methods.GetMethod;
import api.longpoll.bots.methods.VkApi;
import api.longpoll.bots.methods.docs.DocsGetMessagesUploadServer;
import api.longpoll.bots.methods.docs.DocsSave;
import api.longpoll.bots.methods.other.UploadDoc;
import api.longpoll.bots.methods.other.UploadPhoto;
import api.longpoll.bots.methods.photos.PhotosGetMessagesUploadServer;
import api.longpoll.bots.methods.photos.PhotosSaveMessagesPhoto;
import api.longpoll.bots.model.objects.media.Doc;
import api.longpoll.bots.model.objects.media.Photo;
import api.longpoll.bots.model.response.docs.DocsGetUploadServerResult;
import api.longpoll.bots.model.response.other.GenericResult;
import api.longpoll.bots.model.response.other.UploadDocResult;
import api.longpoll.bots.model.response.other.UploadPhotoResult;
import api.longpoll.bots.model.response.photos.PhotosGetMessagesUploadServerResult;
import api.longpoll.bots.model.response.photos.PhotosSaveMessagesPhotoResult;
import com.google.gson.reflect.TypeToken;
import org.jsoup.Connection;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class MessagesEdit extends GetMethod<GenericResult<Integer>> {
    private Integer peerId;
    private String message;
    private float latitude;
    private float longitude;
    private List<String> attachments;
    private Boolean keepForwardMessages;
    private Boolean keepSnippets;
    private Integer groupId;
    private Boolean dontParseLinks;
    private Integer messageId;
    private Integer conversationMessageId;

    public MessagesEdit(LongPollBot bot) {
        super(bot);
    }

    @Override
    protected String getApi() {
        return VkApi.Messages.EDIT;
    }

    @Override
    protected JsonToPojoConverter<GenericResult<Integer>> getConverter() {
        return GenericConverterFactory.get(new TypeToken<GenericResult<Integer>>(){}.getType());
    }

    @Override
    protected Stream<Connection.KeyVal> getKeyValStream() {
        return Stream.of(
                keyVal("peer_id", peerId),
                keyVal("message", message),
                keyVal("lat", latitude),
                keyVal("long", longitude),
                keyVal("attachment", attachments),
                keyVal("keep_forward_messages", keepForwardMessages, true),
                keyVal("keep_snippets", keepSnippets, true),
                keyVal("group_id", groupId),
                keyVal("dont_parse_links", dontParseLinks, true),
                keyVal("message_id", messageId),
                keyVal("conversation_message_id", conversationMessageId)
        );
    }

    private String attachment(String type, Integer ownerId, Integer mediaId, String accessKey) {
        return type + ownerId + "_" + mediaId + (accessKey == null ? "" : "_" + accessKey);
    }

    private MessagesEdit attach(String type, Integer ownerId, Integer mediaId, String accessKey) {
        if (attachments == null) {
            attachments = new ArrayList<>();
        }
        attachments.add(attachment(type, ownerId, mediaId, accessKey));
        return this;
    }

    public MessagesEdit attachPhoto(Photo photo) {
        return attach("photo", photo.getOwnerId(), photo.getId(), photo.getAccessKey());
    }

    public MessagesEdit attachPhoto(File photo) throws ApiHttpException {
        PhotosGetMessagesUploadServerResult.Response uploadServer = new PhotosGetMessagesUploadServer(bot)
                .setPeerId(peerId)
                .execute()
                .getResponse();
        UploadPhotoResult uploadPhoto = new UploadPhoto()
                .setUploadUrl(uploadServer.getUploadUrl())
                .setPhoto(photo)
                .execute();
        PhotosSaveMessagesPhotoResult.Response savePhoto = new PhotosSaveMessagesPhoto(bot)
                .setHash(uploadPhoto.getHash())
                .setPhoto(uploadPhoto.getPhoto())
                .setServer(uploadPhoto.getServer())
                .execute()
                .getResponse()
                .get(0);

        return attach("photo", savePhoto.getOwnerId(), savePhoto.getId(), savePhoto.getAccessKey());
    }

    public MessagesEdit attachDoc(Doc doc) {
        return attach("doc", doc.getOwnerId(), doc.getId(), doc.getAccessKey());
    }

    public MessagesEdit attachDoc(File doc) throws ApiHttpException {
        DocsGetUploadServerResult.Response uploadServer = new DocsGetMessagesUploadServer(bot)
                .setType("doc")
                .setPeerId(peerId)
                .execute()
                .getResponse();
        UploadDocResult uploadDoc = new UploadDoc()
                .setUploadUrl(uploadServer.getUploadUrl())
                .setDoc(doc)
                .execute();
        Doc uploadedDoc = (Doc) new DocsSave(bot)
                .setFile(uploadDoc.getFile())
                .execute()
                .getResponse()
                .getAttachable();

        return attach("doc", uploadedDoc.getOwnerId(), uploadedDoc.getId(), uploadedDoc.getAccessKey());
    }

    public Integer getPeerId() {
        return peerId;
    }

    public MessagesEdit setPeerId(Integer peerId) {
        this.peerId = peerId;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public MessagesEdit setMessage(String message) {
        this.message = message;
        return this;
    }

    public float getLatitude() {
        return latitude;
    }

    public MessagesEdit setLatitude(float latitude) {
        this.latitude = latitude;
        return this;
    }

    public float getLongitude() {
        return longitude;
    }

    public MessagesEdit setLongitude(float longitude) {
        this.longitude = longitude;
        return this;
    }

    public List<String> getAttachments() {
        return attachments;
    }

    public MessagesEdit setAttachments(List<String> attachments) {
        this.attachments = attachments;
        return this;
    }

    public Boolean getKeepForwardMessages() {
        return keepForwardMessages;
    }

    public MessagesEdit setKeepForwardMessages(Boolean keepForwardMessages) {
        this.keepForwardMessages = keepForwardMessages;
        return this;
    }

    public Boolean getKeepSnippets() {
        return keepSnippets;
    }

    public MessagesEdit setKeepSnippets(Boolean keepSnippets) {
        this.keepSnippets = keepSnippets;
        return this;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public MessagesEdit setGroupId(Integer groupId) {
        this.groupId = groupId;
        return this;
    }

    public Boolean getDontParseLinks() {
        return dontParseLinks;
    }

    public MessagesEdit setDontParseLinks(Boolean dontParseLinks) {
        this.dontParseLinks = dontParseLinks;
        return this;
    }

    public Integer getMessageId() {
        return messageId;
    }

    public MessagesEdit setMessageId(Integer messageId) {
        this.messageId = messageId;
        return this;
    }

    public Integer getConversationMessageId() {
        return conversationMessageId;
    }

    public MessagesEdit setConversationMessageId(Integer conversationMessageId) {
        this.conversationMessageId = conversationMessageId;
        return this;
    }
}
