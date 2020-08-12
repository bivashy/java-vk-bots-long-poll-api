package api.longpoll.bots.model.groups;

import com.google.gson.annotations.SerializedName;

public class GroupsGetLongPollServerResponse {
	@SerializedName("key")
	private String key;
	@SerializedName("server")
	private String server;
	@SerializedName("ts")
	private Integer ts;

	public String getKey() {
		return key;
	}

	public GroupsGetLongPollServerResponse setKey(String key) {
		this.key = key;
		return this;
	}

	public String getServer() {
		return server;
	}

	public GroupsGetLongPollServerResponse setServer(String server) {
		this.server = server;
		return this;
	}

	public Integer getTs() {
		return ts;
	}

	public GroupsGetLongPollServerResponse setTs(Integer ts) {
		this.ts = ts;
		return this;
	}
}
