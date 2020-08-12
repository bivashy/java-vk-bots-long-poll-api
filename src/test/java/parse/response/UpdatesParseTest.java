package parse.response;

import bots.longpoll.sdk.converters.updates.UpdateResponseConverterImpl;
import bots.longpoll.sdk.model.update.Update;
import bots.longpoll.sdk.model.update.UpdateResponse;
import com.google.gson.JsonObject;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.io.IOException;
import java.util.List;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UpdatesParseTest extends AbstractParseTest {
	@Test
	public void test1_emptyUpdatesParse() throws IOException {
		JsonObject jsonObject = readJson("json/response/empty_updates_sample_5_110.json");
		UpdateResponse updateResponse = new UpdateResponseConverterImpl().convert(jsonObject);
		Assert.assertNotNull(updateResponse);
		Assert.assertEquals(Integer.valueOf(2587), updateResponse.getTs());

		List<Update> updates = updateResponse.getUpdates();
		Assert.assertNotNull(updates);
		Assert.assertTrue(updates.isEmpty());
	}

	@Test
	public void test2_updatesFailed1() throws IOException {
		JsonObject jsonObject = readJson("json/response/get_updates_failed_1_5_110.json");
		UpdateResponse updateResponse = new UpdateResponseConverterImpl().convert(jsonObject);
		Assert.assertNotNull(updateResponse);
		Assert.assertEquals(Integer.valueOf(2593), updateResponse.getTs());
	}
}
