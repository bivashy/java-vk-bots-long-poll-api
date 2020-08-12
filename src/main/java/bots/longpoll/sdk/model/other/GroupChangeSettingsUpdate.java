package bots.longpoll.sdk.model.other;

import bots.longpoll.sdk.model.update.UpdateObject;
import com.google.gson.annotations.SerializedName;

import java.util.Map;

public class GroupChangeSettingsUpdate extends UpdateObject {
	@SerializedName("user_id")
	private Integer userId;
	@SerializedName("changes")
	private Map<String, Change> changes;

	public Integer getUserId() {
		return userId;
	}

	public GroupChangeSettingsUpdate setUserId(Integer userId) {
		this.userId = userId;
		return this;
	}

	public Map<String, Change> getChanges() {
		return changes;
	}

	public GroupChangeSettingsUpdate setChanges(Map<String, Change> changes) {
		this.changes = changes;
		return this;
	}
}
