package api.longpoll.bots.model.other;

import api.longpoll.bots.model.events.EventObject;
import com.google.gson.annotations.SerializedName;

import java.util.Map;

public class GroupChangeSettingsEvent implements EventObject {
	@SerializedName("user_id")
	private Integer userId;
	@SerializedName("changes")
	private Map<String, Change> changes;

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
