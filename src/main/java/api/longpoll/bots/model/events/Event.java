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
    private EventType type;

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

    public EventType getType() {
        return type;
    }

    public void setType(EventType type) {
        this.type = type;
    }

    public EventObject getObject() {
        return object;
    }

    public void setObject(EventObject object) {
        this.object = object;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }
}
