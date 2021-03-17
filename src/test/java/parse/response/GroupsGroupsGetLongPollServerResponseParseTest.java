package parse.response;

import api.longpoll.bots.converters.JsonToPojoConverter;
import api.longpoll.bots.converters.JsonToPojoConverterFactory;
import api.longpoll.bots.model.response.GenericResult;
import api.longpoll.bots.model.response.groups.GroupsGetLongPollServerResponse;
import com.google.gson.reflect.TypeToken;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class GroupsGroupsGetLongPollServerResponseParseTest {
    @Test
    void getLongPollServerResponseSuccessParse() {
        JsonToPojoConverter<GenericResult<GroupsGetLongPollServerResponse>> jsonToPojoConverter = JsonToPojoConverterFactory.get(new TypeToken<GenericResult<GroupsGetLongPollServerResponse>>(){}.getType());
        GenericResult<GroupsGetLongPollServerResponse> groupsGetLongPollServerResponse = jsonToPojoConverter.convert(ParseTestUtil.readJson("json/response/get_long_poll_server_response_sample_5_110.json"));
        assertNotNull(groupsGetLongPollServerResponse);

        GroupsGetLongPollServerResponse response = groupsGetLongPollServerResponse.getResponse();
        assertNotNull(response);
        assertEquals("aaa", response.getKey());
        assertEquals("bbb", response.getServer());
        assertEquals(2587, response.getTs());
    }
}
