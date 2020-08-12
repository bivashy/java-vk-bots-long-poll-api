package api.longpoll.bots.methods.updates;

import api.longpoll.bots.LongPollBot;
import api.longpoll.bots.converters.JsonToPojoConverter;
import api.longpoll.bots.converters.updates.UpdateResponseConverterImpl;
import api.longpoll.bots.model.response.events.GetEventsResult;
import api.longpoll.bots.methods.GetExecutor;

public class GetUpdates extends GetExecutor<GetEventsResult> {
	private static final String ACT_FIELD = "act";
	private static final String ACT = "a_check";
	private static final String WAIT_FIELD = "wait";
	private static final String WAIT = "25";

	private static final String KEY_FIELD = "key";
	private static final String TS_FIELD = "ts";

	private String server;

	public GetUpdates(LongPollBot bot) {
		super(bot);
		params.put(ACT_FIELD, ACT);
		params.put(WAIT_FIELD, WAIT);
	}

	public String getServer() {
		return server;
	}

	public GetUpdates setServer(String server) {
		this.server = server;
		return this;
	}

	public String getKey() {
		return (String) params.get(KEY_FIELD);
	}

	public GetUpdates setKey(String key) {
		params.put(KEY_FIELD, key);
		return this;
	}

	public int getTs() {
		return (int) params.get(TS_FIELD);
	}

	public GetUpdates setTs(int ts) {
		params.put(TS_FIELD, String.valueOf(ts));
		return this;
	}

	@Override
	protected JsonToPojoConverter<GetEventsResult> getConverter() {
		return new UpdateResponseConverterImpl();
	}

	@Override
	protected String getApi() {
		return server;
	}
}
