package api.longpoll.bots.model.events;

import com.google.gson.annotations.SerializedName;

/**
 * An event that occurs on VK server.
 */
public class Event {
	/**
	 * Event type.
	 *
	 * @see <a href="https://vk.com/dev/groups_events">list of event types</a>
	 */
	@SerializedName("type")
	private String type;

	/**
	 * Object that has triggered the event.
	 */
	@SerializedName("object")
	private EventObject object;

	/**
	 * Group ID, where the event occurred.
	 */
	@SerializedName("group_id")
	private Integer groupId;

	/**
	 * Unique event ID.
	 */
	@SerializedName("event_id")
	private String eventId;

	/**
	 * Gets event type.
	 *
	 * @return event type.
	 */
	public String getType() {
		return type;
	}

	/**
	 * Sets event type.
	 *
	 * @param type event type.
	 * @return this Event.
	 */
	public Event setType(String type) {
		this.type = type;
		return this;
	}

	/**
	 * Gets group ID.
	 *
	 * @return group ID.
	 */
	public Integer getGroupId() {
		return groupId;
	}

	/**
	 * Sets group ID.
	 *
	 * @param groupId group ID.
	 * @return this Event.
	 */
	public Event setGroupId(Integer groupId) {
		this.groupId = groupId;
		return this;
	}

	/**
	 * Gets event ID.
	 *
	 * @return event ID.
	 */
	public String getEventId() {
		return eventId;
	}

	/**
	 * Sets event ID.
	 *
	 * @param eventId event ID.
	 * @return this Event.
	 */
	public Event setEventId(String eventId) {
		this.eventId = eventId;
		return this;
	}

	/**
	 * Gets event object.
	 *
	 * @return event object.
	 */
	public EventObject getObject() {
		return object;
	}

	/**
	 * Sets event object.
	 *
	 * @param object event object.
	 * @return this Event.
	 */
	public Event setObject(EventObject object) {
		this.object = object;
		return this;
	}
}
