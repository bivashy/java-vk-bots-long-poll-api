package parse.response.audio;

import api.longpoll.bots.model.events.Update;
import api.longpoll.bots.model.objects.media.Audio;
import org.junit.jupiter.api.Test;
import parse.response.ParseUtil;

import static org.junit.jupiter.api.Assertions.*;

public class AudioNewParseTest {
    @Test
    void audioNew() {
        Update event = ParseUtil.getFirstEvent("json/response/audio_new/audio_new_sample_5_110.json");
        assertEquals(Update.Type.AUDIO_NEW, event.getType());
        assertEquals(123, event.getGroupId());
        assertEquals("abc", event.getEventId());

        Update.Object object = event.getObject();
        assertNotNull(object);

        assertTrue(object instanceof Audio);
        Audio audio = (Audio) object;
        assertEquals("Rick Astley", audio.getArtist());
        assertEquals(456239017, audio.getId());
        assertEquals(-111, audio.getOwnerId());
        assertEquals("Never Gonna Give You Up", audio.getTitle());
        assertEquals(211, audio.getDuration());
        String url = audio.getUrl();
        assertNotNull(url);
        assertTrue(url.isEmpty());
        assertEquals(1594822421, audio.getDate());
    }
}
