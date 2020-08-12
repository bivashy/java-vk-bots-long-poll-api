package bots.longpoll.sdk.model.update;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class UpdateResponse {
	@SerializedName("ts")
	private Integer ts;
	@SerializedName("updates")
	private List<Update> updates;

	public Integer getTs() {
		return ts;
	}

	public UpdateResponse setTs(Integer ts) {
		this.ts = ts;
		return this;
	}

	public List<Update> getUpdates() {
		return updates;
	}

	public UpdateResponse setUpdates(List<Update> updates) {
		this.updates = updates;
		return this;
	}
}
