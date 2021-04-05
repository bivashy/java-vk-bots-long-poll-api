package api.longpoll.bots.model.events.other;

import api.longpoll.bots.model.events.EventObject;
import com.google.gson.annotations.SerializedName;

import java.util.Map;

/**
 * Describes <b>group_change_settings</b> event objects.
 */
public class GroupChangeSettingsEvent implements EventObject {
    /**
     * ID of the user who made changes.
     */
    @SerializedName("user_id")
    private Integer userId;

    /**
     * Changes description. Possible keys:
     * <ul>
     *     <li><i>title</i> — title;</li>
     *     <li><i>description</i> — description;</li>
     *     <li><i>access</i> — community type;</li>
     *     <li><i>screen_name</i> — screen name;</li>
     *     <li><i>public_category</i> — public category;</li>
     *     <li><i>public_subcategory</i> — public subcategory;</li>
     *     <li><i>age_limits</i> — age limits;</li>
     *     <li><i>website</i> — website;</li>
     *     <li><i>enable_{SECTION}</i> — {SECTION} can take values: <i>status_default</i>, <i>audio</i>, <i>photo</i>, <i>video</i>video, <i>market</i>.</li>
     * </ul>
     */
    @SerializedName("changes")
    private Map<String, Change> changes;

    /**
     * Describes changes.
     */
    public static class Change {
        /**
         * Old value.
         */
        @SerializedName("old_value")
        private String oldValue;

        /**
         * New value.
         */
        @SerializedName("new_value")
        private String newValue;

        public String getOldValue() {
            return oldValue;
        }

        public void setOldValue(String oldValue) {
            this.oldValue = oldValue;
        }

        public String getNewValue() {
            return newValue;
        }

        public void setNewValue(String newValue) {
            this.newValue = newValue;
        }

        @Override
        public String toString() {
            return "Change{" +
                    "oldValue='" + oldValue + '\'' +
                    ", newValue='" + newValue + '\'' +
                    '}';
        }
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Map<String, Change> getChanges() {
        return changes;
    }

    public void setChanges(Map<String, Change> changes) {
        this.changes = changes;
    }

    @Override
    public String toString() {
        return "GroupChangeSettingsEvent{" +
                "userId=" + userId +
                ", changes=" + changes +
                '}';
    }
}
