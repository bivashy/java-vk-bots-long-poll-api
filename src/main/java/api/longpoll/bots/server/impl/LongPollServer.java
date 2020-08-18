package api.longpoll.bots.server.impl;

import api.longpoll.bots.LongPollBot;
import api.longpoll.bots.converters.Converter;
import api.longpoll.bots.converters.StringToJsonConverterImpl;
import api.longpoll.bots.server.Server;
import api.longpoll.bots.exceptions.ApiException;
import api.longpoll.bots.exceptions.ApiHttpException;
import api.longpoll.bots.methods.groups.GroupsGetLongPollServer;
import api.longpoll.bots.methods.events.GetEvents;
import api.longpoll.bots.model.response.groups.GroupsGetLongPollServerResult;
import api.longpoll.bots.model.events.Event;
import api.longpoll.bots.model.response.events.GetEventsResult;
import com.google.gson.JsonObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class LongPollServer implements Server {
	private static final Logger log = LoggerFactory.getLogger(LongPollServer.class);
	private static final int ATTEMPTS_AMOUNT = 10;
	private static final String TS_FIELD = "ts";
	private static final String FAILED_FIELD = "failed";

	private LongPollBot bot;
	private GetEvents getEvents;
	private Converter<String, JsonObject> converter = new StringToJsonConverterImpl();

	public LongPollServer(LongPollBot bot) {
		this.bot = bot;
	}

	@Override
	public List<Event> getUpdates() throws ApiHttpException {
		if (getEvents == null) {
			init();
		}

		for (int attempt = 0; attempt < ATTEMPTS_AMOUNT; ++attempt) {
			log.debug("Getting events from VK Long Poll Server. Attempt: {}.", attempt + 1);
			try {
				GetEventsResult getEventsResult = getEvents.execute();

				updateTs(getEventsResult.getTs());
				return getEventsResult.getEvents();
			} catch (ApiException e) {
				log.warn("Failed to get events from VK Long Poll Server.", e);
				JsonObject jsonObject = converter.convert(e.getMessage());

				if (!jsonObject.has(FAILED_FIELD)) {
					throw e;
				}

				int code = jsonObject.get(FAILED_FIELD).getAsInt();
				switch (code) {
					case 1:
						updateTs(jsonObject.get(TS_FIELD).getAsInt());
						break;
					case 2:
					case 3:
						init();
						break;
				}
			}
		}

		throw new ApiHttpException("Failed to get events from Long Poll server. Number of attempts: " + ATTEMPTS_AMOUNT + ".");
	}

	private void init() throws ApiHttpException {
		GroupsGetLongPollServerResult.Response response = new GroupsGetLongPollServer(bot)
				.setGroupId(bot.getGroupId())
				.execute()
				.getResponse();

		getEvents = new GetEvents()
				.setServer(response.getServer())
				.setKey(response.getKey())
				.setTs(response.getTs());
	}

	private void updateTs(int ts) {
		getEvents.setTs(ts);
	}
}
