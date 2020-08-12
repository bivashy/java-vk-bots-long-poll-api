package parse.response;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.helper.HttpConnection;
import org.junit.Test;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class JsoupTest {
	@Test
	public void test1() throws IOException {
		Map<String, Object> params = new HashMap<String, Object>() {{
			put("group_id", 168975658);
			put("access_token", "004a7677ca1492027fa6e974b9be3f8f650f691f8e5e587c4cf39e7b0cb678f0ff4ca47b58fe4c9b8b59c");
			put("v", "5.110");
		}};

		Collection<Connection.KeyVal> data = params.entrySet()
				.stream()
				.map(e -> HttpConnection.KeyVal.create(e.getKey(), String.valueOf(e.getValue())))
				.collect(Collectors.toList());
		Connection connection = Jsoup.connect("https://api.vk.com/method/groups.getLongPollServer")
				.ignoreContentType(true)
				.data(data).method(Connection.Method.GET);
		Connection.Response response = connection
				.execute();
		String body = response
				.body();

//		System.out.println(body);
//		System.out.println(response.contentType());
//		System.out.println(response.statusCode());
	}
}
