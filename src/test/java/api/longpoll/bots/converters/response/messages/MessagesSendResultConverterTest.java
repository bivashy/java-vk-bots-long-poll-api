package api.longpoll.bots.converters.response.messages;

import api.longpoll.bots.model.response.messages.MessagesSendResult;
import com.google.gson.Gson;
import org.junit.jupiter.api.Test;
import parse.response.ParseUtil;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MessagesSendResultConverterTest {
    Gson gson = new Gson();

    @Test
    void responses() {
        MessagesSendResult result = gson.fromJson(ParseUtil.readJson("json/response/messages_send/message_send_responses_sample_5_110.json"), MessagesSendResult.class);
        assertNotNull(result);

        Object response = result.getResponse();
        assertNotNull(response);
        assertTrue(response instanceof List);

        List<?> list = (List<?>) response;
        assertFalse(list.isEmpty());

        Object o = list.get(0);
        assertNotNull(o);
        assertTrue(o instanceof MessagesSendResult.Response);

        MessagesSendResult.Response messagesSendResponse = (MessagesSendResult.Response) o;
        assertEquals(111, messagesSendResponse.getPeerId());
        assertEquals(287, messagesSendResponse.getMessageId());
    }
}