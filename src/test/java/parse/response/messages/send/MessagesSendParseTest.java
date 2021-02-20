package parse.response.messages.send;

import api.longpoll.bots.converters.JsonToPojoConverter;
import api.longpoll.bots.converters.response.messages.MessagesSendResultConverter;
import api.longpoll.bots.model.response.GenericResult;
import api.longpoll.bots.model.response.messages.MessagesSendResponse;
import org.junit.jupiter.api.Test;
import parse.response.ParseTestUtil;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MessagesSendParseTest {
    @Test
    void responses() {
        JsonToPojoConverter<GenericResult<Object>> converter = new MessagesSendResultConverter();
        GenericResult<Object> result = converter.convert(ParseTestUtil.readJson("json/response/messages_send/message_send_responses_sample_5_110.json"));
        assertNotNull(result);

        Object response = result.getResponse();
        assertNotNull(response);
        assertTrue(response instanceof List);

        List list = (List) response;
        assertFalse(list.isEmpty());

        Object o = list.get(0);
        assertNotNull(o);
        assertTrue(o instanceof MessagesSendResponse);

        MessagesSendResponse messagesSendResponse = (MessagesSendResponse) o;
        assertEquals(111, messagesSendResponse.getPeerId());
        assertEquals(287, messagesSendResponse.getMessageId());
    }
}
