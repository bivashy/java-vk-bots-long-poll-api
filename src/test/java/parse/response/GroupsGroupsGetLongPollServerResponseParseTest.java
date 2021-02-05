package parse.response;

import api.longpoll.bots.converters.CachedConverterFactory;
import api.longpoll.bots.converters.JsonToPojoConverter;
import api.longpoll.bots.converters.StringToJsonConverter;
import api.longpoll.bots.model.response.GenericResult;
import api.longpoll.bots.model.response.groups.GroupsGetLongPollServerResponse;
import com.google.gson.JsonObject;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.io.IOException;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class GroupsGroupsGetLongPollServerResponseParseTest extends AbstractParseTest {
    @Test
    public void test1_getLongPollServerResponseSuccessParse() throws IOException {
        JsonObject jsonObject = new StringToJsonConverter().convert(readJson("json/response/get_long_poll_server_response_sample_5_110.json").toString());
        JsonToPojoConverter<GenericResult<GroupsGetLongPollServerResponse>> jsonToPojoConverter = CachedConverterFactory.getConverter(GenericResult.class, GroupsGetLongPollServerResponse.class);
        GenericResult<GroupsGetLongPollServerResponse> groupsGetLongPollServerResponse = jsonToPojoConverter.convert(jsonObject);
        Assert.assertNotNull(groupsGetLongPollServerResponse);

        GroupsGetLongPollServerResponse response = groupsGetLongPollServerResponse.getResponse();
        Assert.assertNotNull(response);
        Assert.assertEquals("aaa", response.getKey());
        Assert.assertEquals("bbb", response.getServer());
        Assert.assertEquals(Integer.valueOf(2587), response.getTs());
    }


}
