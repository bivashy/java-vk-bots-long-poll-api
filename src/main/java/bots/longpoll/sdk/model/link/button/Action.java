package bots.longpoll.sdk.model.link.button;

import com.google.gson.annotations.SerializedName;

public class Action {
	@SerializedName("type")
	private String type;
	@SerializedName("url")
	private String url;

	public String getType() {
		return type;
	}

	public Action setType(String type) {
		this.type = type;
		return this;
	}

	public String getUrl() {
		return url;
	}

	public Action setUrl(String url) {
		this.url = url;
		return this;
	}
}
