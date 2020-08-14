package api.longpoll.bots.methods.events;

import api.longpoll.bots.LongPollBot;
import api.longpoll.bots.converters.JsonToPojoConverter;
import api.longpoll.bots.converters.response.events.GetEventsResultConverterImpl;
import api.longpoll.bots.model.response.events.GetEventsResult;
import api.longpoll.bots.methods.GetMethod;
import org.jsoup.Connection;

import java.util.stream.Stream;

public class GetEvents extends GetMethod<GetEventsResult> {
	private String server;
	private String key;
	private Integer ts;

	public GetEvents(LongPollBot bot) {
		super(bot);
	}

	@Override
	protected JsonToPojoConverter<GetEventsResult> getConverter() {
		return new GetEventsResultConverterImpl();
	}

	@Override
	protected Stream<Connection.KeyVal> getKeyValStream() {
		return Stream.of(
				keyVal("act", "a_check"),
				keyVal("wait", "25"),
				keyVal("key", key),
				keyVal("ts", ts)
		);
	}

	@Override
	protected String getApi() {
		return server;
	}

	public String getServer() {
		return server;
	}

	public GetEvents setServer(String server) {
		this.server = server;
		return this;
	}

	public String getKey() {
		return key;
	}

	public GetEvents setKey(String key) {
		this.key = key;
		return this;
	}

	public Integer getTs() {
		return ts;
	}

	public GetEvents setTs(Integer ts) {
		this.ts = ts;
		return this;
	}
}
