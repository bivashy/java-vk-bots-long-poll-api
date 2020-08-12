package api.longpoll.bots.model.response.events;

import api.longpoll.bots.model.events.Event;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Contains list of events that occur on VK server.
 */
public class GetEventsResult {
	/**
	 * The number of the last event.
	 */
	@SerializedName("ts")
	private Integer ts;

	/**
	 * List of events.
	 */
	@SerializedName("events")
	private List<Event> events;

	/**
	 * Gets the number of the last event.
	 *
	 * @return the number of the last event.
	 */
	public Integer getTs() {
		return ts;
	}

	/**
	 * Sets the number of the last event.
	 *
	 * @param ts the number of the last event.
	 * @return this GetEventsResult.
	 */
	public GetEventsResult setTs(Integer ts) {
		this.ts = ts;
		return this;
	}

	/**
	 * Get list of events.
	 *
	 * @return list of events.
	 */
	public List<Event> getEvents() {
		return events;
	}

	/**
	 * Sets list of events.
	 *
	 * @param events list of events.
	 * @return this GetEventsResult.
	 */
	public GetEventsResult setEvents(List<Event> events) {
		this.events = events;
		return this;
	}
}
