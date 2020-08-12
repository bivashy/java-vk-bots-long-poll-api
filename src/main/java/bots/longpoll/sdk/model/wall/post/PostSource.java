package bots.longpoll.sdk.model.wall.post;

import com.google.gson.annotations.SerializedName;

public class PostSource {
	@SerializedName("type")
	private String type;
	@SerializedName("platform")
	private String platform;
	@SerializedName("data")
	private String data;
	@SerializedName("url")
	private String url;

	public String getType() {
		return type;
	}

	public PostSource setType(String type) {
		this.type = type;
		return this;
	}

	public String getPlatform() {
		return platform;
	}

	public PostSource setPlatform(String platform) {
		this.platform = platform;
		return this;
	}

	public String getData() {
		return data;
	}

	public PostSource setData(String data) {
		this.data = data;
		return this;
	}

	public String getUrl() {
		return url;
	}

	public PostSource setUrl(String url) {
		this.url = url;
		return this;
	}
}
