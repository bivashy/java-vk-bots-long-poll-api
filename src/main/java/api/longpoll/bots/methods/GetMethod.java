package api.longpoll.bots.methods;

import api.longpoll.bots.LongPollBot;
import org.jsoup.Connection;

import java.util.List;

public abstract class GetMethod<Response> extends DefaultGetMethod<Response> {
	private static final String ACCESS_TOKEN = "access_token";
	private static final String VERSION = "v";
	private static final String VERSION_NUMBER = "5.110";

	protected LongPollBot bot;

	public GetMethod(LongPollBot bot) {
		this.bot = bot;
	}

	@Override
	protected List<Connection.KeyVal> getData() {
		List<Connection.KeyVal> requestParams = super.getData();

		requestParams.add(keyVal(ACCESS_TOKEN, bot.getAccessToken()));
		requestParams.add(keyVal(VERSION, VERSION_NUMBER));

		return requestParams;
	}
}
