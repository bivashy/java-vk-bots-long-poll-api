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
	public class Change {
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

		public Change setOldValue(String oldValue) {
			this.oldValue = oldValue;
			return this;
		}

		public String getNewValue() {
			return newValue;
		}

		public Change setNewValue(String newValue) {
			this.newValue = newValue;
			return this;
		}
	}

	public Integer getUserId() {
		return userId;
	}

	public GroupChangeSettingsEvent setUserId(Integer userId) {
		this.userId = userId;
		return this;
	}

	public Map<String, Change> getChanges() {
		return changes;
	}

	public GroupChangeSettingsEvent setChanges(Map<String, Change> changes) {
		this.changes = changes;
		return this;
	}
}
