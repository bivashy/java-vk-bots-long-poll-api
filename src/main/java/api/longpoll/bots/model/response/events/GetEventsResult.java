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
    @SerializedName("updates")
    private List<Event> events;

    public Integer getTs() {
        return ts;
    }

    public void setTs(Integer ts) {
        this.ts = ts;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }
}
