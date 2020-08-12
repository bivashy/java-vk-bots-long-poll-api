package bots.longpoll.sdk.model.document;

import bots.longpoll.sdk.model.attachment.MediaObject;
import bots.longpoll.sdk.model.document.preview.Preview;
import com.google.gson.annotations.SerializedName;

public class Document extends MediaObject {
	@SerializedName("id")
	private Integer id;
	@SerializedName("owner_id")
	private Integer ownerId;
	@SerializedName("title")
	private String title;
	@SerializedName("size")
	private Integer size;
	@SerializedName("ext")
	private String ext;
	@SerializedName("url")
	private String url;
	@SerializedName("date")
	private Integer date;
	@SerializedName("type")
	private Integer type;
	@SerializedName("preview")
	private Preview preview;
	@SerializedName("access_key")
	private String accessKey;

	public Integer getId() {
		return id;
	}

	public Document setId(Integer id) {
		this.id = id;
		return this;
	}

	public Integer getOwnerId() {
		return ownerId;
	}

	public Document setOwnerId(Integer ownerId) {
		this.ownerId = ownerId;
		return this;
	}

	public String getTitle() {
		return title;
	}

	public Document setTitle(String title) {
		this.title = title;
		return this;
	}

	public Integer getSize() {
		return size;
	}

	public Document setSize(Integer size) {
		this.size = size;
		return this;
	}

	public String getExt() {
		return ext;
	}

	public Document setExt(String ext) {
		this.ext = ext;
		return this;
	}

	public String getUrl() {
		return url;
	}

	public Document setUrl(String url) {
		this.url = url;
		return this;
	}

	public Integer getDate() {
		return date;
	}

	public Document setDate(Integer date) {
		this.date = date;
		return this;
	}

	public Integer getType() {
		return type;
	}

	public Document setType(Integer type) {
		this.type = type;
		return this;
	}

	public Preview getPreview() {
		return preview;
	}

	public Document setPreview(Preview preview) {
		this.preview = preview;
		return this;
	}

	public String getAccessKey() {
		return accessKey;
	}

	public Document setAccessKey(String accessKey) {
		this.accessKey = accessKey;
		return this;
	}
}
