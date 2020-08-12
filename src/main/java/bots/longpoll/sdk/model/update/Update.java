package bots.longpoll.sdk.model.update;

import com.google.gson.annotations.SerializedName;

public class Update {
	@SerializedName("type")
	private String type;
	@SerializedName("object")
	private UpdateObject object;
	@SerializedName("group_id")
	private Integer groupId;
	@SerializedName("event_id")
	private String eventId;

	public String getType() {
		return type;
	}

	public Update setType(String type) {
		this.type = type;
		return this;
	}

	public Integer getGroupId() {
		return groupId;
	}

	public Update setGroupId(Integer groupId) {
		this.groupId = groupId;
		return this;
	}

	public String getEventId() {
		return eventId;
	}

	public Update setEventId(String eventId) {
		this.eventId = eventId;
		return this;
	}

	public UpdateObject getObject() {
		return object;
	}

	public Update setObject(UpdateObject object) {
		this.object = object;
		return this;
	}
}
