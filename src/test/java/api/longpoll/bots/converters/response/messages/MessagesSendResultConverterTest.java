package api.longpoll.bots.converters.response.messages;

import api.longpoll.bots.methods.impl.messages.Send;
import com.google.gson.Gson;
import org.junit.jupiter.api.Test;
import parse.response.ParseUtil;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MessagesSendResultConverterTest {
    final Gson gson = new Gson();

    @Test
    void responses() {
        Send.ResponseBody result = gson.fromJson(ParseUtil.readJson("json/response/messages_send/message_send_responses_sample_5_110.json"), Send.ResponseBody.class);
        assertNotNull(result);

        Object response = result.getResponse();
        assertNotNull(response);
        assertTrue(response instanceof List);

        List<?> list = (List<?>) response;
        assertFalse(list.isEmpty());

        Object o = list.get(0);
        assertNotNull(o);
        assertTrue(o instanceof Send.ResponseBody.Response);

        Send.ResponseBody.Response messagesSendResponse = (Send.ResponseBody.Response) o;
        assertEquals(111, messagesSendResponse.getPeerId());
        assertEquals(287, messagesSendResponse.getMessageId());
    }
}