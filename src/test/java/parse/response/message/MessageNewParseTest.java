package parse.response.message;

import api.longpoll.bots.model.events.Update;
import api.longpoll.bots.model.events.messages.MessageNew;
import api.longpoll.bots.model.objects.additional.ClientInfo;
import api.longpoll.bots.model.objects.additional.Geo;
import api.longpoll.bots.model.objects.additional.Image;
import api.longpoll.bots.model.objects.additional.PhotoSize;
import api.longpoll.bots.model.objects.basic.Message;
import api.longpoll.bots.model.objects.basic.WallComment;
import api.longpoll.bots.model.objects.basic.WallPost;
import api.longpoll.bots.model.objects.media.*;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.junit.jupiter.api.Test;
import parse.response.ParseUtil;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class MessageNewParseTest {
    @Test
    void messageNewText() {
        Update event = ParseUtil.getFirstEvent("json/response/message_new/message_new_text_sample_5_110.json");
        assertEquals(Update.Type.MESSAGE_NEW, event.getType());
        assertEquals(333, event.getGroupId());
        assertEquals("aaa", event.getEventId());

        Update.Object object = event.getObject();
        assertNotNull(object);

        assertTrue(object instanceof MessageNew);
        MessageNew messageUpdate = (MessageNew) object;
        assertNotNull(messageUpdate);

        Message message = messageUpdate.getMessage();
        assertNotNull(message);
        assertEquals(1593092311, message.getDate());
        assertEquals(111, message.getFromId());
        assertEquals(0, message.getId());
        assertEquals(222, message.getPeerId());
        assertEquals("test", message.getText());
        assertEquals(4392, message.getConversationMessageId());
        assertFalse(message.getImportant());
        assertEquals(0, message.getRandomId());

        ClientInfo clientInfo = messageUpdate.getClientInfo();
        assertNotNull(clientInfo);
        assertTrue(clientInfo.isKeyboardAllowed());
        assertTrue(clientInfo.isInlineKeyboardAllowed());
        assertEquals(0, clientInfo.getLangId());

        List<String> expected = Arrays.asList(
                "text",
                "vkpay",
                "open_app",
                "location",
                "open_link"
        );
        List<String> buttonActions = clientInfo.getButtonActions();
        assertEquals(expected, buttonActions);
    }

    @Test
    void messageNewReply() {
        Message replyMessage = ParseUtil.getFirstMessage("json/response/message_new/message_new_reply_sample_5_110.json").getReplyMessage();
        assertNotNull(replyMessage);
        assertEquals(1593092313, replyMessage.getDate());
        assertEquals(333, replyMessage.getFromId());
        assertEquals("test", replyMessage.getText());
        assertEquals(4392, replyMessage.getConversationMessageId());
        assertEquals(444, replyMessage.getPeerId());
        assertEquals(555, replyMessage.getId());
    }

    @Test
    void messageNewFwd() {
        List<Message> fwdMessages = ParseUtil.getFirstMessage("json/response/message_new/message_new_fwd_sample_5_110.json").getFwdMessages();
        assertNotNull(fwdMessages);
        assertFalse(fwdMessages.isEmpty());

        Message fwdMessage = fwdMessages.get(0);
        assertNotNull(fwdMessage);
        assertEquals(1590523631, fwdMessage.getDate());
        assertEquals(333, fwdMessage.getFromId());
        assertEquals("testFwd", fwdMessage.getText());
        assertEquals(102248, fwdMessage.getConversationMessageId());
        assertEquals(444, fwdMessage.getPeerId());
        assertEquals(555, fwdMessage.getId());
    }

    @Test
    void messageNewPhoto() {
        Attachment attachment = ParseUtil.getFirstMessageAttachment("json/response/message_new/message_new_photo_sample_5_110.json");
        assertEquals(Attachment.Type.PHOTO, attachment.getType());

        Photo photo = attachment.getPhoto();
        assertNotNull(photo);
        assertEquals(-3, photo.getAlbumId());
        assertEquals(1593095192, photo.getDate());
        assertEquals(333, photo.getId());
        assertEquals(444, photo.getOwnerId());

        List<PhotoSize> photoSizes = photo.getPhotoSizes();
        assertNotNull(photoSizes);
        assertFalse(photoSizes.isEmpty());

        PhotoSize photoSize = photoSizes.get(0);
        assertNotNull(photoSize);
        assertEquals(130, photoSize.getHeight());
        assertEquals(130, photoSize.getWidth());
        assertEquals("m", photoSize.getType());
        assertEquals("https://sun9-49.userapi.com/m0bXxRbjkI0X2SAClsqAZsRYVpiSgc6MEBAVtA/2VVGupYl8uM.jpg", photoSize.getSrc());
    }

    @Test
    void messageNewVideo() {
        Attachment attachment = ParseUtil.getFirstMessageAttachment("json/response/message_new/message_new_video_sample_5_110.json");
        assertEquals(Attachment.Type.VIDEO, attachment.getType());

        Video video = attachment.getVideo();
        assertNotNull(video);
        assertEquals("aaa", video.getAccessKey());
        assertTrue(video.getCanAdd());
        assertEquals(0, video.getCommentsAmount());
        assertEquals(1593106800, video.getDate());
        assertFalse(video.getDescription().isEmpty());
        assertEquals(360, video.getDuration());
        assertEquals(444, video.getId());
        assertEquals(555, video.getOwnerId());
        assertEquals("20 MOST POPULAR TUNES EVER", video.getTitle());
        assertFalse(video.getTrackCode().isEmpty());
        assertEquals("video", video.getType());
        assertEquals(1, video.getViews());
        assertEquals(0, video.getLocalViews());
        assertEquals("YouTube", video.getPlatform());

        List<Video.VideoImage> images = video.getImage();
        assertNotNull(images);
        assertFalse(images.isEmpty());

        Video.VideoImage image = images.get(0);
        assertNotNull(image);
        assertEquals(96, image.getHeight());
        assertEquals(130, image.getWidth());
        assertFalse(image.getUrl().isEmpty());
        assertTrue(image.getWithPadding());
    }

    @Test
    void messageNewAudio() {
        Attachment attachment = ParseUtil.getFirstMessageAttachment("json/response/message_new/message_new_audio_sample_5_110.json");
        assertEquals(Attachment.Type.AUDIO, attachment.getType());

        Audio audio = attachment.getAudio();
        assertNotNull(audio);
        assertEquals("Linkin Park", audio.getArtist());
        assertEquals(333, audio.getId());
        assertEquals(444, audio.getOwnerId());
        assertEquals("In the End", audio.getTitle());
        assertEquals(219, audio.getDuration());
        assertEquals(1490105766, audio.getDate());
    }

    @Test
    void messageNewDocPhoto() {
        Attachment attachment = ParseUtil.getFirstMessageAttachment("json/response/message_new/message_new_doc_photo_sample_5_110.json");
        assertEquals(Attachment.Type.DOCUMENT, attachment.getType());

        Doc doc = attachment.getDoc();
        assertNotNull(doc);
        assertEquals(333, doc.getId());
        assertEquals(444, doc.getOwnerId());
        assertEquals("x_fc4.png", doc.getTitle());
        assertEquals(756010, doc.getSize());
        assertEquals("png", doc.getExt());
        assertEquals(1593165675, doc.getDate());
        assertEquals(DocType.IMAGES, doc.getType());

        Map<DocPreviewType, Doc.Preview> preview = doc.getPreview();
        assertNotNull(preview);
        assertTrue(preview.containsKey(DocPreviewType.PHOTO));

        Doc.Preview photoPreview = preview.get(DocPreviewType.PHOTO);
        assertNotNull(photoPreview);
        assertTrue(photoPreview instanceof Doc.Photo);

        List<PhotoSize> sizes = ((Doc.Photo) photoPreview).getSizes();
        assertNotNull(sizes);
        assertFalse(sizes.isEmpty());

        PhotoSize size = sizes.get(0);
        assertNotNull(size);
        assertEquals(130, size.getWidth());
        assertEquals(100, size.getHeight());
        assertEquals("m", size.getType());
    }

    @Test
    void messageNewAudioMessage() {
        Attachment attachment = ParseUtil.getFirstMessageAttachment("json/response/message_new/message_new_audio_message_sample_5_110.json");
        assertEquals(Attachment.Type.AUDIO_MESSAGE, attachment.getType());

        AudioMessage audioMessage = attachment.getAudioMessage();
        assertNotNull(audioMessage);
        assertEquals(333, audioMessage.getId());
        assertEquals(444, audioMessage.getOwnerId());
        assertEquals(2, audioMessage.getDuration());
        String linkMp3 = audioMessage.getLinkMp3();
        assertNotNull(linkMp3);
        assertFalse(linkMp3.isEmpty());
        String linkOgg = audioMessage.getLinkOgg();
        assertNotNull(linkOgg);
        assertFalse(linkOgg.isEmpty());

        List<Integer> waveform = audioMessage.getWaveform();
        assertNotNull(waveform);
        assertFalse(waveform.isEmpty());
    }

    @Test
    void messageNewGraffiti() {
        Attachment attachment = ParseUtil.getFirstMessageAttachment("json/response/message_new/message_new_graffiti_sample_5_110.json");
        assertEquals(Attachment.Type.GRAFFITI, attachment.getType());

        Graffiti graffiti = attachment.getGraffiti();
        assertNotNull(graffiti);
        assertEquals(333, graffiti.getId());
        assertEquals(444, graffiti.getOwnerId());
        assertEquals(720, graffiti.getWidth());
        assertEquals(714, graffiti.getHeight());
    }

    @Test
    void messageNewGeo() {
        Message message = ParseUtil.getFirstMessage("json/response/message_new/message_new_geo_sample_5_110.json");
        Geo geo = message.getGeo();
        assertNotNull(geo);
        assertEquals("point", geo.getType());

        Geo.Coordinates coordinates = geo.getCoordinates();
        assertNotNull(coordinates);
        assertTrue(String.valueOf(coordinates.getLatitude()).startsWith("23.43"));
        assertTrue(String.valueOf(coordinates.getLongitude()).startsWith("7.03"));
    }

    @Test
    void messageNewSticker() {
        Attachment attachment = ParseUtil.getFirstMessageAttachment("json/response/message_new/message_new_sticker_sample_5_110.json");
        assertEquals(Attachment.Type.STICKER, attachment.getType());

        Sticker sticker = attachment.getSticker();
        assertNotNull(sticker);
        assertEquals(279, sticker.getProductId());
        assertEquals(9012, sticker.getStickerId());

        List<Image> images = sticker.getImages();
        assertNotNull(images);
        assertFalse(images.isEmpty());

        Image image = images.get(0);
        assertNotNull(image);
        String url = image.getUrl();
        assertNotNull(url);
        assertFalse(url.isEmpty());
        assertEquals(64, image.getHeight());
        assertEquals(64, image.getWidth());

        images = sticker.getImagesWithBackground();
        assertNotNull(images);
        assertFalse(images.isEmpty());

        image = images.get(0);
        assertNotNull(image);
        url = image.getUrl();
        assertNotNull(url);
        assertFalse(url.isEmpty());
        assertEquals(64, image.getHeight());
        assertEquals(64, image.getWidth());
    }

    @Test
    void messageNewWall() {
        Attachment attachment = ParseUtil.getFirstMessageAttachment("json/response/message_new/message_new_wall_sample_5_110.json");
        assertEquals(Attachment.Type.WALL_POST, attachment.getType());

        WallPost wallPost = attachment.getWall();
        assertNotNull(wallPost);
        assertEquals(333, wallPost.getId());
        assertEquals(-444, wallPost.getFromId());
        assertEquals(1594228961, wallPost.getDate());
        assertEquals("post", wallPost.getPostType());
        String text = wallPost.getText();
        assertNotNull(text);
        assertFalse(text.isEmpty());
        assertFalse(wallPost.getMarkedAsAds());

        List<Attachment> wallAttachments = wallPost.getAttachments();
        assertNotNull(wallAttachments);
        assertFalse(wallAttachments.isEmpty());

        Attachment wallAttachment = wallAttachments.get(0);
        assertNotNull(wallAttachment);
        assertEquals(Attachment.Type.PHOTO, wallAttachment.getType());

        assertNotNull(wallAttachment.getPhoto());

        WallPost.Comments comments = wallPost.getComments();
        assertNotNull(comments);
        assertEquals(7, comments.getCount());

        WallPost.Likes wallPostLikes = wallPost.getLikes();
        assertNotNull(wallPostLikes);
        assertEquals(98, wallPostLikes.getCount());

        WallPost.Views views = wallPost.getViews();
        assertNotNull(views);
        assertEquals(2597, views.getCount());

        WallPost.Reposts reposts = wallPost.getReposts();
        assertNotNull(reposts);
        assertEquals(0, reposts.getCount());
    }

    @Test
    void messageNewWallReply() {
        Attachment attachment = ParseUtil.getFirstMessageAttachment("json/response/message_new/message_new_wall_reply_sample_5_110.json");
        assertEquals(Attachment.Type.WALL_REPLY, attachment.getType());

        WallComment wallReply = attachment.getWallReply();
        assertNotNull(wallReply);
        assertEquals(333, wallReply.getId());
        assertEquals(444, wallReply.getFromId());
        assertEquals(555, wallReply.getPostId());
        assertEquals(-666, wallReply.getOwnerId());
        assertEquals(1594231450, wallReply.getDate());
        String text = wallReply.getText();
        assertNotNull(text);
        assertFalse(text.isEmpty());
        assertEquals(888, wallReply.getReplyToUser());
        assertEquals(999, wallReply.getReplyToComment());

        List<Integer> parentsStack = wallReply.getParentsStack();
        assertNotNull(parentsStack);
        assertFalse(parentsStack.isEmpty());

        Integer integer = parentsStack.get(0);
        assertNotNull(integer);
        assertEquals(777, integer);

        WallComment.Likes likes = wallReply.getLikes();
        assertNotNull(likes);
        assertEquals(1, likes.getCount());
        assertFalse(likes.getUserLikes());
        assertTrue(likes.getCanLike());
    }

    @Test
    void messageNewDocNoPreview() {
        Attachment attachment = ParseUtil.getFirstMessageAttachment("json/response/message_new/message_new_doc_no_preview_sample_5_118.json");
        assertEquals(Attachment.Type.DOCUMENT, attachment.getType());

        Doc doc = attachment.getDoc();
        assertNotNull(doc);
        assertEquals(456, doc.getId());
        assertEquals(789, doc.getOwnerId());
        assertEquals("canvas.rar", doc.getTitle());
        assertEquals(2325, doc.getSize());
        assertEquals("rar", doc.getExt());
        assertEquals(1559985418, doc.getDate());
        assertEquals(DocType.ARCHIVES, doc.getType());
        assertEquals("https://vk.com/doc1234", doc.getUrl());
        assertEquals("5678", doc.getAccessKey());
        assertNull(doc.getPreview());
    }

    @Test
    void messageNewFwdAttachments() {
        Message message = ParseUtil.getFirstMessage("json/response/message_new/message_new_fwd_attachments_sample_5_118.json");
        assertTrue(message.hasFwdMessages());

        List<Message> fwdMessages = message.getFwdMessages();
        Message fwdMessage = fwdMessages.get(0);
        assertNotNull(fwdMessage);
        assertEquals(1615559549, fwdMessage.getDate());
        assertEquals(1234, fwdMessage.getFromId());
        assertTrue(fwdMessage.hasAttachments());

        List<Attachment> attachments = fwdMessage.getAttachments();
        Attachment attachment = attachments.get(0);
        assertNotNull(attachment);
        assertEquals(Attachment.Type.DOCUMENT, attachment.getType());

        Doc doc = attachment.getDoc();
        assertNotNull(doc);
        assertEquals(592161514, doc.getId());
        assertEquals(1234, doc.getOwnerId());
        assertEquals("my_file.docx", doc.getTitle());
        assertEquals(11614, doc.getSize());
        assertEquals("docx", doc.getExt());
        assertEquals(1615559548, doc.getDate());
        assertEquals(DocType.TEXT_DOCUMENT, doc.getType());
        assertNotNull(doc.getUrl());
    }

    @Test
    void messageNewReplyAttachment() {
        Message message = ParseUtil.getFirstMessage("json/response/message_new/message_new_reply_attachment_sample_5_118.json");
        assertTrue(message.hasReplyMessage());

        Message replyMessage = message.getReplyMessage();
        assertTrue(replyMessage.hasAttachments());

        List<Attachment> attachments = replyMessage.getAttachments();
        Attachment attachment = attachments.get(0);
        assertNotNull(attachment);
        assertEquals(Attachment.Type.PHOTO, attachment.getType());

        Photo photo = attachment.getPhoto();
        assertNotNull(photo);
        assertEquals(432, photo.getId());

        List<PhotoSize> photoSizes = photo.getPhotoSizes();
        assertNotNull(photoSizes);
        assertFalse(photoSizes.isEmpty());
    }

    @Test
    void messageNewPayload() {
        Message message = ParseUtil.getFirstMessage("json/response/message_new/message_new_payload_sample_5_118.json");
        JsonElement element = message.getPayload();
        assertNotNull(element);
        assertTrue(element.isJsonObject());
        JsonObject payload = element.getAsJsonObject();
        //assertEquals("{\"data\":\"clicked\",\"time\":1622383763657,\"values\":[11,22,33],\"status\":{\"active\":true}}", payload);
        assertTrue(payload.has("data"));
        assertEquals("clicked", payload.get("data").getAsString());
        assertTrue(payload.has("time"));
        assertEquals(1622383763657L, payload.get("time").getAsLong());

        assertTrue(payload.has("values"));
        JsonArray jsonArray = payload.getAsJsonArray("values");
        assertEquals(3, jsonArray.size());
        assertEquals(11, jsonArray.get(0).getAsInt());
        assertEquals(22, jsonArray.get(1).getAsInt());
        assertEquals(33, jsonArray.get(2).getAsInt());

        assertTrue(payload.has("status"));
        JsonObject jsonObject = payload.getAsJsonObject("status");
        assertTrue(jsonObject.has("active"));
        assertTrue(jsonObject.get("active").getAsBoolean());
    }
}
