package parse.response;

import api.longpoll.bots.converters.GenericConverterFactory;
import api.longpoll.bots.converters.StringToJsonConverterImpl;
import api.longpoll.bots.model.response.groups.GroupsGetLongPollServerResult;
import com.google.gson.JsonObject;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.io.IOException;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class GroupsGroupsGetLongPollServerResultParseTest extends AbstractParseTest {
	@Test
	public void test1_getLongPollServerResponseSuccessParse() throws IOException {
		JsonObject jsonObject = new StringToJsonConverterImpl().convert(readJson("json/response/get_long_poll_server_response_sample_5_110.json").toString());
		GroupsGetLongPollServerResult groupsGetLongPollServerResult = GenericConverterFactory.get(GroupsGetLongPollServerResult.class)
				.convert(jsonObject);
		Assert.assertNotNull(groupsGetLongPollServerResult);

		GroupsGetLongPollServerResult.Response response = groupsGetLongPollServerResult.getResponse();
		Assert.assertNotNull(response);
		Assert.assertEquals("f843a2ef2cd226b90c6f0991c38be854836b8c611", response.getKey());
		Assert.assertEquals("https://lp.vk.com/wh1689756588", response.getServer());
		Assert.assertEquals(Integer.valueOf(2587), response.getTs());
	}


}
