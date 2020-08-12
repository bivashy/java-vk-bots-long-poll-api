package bots.longpoll.sdk.model.wall.post;

import bots.longpoll.sdk.adapters.BoolIntAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;

public class From {
	@SerializedName("id")
	private Integer id;
	@SerializedName("name")
	private String name;
	@SerializedName("is_closed")
	@JsonAdapter(BoolIntAdapter.class)
	private boolean closed;
	@SerializedName("type")
	private String type;
	@SerializedName("photo_50")
	private String photo50;
	@SerializedName("photo_100")
	private String photo100;

	public Integer getId() {
		return id;
	}

	public From setId(Integer id) {
		this.id = id;
		return this;
	}

	public String getName() {
		return name;
	}

	public From setName(String name) {
		this.name = name;
		return this;
	}

	public boolean isClosed() {
		return closed;
	}

	public From setClosed(boolean closed) {
		this.closed = closed;
		return this;
	}

	public String getType() {
		return type;
	}

	public From setType(String type) {
		this.type = type;
		return this;
	}

	public String getPhoto50() {
		return photo50;
	}

	public From setPhoto50(String photo50) {
		this.photo50 = photo50;
		return this;
	}

	public String getPhoto100() {
		return photo100;
	}

	public From setPhoto100(String photo100) {
		this.photo100 = photo100;
		return this;
	}
}
