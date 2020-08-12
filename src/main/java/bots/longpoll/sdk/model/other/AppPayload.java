package bots.longpoll.sdk.model.other;

import bots.longpoll.sdk.model.update.UpdateObject;
import com.google.gson.annotations.SerializedName;

public class AppPayload extends UpdateObject {
	@SerializedName("user_id")
	private Integer userId;
	@SerializedName("app_id")
	private Integer appId;
	@SerializedName("payload")
	private String payload;
	@SerializedName("group_id")
	private Integer groupId;

	public Integer getUserId() {
		return userId;
	}

	public AppPayload setUserId(Integer userId) {
		this.userId = userId;
		return this;
	}

	public Integer getAppId() {
		return appId;
	}

	public AppPayload setAppId(Integer appId) {
		this.appId = appId;
		return this;
	}

	public String getPayload() {
		return payload;
	}

	public AppPayload setPayload(String payload) {
		this.payload = payload;
		return this;
	}

	public Integer getGroupId() {
		return groupId;
	}

	public AppPayload setGroupId(Integer groupId) {
		this.groupId = groupId;
		return this;
	}
}
