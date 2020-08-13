package api.longpoll.bots.methods.events;

import api.longpoll.bots.LongPollBot;
import api.longpoll.bots.converters.JsonToPojoConverter;
import api.longpoll.bots.converters.updates.UpdateResponseConverterImpl;
import api.longpoll.bots.model.response.events.GetEventsResult;
import api.longpoll.bots.methods.GetMethod;

public class GetEvents extends GetMethod<GetEventsResult> {
	private static final String ACT_FIELD = "act";
	private static final String ACT = "a_check";
	private static final String WAIT_FIELD = "wait";
	private static final String WAIT = "25";

	private static final String KEY_FIELD = "key";
	private static final String TS_FIELD = "ts";

	private String server;

	public GetEvents(LongPollBot bot) {
		super(bot);
		params.put(ACT_FIELD, ACT);
		params.put(WAIT_FIELD, WAIT);
	}

	public GetEvents setServer(String server) {
		this.server = server;
		return this;
	}

	public GetEvents setKey(String key) {
		params.put(KEY_FIELD, key);
		return this;
	}

	public GetEvents setTs(int ts) {
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
