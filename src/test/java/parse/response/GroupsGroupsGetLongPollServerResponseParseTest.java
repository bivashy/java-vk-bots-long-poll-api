package parse.response;

import api.longpoll.bots.model.response.groups.GroupsGetLongPollServerResult;
import com.google.gson.Gson;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class GroupsGroupsGetLongPollServerResponseParseTest {
    Gson gson = new Gson();

    @Test
    void getLongPollServerResponseSuccessParse() {
        GroupsGetLongPollServerResult result = gson.fromJson(ParseUtil.readJson("json/response/get_long_poll_server_response_sample_5_110.json"), GroupsGetLongPollServerResult.class);
        assertNotNull(result);

        GroupsGetLongPollServerResult.Response response = result.getResponse();
        assertNotNull(response);
        assertEquals("aaa", response.getKey());
        assertEquals("bbb", response.getServer());
        assertEquals(2587, response.getTs());
    }
}
