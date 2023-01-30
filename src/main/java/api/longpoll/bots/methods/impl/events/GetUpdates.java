package api.longpoll.bots.methods.impl.events;

import api.longpoll.bots.methods.impl.VkMethod;
import api.longpoll.bots.model.events.Update;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Gets update events from VK server.
 */
public class GetUpdates extends VkMethod<GetUpdates.ResponseBody> {
    /**
     * Server URL.
     */
    private String server;

    public GetUpdates() {
        super();
        addParam("act", "a_check");
        addParam("wait", "25");
    }

    @Override
    protected Class<ResponseBody> getResponseClass() {
        return ResponseBody.class;
    }

    @Override
    public String getUri() {
        return server;
    }

    public GetUpdates setServer(String server) {
        this.server = server;
        return this;
    }

    public GetUpdates setKey(String key) {
        return addParam("key", key);
    }

    public GetUpdates setTs(int ts) {
        return addParam("ts", ts);
    }

    @Override
    public GetUpdates addParam(String key, Object value) {
        return (GetUpdates) super.addParam(key, value);
    }

    /**
     * Contains list of events that occur on VK server.
     */
    public static class ResponseBody {
        /**
         * The number of the last event.
         */
        @SerializedName("ts")
        private Integer ts;

        /**
         * List of events.
         */
        @SerializedName("updates")
        private List<Update> events;

        public Integer getTs() {
            return ts;
        }

        public void setTs(Integer ts) {
            this.ts = ts;
        }

        public List<Update> getEvents() {
            return events;
        }

        public void setEvents(List<Update> events) {
            this.events = events;
        }


        @Override
        public String toString() {
            return "Response{" +
                    "ts=" + ts +
                    ", events=" + events +
                    '}';
        }
    }
}
