package updates.message;

import api.longpoll.bots.model.objects.additional.PhotoSize;
import api.longpoll.bots.model.objects.basic.Message;
import api.longpoll.bots.model.objects.media.*;
import org.junit.jupiter.api.Test;
import parse.response.ParseUtil;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MessageNewTest {
    @Test
    void attachedLink() {
        Attachment attachment = ParseUtil.getFirstMessageAttachment("updates/message_new/attached_link.json");
        assertEquals(AttachmentType.LINK, attachment.getType());

        Attachable attachable = attachment.getAttachable();
        assertNotNull(attachable);
        assertTrue(attachable instanceof AttachedLink);

        AttachedLink attachedLink = (AttachedLink) attachable;
        assertEquals("https://github.com/yvasyliev/java-vk-bots-long-poll-api", attachedLink.getUrl());
        assertEquals("yvasyliev/java-vk-bots-long-poll-api", attachedLink.getTitle());
        assertEquals("github.com", attachedLink.getCaption());
        assertEquals("A Java library to create VK bots using Bots Long Poll API - yvasyliev/java-vk-bots-long-poll-api", attachedLink.getDescription());

        Photo photo = attachedLink.getPhoto();
        assertNotNull(photo);
        assertEquals(-27, photo.getAlbumId());
        assertEquals(1619335586, photo.getDate());
        assertEquals(457322865, photo.getId());
        assertEquals(2000017109, photo.getOwnerId());

        List<PhotoSize> photoSizes = photo.getPhotoSizes();
        assertNotNull(photoSizes);
        assertFalse(photoSizes.isEmpty());

        PhotoSize photoSize0 = photoSizes.get(0);
        assertEquals(37, photoSize0.getHeight());
        assertEquals("https://sun9-29.userapi.com/impg/OvMA7f_WGkTDvF4kAqPj9OkT07yazrQMmqpduA/oEFb8ib4hig.jpg?size=75x35&quality=96&crop=22,0,1029,480&sign=37688420da0ef4dd81630d075423caf0&c_uniq_tag=QsfVCzgpoK3PsVaCjbUReEvMe5H2ffwYGFQMpLPj6kI&type=share", photoSize0.getUrl());
        assertEquals("s", photoSize0.getType());
        assertEquals(75, photoSize0.getWidth());
    }

    @Test
    void bomb() {
        Message message = ParseUtil.getFirstMessage("json/response/message_new/message_new_bomb_sample_5_118.json");
        assertTrue(message.isTemporaryMessage());
        assertEquals(15, message.getExpireTtl());
    }
}
