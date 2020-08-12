package api.longpoll.bots.methods.messages;

import api.longpoll.bots.LongPollBot;
import api.longpoll.bots.converters.GenericConverterFactory;
import api.longpoll.bots.converters.JsonToPojoConverter;
import api.longpoll.bots.exceptions.ApiHttpException;
import api.longpoll.bots.methods.GetExecutor;
import api.longpoll.bots.methods.VkApi;
import api.longpoll.bots.methods.docs.DocsGetMessagesUploadServer;
import api.longpoll.bots.methods.docs.DocsSave;
import api.longpoll.bots.methods.photos.PhotosGetMessagesUploadServer;
import api.longpoll.bots.methods.photos.PhotosSaveMessagesPhoto;
import api.longpoll.bots.model.document.DocsGetMessagesUploadServerResponse;
import api.longpoll.bots.model.document.Document;
import api.longpoll.bots.model.market.item.MarketItem;
import api.longpoll.bots.model.messages.MessageUploadDocResponse;
import api.longpoll.bots.model.messages.MessageUploadPhotoResponse;
import api.longpoll.bots.model.messages.MessagesSendResponse;
import api.longpoll.bots.model.photos.Photo;
import api.longpoll.bots.model.photos.PhotosGetMessagesUploadServerResponse;
import api.longpoll.bots.model.photos.PhotosSaveMessagesPhotoResponse;
import api.longpoll.bots.model.video.Video;
import api.longpoll.bots.model.wall.post.WallPost;
import org.jsoup.Connection;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MessagesSend extends GetExecutor<MessagesSendResponse> {
	private static final String RANDOM_ID = "random_id";
	private static final String PEER_ID = "peer_id";
	private static final String DOMAIN = "domain";
	private static final String USER_IDS = "user_ids";
	private static final String MESSAGE = "message";
	private static final String LAT = "lat";
	private static final String LONG = "long";
	private static final String ATTACHMENT = "attachment";
	private static final String PHOTO = "photo";
	private static final String DOC = "doc";
	private static final String VIDEO = "video";
	private static final String WALL_POST = "wall";
	private static final String MARKET_ITEM = "market";
	private static final String REPLY_TO = "reply_to";
	private static final String FORWARD_MESSAGES = "forward_messages";
	private static final String STICKER_ID = "sticker_id";
	private static final String DONT_PARSE_LINKS = "dont_parse_links";
	private static final String DISABLE_MENTIONS = "disable_mentions";

	private List<String> attachments = new ArrayList<>();

	public MessagesSend(LongPollBot bot) {
		super(bot);
		setRandomId(Long.valueOf(System.currentTimeMillis()).intValue());
	}

	public MessagesSend setRandomId(int randomId) {
		params.put(RANDOM_ID, randomId);
		return this;
	}

	public int getRandomId() {
		return (int) params.get(RANDOM_ID);
	}

	public MessagesSend setPeerId(int peerId) {
		params.put(PEER_ID, peerId);
		return this;
	}

	public int getPeerId() {
		return (int) params.get(PEER_ID);
	}

	public MessagesSend setDomain(String domain) {
		params.put(DOMAIN, domain);
		return this;
	}

	public String getDomain() {
		return (String) params.get(DOMAIN);
	}

	public MessagesSend setUserIds(List<Integer> userIds) {
		params.put(USER_IDS, userIds);
		return this;
	}

	public List<Integer> getUserIds() {
		return (List<Integer>) params.get(USER_IDS);
	}

	public MessagesSend setMessage(String message) {
		params.put(MESSAGE, message);
		return this;
	}

	public String getMessage() {
		return (String) params.get(MESSAGE);
	}

	public MessagesSend setLatitude(float latitude) {
		params.put(LAT, latitude);
		return this;
	}

	public float getLatitude() {
		return (float) params.get(LAT);
	}

	public MessagesSend setLongtitude(float longitude) {
		params.put(LONG, longitude);
		return this;
	}

	public float getLongtitude() {
		return (float) params.get(LONG);
	}

	public List<String> getAttachments() {
		return attachments;
	}

	public MessagesSend setAttachments(List<String> attachments) {
		this.attachments = attachments;
		return this;
	}

	public MessagesSend addPhoto(File photo) throws ApiHttpException {
		PhotosGetMessagesUploadServer photosGetMessagesUploadServer = new PhotosGetMessagesUploadServer(bot);
		if (params.containsKey(PEER_ID)) {
			photosGetMessagesUploadServer.setPeerId(getPeerId());
		}

		PhotosGetMessagesUploadServerResponse uploadServerResponse = photosGetMessagesUploadServer.execute();
		MessageUploadPhotoResponse uploadPhotoResponse = new MessageUploadPhoto()
				.setUploadUrl(uploadServerResponse.getUploadUrl())
				.setPhoto(photo)
				.execute();

		PhotosSaveMessagesPhotoResponse response = new PhotosSaveMessagesPhoto(bot)
				.setHash(uploadPhotoResponse.getHash())
				.setPhoto(uploadPhotoResponse.getPhoto())
				.setServer(uploadPhotoResponse.getServer())
				.execute();

		attachments.add(attachment(PHOTO, response.getOwnerId(), response.getId()));

		return this;
	}

	public MessagesSend addPhoto(Photo photo) {
		attachments.add(attachment(PHOTO, photo.getOwnerId(), photo.getId()));
		return this;
	}

	public MessagesSend addDoc(File doc) throws ApiHttpException {
		DocsGetMessagesUploadServerResponse uploadServerResponse = new DocsGetMessagesUploadServer(bot)
				.setPeerId(getPeerId())
				.setType(DOC)
				.execute();

		MessageUploadDocResponse uploadDocResponse = new MessageUploadDoc()
				.setUploadUrl(uploadServerResponse.getUploadUrl())
				.setDoc(doc)
				.execute();

		Document document = new DocsSave(bot)
				.setTitle(doc.getName())
				.setFile(uploadDocResponse.getFile())
				.execute()
				.getObject();

		attachments.add(attachment(DOC, document.getOwnerId(), document.getId()));
		return this;
	}

	public MessagesSend addDoc(Document document) {
		attachments.add(attachment(DOC, document.getOwnerId(), document.getId()));
		return this;
	}

	public MessagesSend addVideo(Video video) {
		attachments.add(attachment(VIDEO, video.getOwnerId(), video.getId()));
		return this;
	}

	public MessagesSend addWallPost(WallPost wallPost) {
		attachments.add(attachment(WALL_POST, wallPost.getOwnerId(), wallPost.getId()));
		return this;
	}

	public MessagesSend addMarketItem(MarketItem marketItem) {
		attachments.add(attachment(MARKET_ITEM, marketItem.getOwnerId(), marketItem.getId()));
		return this;
	}

	private String attachment(String type, Integer ownerId, Integer mediaId) {
		return type + ownerId + "_" + mediaId;
	}

	public MessagesSend setReplyTo(int replyTo) {
		params.put(REPLY_TO, replyTo);
		return this;
	}

	public int getReplyTo() {
		return (int) params.get(REPLY_TO);
	}

	public MessagesSend setForwardMessages(List<Integer> forwardMessages) {
		params.put(FORWARD_MESSAGES, forwardMessages);
		return this;
	}

	public List<Integer> getForwardMessages() {
		return (List<Integer>) params.get(FORWARD_MESSAGES);
	}

	public MessagesSend setStickerId(int stickerId) {
		params.put(STICKER_ID, stickerId);
		return this;
	}

	public int getStickerId() {
		return (int) params.get(STICKER_ID);
	}

	public MessagesSend setDontParseLinks(boolean dontParseLinks) {
		params.put(DONT_PARSE_LINKS, dontParseLinks ? 1 : 0);
		return this;
	}

	public boolean getDontParseLinks() {
		return (int) params.get(DONT_PARSE_LINKS) == 1;
	}

	public MessagesSend setDisableMentions(boolean disableMentions) {
		params.put(DISABLE_MENTIONS, disableMentions ? 1 : 0);
		return this;
	}

	public boolean getDisableMentions() {
		return (int) params.get(DISABLE_MENTIONS) == 1;
	}

	@Override
	protected List<Connection.KeyVal> getData() {
		params.put(ATTACHMENT, attachments);
		return super.getData();
	}

	@Override
	protected String getApi() {
		return VkApi.Messages.SEND;
	}

	@Override
	protected JsonToPojoConverter<MessagesSendResponse> getConverter() {
		return GenericConverterFactory.get(MessagesSendResponse.class);
	}
}
