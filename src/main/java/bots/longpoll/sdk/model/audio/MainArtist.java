package bots.longpoll.sdk.model.audio;

import com.google.gson.annotations.SerializedName;

public class MainArtist {
	@SerializedName("name")
	private String name;
	@SerializedName("domain")
	private String domain;
	@SerializedName("id")
	private String id;

	public String getName() {
		return name;
	}

	public MainArtist setName(String name) {
		this.name = name;
		return this;
	}

	public String getDomain() {
		return domain;
	}

	public MainArtist setDomain(String domain) {
		this.domain = domain;
		return this;
	}

	public String getId() {
		return id;
	}

	public MainArtist setId(String id) {
		this.id = id;
		return this;
	}
}
