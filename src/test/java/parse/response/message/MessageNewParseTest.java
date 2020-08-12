package parse.response.message;

import bots.longpoll.sdk.constants.DocumentTypes;
import bots.longpoll.sdk.converters.updates.UpdateResponseConverterImpl;
import bots.longpoll.sdk.model.attachment.Attachment;
import bots.longpoll.sdk.model.attachment.MediaObject;
import bots.longpoll.sdk.model.audio.Audio;
import bots.longpoll.sdk.model.audio.MainArtist;
import bots.longpoll.sdk.model.audio.message.AudioMessage;
import bots.longpoll.sdk.model.document.Document;
import bots.longpoll.sdk.model.document.preview.Preview;
import bots.longpoll.sdk.model.document.preview.photo.PhotoPreview;
import bots.longpoll.sdk.model.document.preview.photo.PhotoPreviewSize;
import bots.longpoll.sdk.model.graffiti.Graffiti;
import bots.longpoll.sdk.model.photos.Photo;
import bots.longpoll.sdk.model.photos.Size;
import bots.longpoll.sdk.model.sticker.Image;
import bots.longpoll.sdk.model.sticker.Sticker;
import bots.longpoll.sdk.model.video.Video;
import bots.longpoll.sdk.model.video.VideoImage;
import bots.longpoll.sdk.model.wall.post.*;
import bots.longpoll.sdk.model.wall.reply.WallReply;
import bots.longpoll.sdk.model.wall.reply.WallReplyLikes;
import bots.longpoll.sdk.model.messages.Message;
import bots.longpoll.sdk.model.geo.Coordinates;
import bots.longpoll.sdk.model.geo.Geo;
import bots.longpoll.sdk.model.update.Update;
import bots.longpoll.sdk.model.update.UpdateObject;
import bots.longpoll.sdk.model.update.UpdateResponse;
import bots.longpoll.sdk.model.messages.ClientInfo;
import bots.longpoll.sdk.model.messages.MessageUpdate;
import com.google.gson.JsonObject;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import parse.response.AbstractParseTest;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MessageNewParseTest extends AbstractParseTest {

	@Test
	public void test1_messageNewText() throws IOException {
		JsonObject jsonObject = readJson("json/response/message_new/message_new_text_sample_5_110.json");
		UpdateResponse updateResponse = new UpdateResponseConverterImpl().convert(jsonObject);
		Assert.assertNotNull(updateResponse);
		Assert.assertEquals(Integer.valueOf(2588), updateResponse.getTs());

		List<Update> updates = updateResponse.getUpdates();
		Assert.assertNotNull(updates);
		Assert.assertEquals(1, updates.size());

		Update update = updates.get(0);
		Assert.assertNotNull(update);
		Assert.assertEquals("message_new", update.getType());
		Assert.assertEquals(Integer.valueOf(1689756581), update.getGroupId());
		Assert.assertEquals("4d6bfd7c8557496a48901a8fb981925ce0f01bdf1", update.getEventId());

		UpdateObject updateObject = update.getObject();
		Assert.assertNotNull(updateObject);

		Assert.assertTrue(updateObject instanceof MessageUpdate);
		MessageUpdate messageUpdate = (MessageUpdate) updateObject;
		Assert.assertNotNull(messageUpdate);

		Message message = messageUpdate.getMessage();
		Assert.assertNotNull(message);
		Assert.assertEquals(Integer.valueOf(1593092311), message.getDate());
		Assert.assertEquals(Integer.valueOf(381980621), message.getFromId());
		Assert.assertEquals(Integer.valueOf(0), message.getId());
		Assert.assertEquals(Integer.valueOf(2000000001), message.getPeerId());
		Assert.assertEquals("test", message.getText());
		Assert.assertEquals(Integer.valueOf(4392), message.getConversationMessageId());
		Assert.assertFalse(message.isImportant());
		Assert.assertEquals(Integer.valueOf(0), message.getRandomId());
		Assert.assertFalse(message.isHidden());

		ClientInfo clientInfo = messageUpdate.getClientInfo();
		Assert.assertNotNull(clientInfo);
		Assert.assertTrue(clientInfo.isKeyboardAllowed());
		Assert.assertTrue(clientInfo.isInlineKeyboardAllowed());
		Assert.assertEquals(Integer.valueOf(0), clientInfo.getLangId());

		List<String> expected = Arrays.asList(
				"text",
				"vkpay",
				"open_app",
				"location",
				"open_link"
		);
		List<String> buttonActions = clientInfo.getButtonActions();
		Assert.assertEquals(expected, buttonActions);
	}

	@Test
	public void test2_messageNewReply() throws IOException {
		JsonObject jsonObject = readJson("json/response/message_new/message_new_reply_sample_5_110.json");
		UpdateResponse updateResponse = new UpdateResponseConverterImpl().convert(jsonObject);
		Message replyMessage = ((MessageUpdate) updateResponse.getUpdates().get(0).getObject())
				.getMessage()
				.getReplyMessage();
		Assert.assertNotNull(replyMessage);
		Assert.assertEquals(Integer.valueOf(1593092313), replyMessage.getDate());
		Assert.assertEquals(Integer.valueOf(381980625), replyMessage.getFromId());
		Assert.assertEquals("test", replyMessage.getText());
		Assert.assertEquals(Integer.valueOf(4392), replyMessage.getConversationMessageId());
		Assert.assertEquals(Integer.valueOf(2000000155), replyMessage.getPeerId());
		Assert.assertEquals(Integer.valueOf(2182835), replyMessage.getId());
	}

	@Test
	public void test3_messageNewFwd() throws IOException {
		JsonObject jsonObject = readJson("json/response/message_new/message_new_fwd_sample_5_110.json");
		List<Message> fwdMessages = ((MessageUpdate) new UpdateResponseConverterImpl().convert(jsonObject).getUpdates().get(0).getObject()).getMessage().getFwdMessages();
		Assert.assertNotNull(fwdMessages);
		Assert.assertEquals(1, fwdMessages.size());

		Message message = fwdMessages.get(0);
		Assert.assertNotNull(message);
		Assert.assertEquals(Integer.valueOf(1590523631), message.getDate());
		Assert.assertEquals(Integer.valueOf(373295385), message.getFromId());
		Assert.assertEquals("testFwd", message.getText());
		Assert.assertEquals(Integer.valueOf(102248), message.getConversationMessageId());
		Assert.assertEquals(Integer.valueOf(2000000072), message.getPeerId());
		Assert.assertEquals(Integer.valueOf(2104622), message.getId());
	}

	@Test
	public void test4_messageNewPhoto() throws IOException {
		JsonObject jsonObject = readJson("json/response/message_new/message_new_photo_sample_5_110.json");
		List<Attachment> attachments = ((MessageUpdate) new UpdateResponseConverterImpl().convert(jsonObject).getUpdates().get(0).getObject()).getMessage().getAttachments();
		Assert.assertNotNull(attachments);
		Assert.assertEquals(1, attachments.size());

		Attachment attachment = attachments.get(0);
		Assert.assertNotNull(attachment);
		Assert.assertEquals("photo", attachment.getType());

		MediaObject mediaObject = attachment.getMediaObject();
		Assert.assertNotNull(mediaObject);
		Photo photo = (Photo) mediaObject;
		Assert.assertEquals(Integer.valueOf(-3), photo.getAlbumId());
		Assert.assertEquals(Integer.valueOf(1593095192), photo.getDate());
		Assert.assertEquals(Integer.valueOf(457247057), photo.getId());
		Assert.assertEquals(Integer.valueOf(381980625), photo.getOwnerId());

		List<Size> sizes = photo.getSizes();
		Assert.assertNotNull(sizes);
		Assert.assertFalse(sizes.isEmpty());

		Size size = sizes.get(0);
		Assert.assertNotNull(size);
		Assert.assertEquals(Integer.valueOf(130), size.getHeight());
		Assert.assertEquals(Integer.valueOf(130), size.getWidth());
		Assert.assertEquals("m", size.getType());
		Assert.assertEquals("https://sun9-49.userapi.com/m0bXxRbjkI0X2SAClsqAZsRYVpiSgc6MEBAVtA/2VVGupYl8uM.jpg", size.getUrl());
	}

	@Test
	public void test5_messageNewVideo() throws IOException {
		JsonObject jsonObject = readJson("json/response/message_new/message_new_video_sample_5_110.json");
		List<Attachment> attachments = ((MessageUpdate) new UpdateResponseConverterImpl().convert(jsonObject).getUpdates().get(0).getObject()).getMessage().getAttachments();
		Assert.assertNotNull(attachments);
		Assert.assertEquals(1, attachments.size());

		Attachment attachment = attachments.get(0);
		Assert.assertNotNull(attachment);
		Assert.assertEquals("video", attachment.getType());

		Video video = (Video) attachment.getMediaObject();
		Assert.assertNotNull(video);
		Assert.assertEquals("240114b02909e5852f", video.getAccessKey());
		Assert.assertTrue(video.isCanAdd());
		Assert.assertEquals(Integer.valueOf(0), video.getCommentsAmount());
		Assert.assertEquals(Integer.valueOf(1593106800), video.getDate());
		Assert.assertFalse(video.getDescription().isEmpty());
		Assert.assertEquals(Integer.valueOf(360), video.getDuration());
		Assert.assertEquals(Integer.valueOf(456239346), video.getId());
		Assert.assertEquals(Integer.valueOf(381980625), video.getOwnerId());
		Assert.assertEquals("20 MOST POPULAR TUNES EVER", video.getTitle());
		Assert.assertFalse(video.getTrackCode().isEmpty());
		Assert.assertEquals("video", video.getType());
		Assert.assertEquals(Integer.valueOf(1), video.getViews());
		Assert.assertEquals(Integer.valueOf(0), video.getLocalViews());
		Assert.assertEquals("YouTube", video.getPlatform());

		List<VideoImage> images = video.getImage();
		Assert.assertNotNull(images);
		Assert.assertFalse(images.isEmpty());

		VideoImage image = images.get(0);
		Assert.assertNotNull(image);
		Assert.assertEquals(Integer.valueOf(96), image.getHeight());
		Assert.assertEquals(Integer.valueOf(130), image.getWidth());
		Assert.assertFalse(image.getUrl().isEmpty());
		Assert.assertTrue(image.isWithPadding());
	}

	@Test
	public void test6_messageNewAudio() throws IOException {
		JsonObject jsonObject = readJson("json/response/message_new/message_new_audio_sample_5_110.json");
		List<Attachment> attachments = ((MessageUpdate) new UpdateResponseConverterImpl().convert(jsonObject).getUpdates().get(0).getObject()).getMessage().getAttachments();
		Assert.assertNotNull(attachments);
		Assert.assertEquals(1, attachments.size());

		Attachment attachment = attachments.get(0);
		Assert.assertNotNull(attachment);
		Assert.assertEquals("audio", attachment.getType());

		Audio audio = (Audio) attachment.getMediaObject();
		Assert.assertEquals("Linkin Park", audio.getArtist());
		Assert.assertEquals(Integer.valueOf(456289470), audio.getId());
		Assert.assertEquals(Integer.valueOf(371745461), audio.getOwnerId());
		Assert.assertEquals("In the End",  audio.getTitle());
		Assert.assertEquals(Integer.valueOf(219), audio.getDuration());
		Assert.assertEquals(Integer.valueOf(1490105766), audio.getDate());
		Assert.assertEquals(Integer.valueOf(2), audio.getContentRestricted());

		List<MainArtist> mainArtists = audio.getMainArtists();
		Assert.assertNotNull(mainArtists);
		Assert.assertEquals(1, mainArtists.size());

		MainArtist mainArtist = mainArtists.get(0);
		Assert.assertNotNull(mainArtist);
		Assert.assertEquals("Linkin Park", mainArtist.getName());
		Assert.assertEquals("67550258036106963", mainArtist.getId());
	}

	@Test
	public void test7_messageNewDocPhoto() throws IOException {
		JsonObject jsonObject = readJson("json/response/message_new/message_new_doc_photo_sample_5_110.json");
		List<Attachment> attachments = ((MessageUpdate) new UpdateResponseConverterImpl().convert(jsonObject).getUpdates().get(0).getObject()).getMessage().getAttachments();
		Assert.assertNotNull(attachments);
		Assert.assertEquals(1, attachments.size());

		Attachment attachment = attachments.get(0);
		Assert.assertNotNull(attachment);
		Assert.assertEquals("doc", attachment.getType());

		Document document = (Document) attachment.getMediaObject();
		Assert.assertEquals(Integer.valueOf(557093429), document.getId());
		Assert.assertEquals(Integer.valueOf(381980625), document.getOwnerId());
		Assert.assertEquals("x_fc4.png", document.getTitle());
		Assert.assertEquals(Integer.valueOf(756010), document.getSize());
		Assert.assertEquals("png", document.getExt());
		Assert.assertEquals(Integer.valueOf(1593165675), document.getDate());
		Assert.assertEquals(DocumentTypes.IMAGES, document.getType());

		Preview preview = document.getPreview();
		Assert.assertNotNull(preview);
		Assert.assertTrue(preview.hasPhotoPreview());

		PhotoPreview photoPreview = preview.getPhotoPreview();
		Assert.assertNotNull(photoPreview);

		List<PhotoPreviewSize> sizes = photoPreview.getSizes();
		Assert.assertNotNull(sizes);
		Assert.assertFalse(sizes.isEmpty());

		PhotoPreviewSize size = sizes.get(0);
		Assert.assertNotNull(size);
		Assert.assertEquals(Integer.valueOf(130), size.getWidth());
		Assert.assertEquals(Integer.valueOf(100), size.getHeight());
		Assert.assertEquals("m", size.getType());
	}

	@Test
	public void test8_messageNewAudioMessage() throws IOException {
		JsonObject jsonObject = readJson("json/response/message_new/message_new_audio_message_sample_5_110.json");
		List<Attachment> attachments = ((MessageUpdate) new UpdateResponseConverterImpl().convert(jsonObject).getUpdates().get(0).getObject()).getMessage().getAttachments();
		Assert.assertNotNull(attachments);
		Assert.assertEquals(1, attachments.size());

		Attachment attachment = attachments.get(0);
		Assert.assertNotNull(attachment);
		Assert.assertEquals("audio_message", attachment.getType());

		AudioMessage audioMessage = (AudioMessage) attachment.getMediaObject();
		Assert.assertNotNull(audioMessage);
		Assert.assertEquals(Integer.valueOf(557103745), audioMessage.getId());
		Assert.assertEquals(Integer.valueOf(381980625), audioMessage.getOwnerId());
		Assert.assertEquals(Integer.valueOf(2), audioMessage.getDuration());
		Assert.assertFalse(audioMessage.getLinkMp3().isEmpty());
		Assert.assertFalse(audioMessage.getLinkOgg().isEmpty());

		List<Integer> waveform = audioMessage.getWaveform();
		Assert.assertNotNull(waveform);
		Assert.assertFalse(waveform.isEmpty());
	}

	@Test
	public void test9_messageNewGraffiti() throws IOException {
		JsonObject jsonObject = readJson("json/response/message_new/message_new_graffiti_sample_5_110.json");
		List<Attachment> attachments = ((MessageUpdate) new UpdateResponseConverterImpl().convert(jsonObject).getUpdates().get(0).getObject()).getMessage().getAttachments();
		Assert.assertNotNull(attachments);
		Assert.assertEquals(1, attachments.size());

		Attachment attachment = attachments.get(0);
		Assert.assertNotNull(attachment);
		Assert.assertEquals("graffiti", attachment.getType());

		Graffiti graffiti = (Graffiti) attachment.getMediaObject();
		Assert.assertNotNull(graffiti);
		Assert.assertEquals(Integer.valueOf(538172633), graffiti.getId());
		Assert.assertEquals(Integer.valueOf(381980625), graffiti.getOwnerId());
		Assert.assertEquals(Integer.valueOf(720), graffiti.getWidth());
		Assert.assertEquals(Integer.valueOf(714), graffiti.getHeight());
	}

	@Test
	public void test10_messageNewGeo() throws IOException {
		JsonObject jsonObject = readJson("json/response/message_new/message_new_geo_sample_5_110.json");
		Geo geo = ((MessageUpdate) new UpdateResponseConverterImpl().convert(jsonObject).getUpdates().get(0).getObject()).getMessage().getGeo();
		Assert.assertNotNull(geo);
		Assert.assertEquals("point", geo.getType());

		Coordinates coordinates = geo.getCoordinates();
		Assert.assertNotNull(coordinates);
		Assert.assertTrue(String.valueOf(coordinates.getLatitude()).startsWith("23.43"));
		Assert.assertTrue(String.valueOf(coordinates.getLongitude()).startsWith("7.03"));
	}

	@Test
	public void test11_messageNewSticker() throws IOException {
		JsonObject jsonObject = readJson("json/response/message_new/message_new_sticker_sample_5_110.json");
		List<Attachment> attachments = ((MessageUpdate) new UpdateResponseConverterImpl().convert(jsonObject).getUpdates().get(0).getObject()).getMessage().getAttachments();
		Assert.assertNotNull(attachments);
		Assert.assertEquals(1, attachments.size());

		Attachment attachment = attachments.get(0);
		Assert.assertNotNull(attachment);
		Assert.assertEquals("sticker", attachment.getType());

		Sticker sticker = (Sticker) attachment.getMediaObject();
		Assert.assertNotNull(sticker);
		Assert.assertEquals(Integer.valueOf(279), sticker.getProductId());
		Assert.assertEquals(Integer.valueOf(9012), sticker.getStickerId());

		List<Image> images = sticker.getImages();
		Assert.assertNotNull(images);
		Assert.assertFalse(images.isEmpty());

		Image image = images.get(0);
		Assert.assertNotNull(image);
		Assert.assertFalse(image.getUrl().isEmpty());
		Assert.assertEquals(Integer.valueOf(64), image.getHeight());
		Assert.assertEquals(Integer.valueOf(64), image.getWidth());

		images = sticker.getImagesWithBackground();
		Assert.assertNotNull(images);
		Assert.assertFalse(images.isEmpty());

		image = images.get(0);
		Assert.assertNotNull(image);
		Assert.assertFalse(image.getUrl().isEmpty());
		Assert.assertEquals(Integer.valueOf(64), image.getHeight());
		Assert.assertEquals(Integer.valueOf(64), image.getWidth());
	}

	@Test
	public void test12_messageNewWall() throws IOException {
		JsonObject jsonObject = readJson("json/response/message_new/message_new_wall_sample_5_110.json");
		List<Attachment> attachments = ((MessageUpdate) new UpdateResponseConverterImpl().convert(jsonObject).getUpdates().get(0).getObject()).getMessage().getAttachments();
		Assert.assertNotNull(attachments);
		Assert.assertEquals(1, attachments.size());

		Attachment attachment = attachments.get(0);
		Assert.assertNotNull(attachment);
		Assert.assertEquals("wall", attachment.getType());

		WallPost wallPost = (WallPost) attachment.getMediaObject();
		Assert.assertNotNull(wallPost);
		Assert.assertEquals(Integer.valueOf(110926), wallPost.getId());
		Assert.assertEquals(Integer.valueOf(-153395656), wallPost.getFromId());
		Assert.assertEquals(Integer.valueOf(-153395656), wallPost.getToId());
		Assert.assertEquals(Integer.valueOf(1594228961), wallPost.getDate());
		Assert.assertEquals("post", wallPost.getPostType());
		Assert.assertFalse(wallPost.getText().isEmpty());
		Assert.assertFalse(wallPost.isMarkedAsAds());

		List<Attachment> wallAttachments = wallPost.getAttachments();
		Assert.assertNotNull(wallAttachments);
		Assert.assertFalse(wallAttachments.isEmpty());

		attachment = wallAttachments.get(0);
		Assert.assertNotNull(attachment);
		Assert.assertEquals("photo", attachment.getType());

		MediaObject mediaObject = attachment.getMediaObject();
		Assert.assertNotNull(mediaObject);
		Assert.assertTrue(mediaObject instanceof Photo);

		Comments comments = wallPost.getComments();
		Assert.assertNotNull(comments);
		Assert.assertEquals(Integer.valueOf(7), comments.getCount());

		WallPostLikes wallPostLikes = wallPost.getWallPostLikes();
		Assert.assertNotNull(wallPostLikes);
		Assert.assertEquals(Integer.valueOf(98), wallPostLikes.getCount());

		Views views = wallPost.getViews();
		Assert.assertNotNull(views);
		Assert.assertEquals(Integer.valueOf(2597), views.getCount());

		Reposts reposts = wallPost.getReposts();
		Assert.assertNotNull(reposts);
		Assert.assertEquals(Integer.valueOf(0), reposts.getCount());

		From from = wallPost.getFrom();
		Assert.assertNotNull(from);
		Assert.assertEquals(Integer.valueOf(153395656), from.getId());
	}

	@Test
	public void test13_messageNewWallReply() throws IOException {
		JsonObject jsonObject = readJson("json/response/message_new/message_new_wall_reply_sample_5_110.json");
		List<Attachment> attachments = ((MessageUpdate) new UpdateResponseConverterImpl().convert(jsonObject).getUpdates().get(0).getObject()).getMessage().getAttachments();
		Assert.assertNotNull(attachments);
		Assert.assertEquals(1, attachments.size());

		Attachment attachment = attachments.get(0);
		Assert.assertNotNull(attachment);
		Assert.assertEquals("wall_reply", attachment.getType());

		WallReply wallReply = (WallReply) attachment.getMediaObject();
		Assert.assertNotNull(wallReply);
		Assert.assertEquals(Integer.valueOf(110932), wallReply.getId());
		Assert.assertEquals(Integer.valueOf(10564569), wallReply.getFromId());
		Assert.assertEquals(Integer.valueOf(110926), wallReply.getPostId());
		Assert.assertEquals(Integer.valueOf(-153395656), wallReply.getOwnerId());
		Assert.assertEquals(Integer.valueOf(1594231450), wallReply.getDate());
		Assert.assertFalse(wallReply.getText().isEmpty());
		Assert.assertEquals(new Integer(150408292), wallReply.getReplyToUser());
		Assert.assertEquals(new Integer(110930), wallReply.getReplyToComment());

		List<Integer> parentsStack = wallReply.getParentsStack();
		Assert.assertNotNull(parentsStack);
		Assert.assertEquals(1, parentsStack.size());

		Integer integer = parentsStack.get(0);
		Assert.assertNotNull(integer);
		Assert.assertEquals(110930, integer.intValue());

		WallReplyLikes likes = wallReply.getLikes();
		Assert.assertNotNull(likes);
		Assert.assertEquals(Integer.valueOf(1), likes.getCount());
		Assert.assertFalse(likes.isUserLikes());
		Assert.assertTrue(likes.isCanLike());
	}
}
