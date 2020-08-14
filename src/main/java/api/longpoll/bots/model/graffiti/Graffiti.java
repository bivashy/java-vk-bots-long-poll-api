package api.longpoll.bots.model.graffiti;

import api.longpoll.bots.model.objects.media.Attachable;
import com.google.gson.annotations.SerializedName;

public class Graffiti implements Attachable {
	@SerializedName("id")
	private Integer id;
	@SerializedName("owner_id")
	private Integer ownerId;
	@SerializedName("url")
	private String url;
	@SerializedName("width")
	private Integer width;
	@SerializedName("height")
	private Integer height;
	@SerializedName("access_key")
	private String accessKey;

	public Integer getId() {
		return id;
	}

	public Graffiti setId(Integer id) {
		this.id = id;
		return this;
	}

	public Integer getOwnerId() {
		return ownerId;
	}

	public Graffiti setOwnerId(Integer ownerId) {
		this.ownerId = ownerId;
		return this;
	}

	public String getUrl() {
		return url;
	}

	public Graffiti setUrl(String url) {
		this.url = url;
		return this;
	}

	public Integer getWidth() {
		return width;
	}

	public Graffiti setWidth(Integer width) {
		this.width = width;
		return this;
	}

	public Integer getHeight() {
		return height;
	}

	public Graffiti setHeight(Integer height) {
		this.height = height;
		return this;
	}

	public String getAccessKey() {
		return accessKey;
	}

	public Graffiti setAccessKey(String accessKey) {
		this.accessKey = accessKey;
		return this;
	}
}
