package parse.response.photo;

import api.longpoll.bots.converters.response.events.GetEventsResultConverterImpl;
import api.longpoll.bots.model.objects.media.Photo;
import api.longpoll.bots.model.objects.additional.PhotoSize;
import api.longpoll.bots.model.events.Event;
import api.longpoll.bots.model.events.EventObject;
import api.longpoll.bots.model.response.events.GetEventsResult;
import com.google.gson.JsonObject;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import parse.response.AbstractParseTest;

import java.io.IOException;
import java.util.List;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PhotoNewParseTest extends AbstractParseTest {
    @Test
    public void test1_messageEdit() throws IOException {
        JsonObject jsonObject = readJson("json/response/photo_new/photo_new_sample_5_110.json");
        GetEventsResult getEventsResult = new GetEventsResultConverterImpl().convert(jsonObject);
        Assert.assertNotNull(getEventsResult);
        Assert.assertEquals(Integer.valueOf(2612), getEventsResult.getTs());

        List<Event> events = getEventsResult.getEvents();
        Assert.assertNotNull(events);
        Assert.assertEquals(1, events.size());

        Event event = events.get(0);
        Assert.assertNotNull(event);
        Assert.assertEquals("photo_new", event.getType());
        Assert.assertEquals(Integer.valueOf(444), event.getGroupId());
        Assert.assertEquals("aaa", event.getEventId());

        EventObject eventObject = event.getObject();
        Assert.assertNotNull(eventObject);

        Assert.assertTrue(eventObject instanceof Photo);
        Photo photo = (Photo) eventObject;
        Assert.assertNotNull(photo);
        Assert.assertEquals(Integer.valueOf(111), photo.getAlbumId());
        Assert.assertEquals(Integer.valueOf(1594284077), photo.getDate());
        Assert.assertEquals(Integer.valueOf(222), photo.getId());
        Assert.assertEquals(Integer.valueOf(-333), photo.getOwnerId());
        Assert.assertFalse(photo.hasText());
        Assert.assertEquals(Integer.valueOf(555), photo.getUserId());

        List<PhotoSize> photoSizes = photo.getPhotoSizes();
        Assert.assertNotNull(photo);
        Assert.assertFalse(photoSizes.isEmpty());
    }
}
