package parse.response;

import api.longpoll.bots.methods.impl.groups.GetLongPollServer;
import com.google.gson.Gson;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class GroupsGroupsGetLongPollServerResponseParseTest {
    Gson gson = new Gson();

    @Test
    void getLongPollServerResponseSuccessParse() {
        GetLongPollServer.Response response = gson.fromJson(ParseUtil.readJson("json/response/get_long_poll_server_response_sample_5_110.json"), GetLongPollServer.Response.class);
        assertNotNull(response);

        GetLongPollServer.Response.ResponseObject responseObject = response.getResponseObject();
        assertNotNull(responseObject);
        assertEquals("aaa", responseObject.getKey());
        assertEquals("bbb", responseObject.getServer());
        assertEquals(2587, responseObject.getTs());
    }
}
