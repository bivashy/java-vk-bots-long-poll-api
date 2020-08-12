package parse.response;

import api.longpoll.bots.converters.GenericConverterFactory;
import api.longpoll.bots.converters.StringToJsonConverterImpl;
import api.longpoll.bots.model.groups.GroupsGetLongPollServerResponse;
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
		JsonObject jsonObject = new StringToJsonConverterImpl().convert(readJson("json/response/get_long_poll_server_response_sample_5_110.json").toString());
		GroupsGetLongPollServerResponse groupsGetLongPollServerResponse = GenericConverterFactory.get(GroupsGetLongPollServerResponse.class)
				.convert(jsonObject);
		Assert.assertNotNull(groupsGetLongPollServerResponse);

		Assert.assertEquals("f843a2ef2cd226b90c6f0991c38be854836b8c611", groupsGetLongPollServerResponse.getKey());
		Assert.assertEquals("https://lp.vk.com/wh1689756588", groupsGetLongPollServerResponse.getServer());
		Assert.assertEquals(Integer.valueOf(2587), groupsGetLongPollServerResponse.getTs());
	}


}
