package updates.message;

import api.longpoll.bots.model.objects.additional.PhotoSize;
import api.longpoll.bots.model.objects.basic.Message;
import api.longpoll.bots.model.objects.basic.Poll;
import api.longpoll.bots.model.objects.media.*;
import org.junit.jupiter.api.Test;
import parse.response.ParseUtil;

import java.util.List;
import java.util.stream.Stream;

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
        assertEquals("https://sun9-29.userapi.com/impg/OvMA7f_WGkTDvF4kAqPj9OkT07yazrQMmqpduA/oEFb8ib4hig.jpg?size=75x35&quality=96&crop=22,0,1029,480&sign=37688420da0ef4dd81630d075423caf0&c_uniq_tag=QsfVCzgpoK3PsVaCjbUReEvMe5H2ffwYGFQMpLPj6kI&type=share", photoSize0.getSrc());
        assertEquals("s", photoSize0.getType());
        assertEquals(75, photoSize0.getWidth());
    }

    @Test
    void bomb() {
        Message message = ParseUtil.getFirstMessage("json/response/message_new/message_new_bomb_sample_5_118.json");
        assertTrue(message.isTemporaryMessage());
        assertEquals(15, message.getExpireTtl());
    }

    @Test
    void poll() {
        Attachment attachment = ParseUtil.getFirstMessageAttachment("updates/message_new/poll.json");
        assertEquals(AttachmentType.POLL, attachment.getType());

        Attachable attachable = attachment.getAttachable();
        assertNotNull(attachable);
        assertTrue(attachable instanceof Poll);

        Poll poll = (Poll) attachable;
        assertFalse(poll.getMultiple());
        assertEquals(0, poll.getEndDate());
        assertFalse(poll.getBoard());
        assertTrue(poll.getCanEdit());
        assertTrue(poll.getCanVote());
        assertFalse(poll.getCanReport());
        assertTrue(poll.getCanShare());
        assertEquals(1632906778, poll.getCreated());
        assertEquals(633308954, poll.getId());
        assertEquals(918650328, poll.getOwnerId());
        assertEquals("What is better?", poll.getQuestion());
        assertEquals(21, poll.getVotes());
        assertFalse(poll.getAnonymous());
        assertEquals(918650328, poll.getAuthorId());

        List<Poll.Friend> friends = poll.getFriends();
        assertNotNull(friends);
        assertEquals(3, friends.size());

        Poll.Friend friend = friends.get(0);
        assertNotNull(friend);
        assertEquals(918650328, friend.getId());

        friend = friends.get(1);
        assertNotNull(friend);
        assertEquals(25627166, friend.getId());

        friend = friends.get(2);
        assertNotNull(friend);
        assertEquals(40490031, friend.getId());

        List<Integer> answerIds = poll.getAnswerIds();
        assertNotNull(answerIds);
        assertFalse(answerIds.isEmpty());
        assertEquals(1831815044, answerIds.get(0));

        List<Poll.Answer> answers = poll.getAnswers();
        assertNotNull(answers);
        assertEquals(4, answers.size());

        Poll.Answer answer = answers.get(0);
        assertNotNull(answer);
        assertEquals(1831812069, answer.getId());
        assertEquals("Google drive", answer.getText());
        assertEquals(10, answer.getVotes());

        answer = answers.get(1);
        assertNotNull(answer);
        assertEquals(1831812070, answer.getId());
        assertEquals("One drive", answer.getText());
        assertEquals(1, answer.getVotes());

        answer = answers.get(2);
        assertNotNull(answer);
        assertEquals(1831812071, answer.getId());
        assertEquals("Drop box", answer.getText());
        assertEquals(2, answer.getVotes());

        answer = answers.get(3);
        assertNotNull(answer);
        assertEquals(1831815044, answer.getId());
        assertEquals("Other", answer.getText());
        assertEquals(8, answer.getVotes());

        Poll.Background background = poll.getBackground();
        assertNotNull(background);
        assertEquals(225, background.getAngle());
        assertEquals("6248cb", background.getColor());
        assertEquals(1, background.getId());

        List<Poll.Background.Point> points = background.getPoints();
        assertNotNull(points);
        assertEquals(2, points.size());

        Poll.Background.Point point = points.get(0);
        assertNotNull(point);
        assertEquals("f24973", point.getColor());

        point = points.get(1);
        assertNotNull(point);
        assertEquals("3948e6", point.getColor());
    }
}
