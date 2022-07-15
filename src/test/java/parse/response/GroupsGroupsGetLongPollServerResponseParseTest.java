package parse.response;

import api.longpoll.bots.methods.impl.groups.GetLongPollServer;
import com.google.gson.Gson;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class GroupsGroupsGetLongPollServerResponseParseTest {
    final Gson gson = new Gson();

    @Test
    void getLongPollServerResponseSuccessParse() {
        GetLongPollServer.ResponseBody vkResponse = gson.fromJson(ParseUtil.readJson("json/response/get_long_poll_server_response_sample_5_110.json"), GetLongPollServer.ResponseBody.class);
        assertNotNull(vkResponse);

        GetLongPollServer.ResponseBody.Response response = vkResponse.getResponse();
        assertNotNull(response);
        assertEquals("aaa", response.getKey());
        assertEquals("bbb", response.getServer());
        assertEquals(2587, response.getTs());
    }
}
