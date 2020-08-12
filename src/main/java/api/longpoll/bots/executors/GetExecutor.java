package api.longpoll.bots.executors;

import api.longpoll.bots.LongPollBot;
import org.jsoup.Connection;

import java.util.List;

public abstract class GetExecutor<Response> extends Executor<Response> {
	private static final String ACCESS_TOKEN = "access_token";
	private static final String VERSION = "v";

	protected LongPollBot bot;

	public GetExecutor(LongPollBot bot) {
		this.bot = bot;
	}

	@Override
	protected List<Connection.KeyVal> getData() {
		List<Connection.KeyVal> requestParams = super.getData();

		requestParams.add(keyVal(ACCESS_TOKEN, bot.getAccessToken()));
		requestParams.add(keyVal(VERSION, bot.getApiVersion()));

		return requestParams;
	}

	@Override
	protected Connection.Method getMethod() {
		return Connection.Method.GET;
	}
}
