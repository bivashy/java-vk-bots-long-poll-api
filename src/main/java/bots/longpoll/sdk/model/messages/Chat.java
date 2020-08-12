package bots.longpoll.sdk.model.messages;

import bots.longpoll.sdk.adapters.BoolIntAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Chat {
	@SerializedName("id")
	private Integer id;
	@SerializedName("type")
	private String type;
	@SerializedName("title")
	private String title;
	@SerializedName("admin_id")
	private Integer adminId;
	@SerializedName("users")
	private List<Integer> users;
	@SerializedName("push_settings")
	private PushSettings pushSettings;
	@SerializedName("photo_50")
	private String photo50;
	@SerializedName("photo_100")
	private String photo100;
	@SerializedName("photo_200")
	private String photo200;
	@SerializedName("left")
	@JsonAdapter(BoolIntAdapter.class)
	private boolean left;
	@SerializedName("kicked")
	@JsonAdapter(BoolIntAdapter.class)
	private boolean kicked;

	public Integer getId() {
		return id;
	}

	public Chat setId(Integer id) {
		this.id = id;
		return this;
	}

	public String getType() {
		return type;
	}

	public Chat setType(String type) {
		this.type = type;
		return this;
	}

	public String getTitle() {
		return title;
	}

	public Chat setTitle(String title) {
		this.title = title;
		return this;
	}

	public Integer getAdminId() {
		return adminId;
	}

	public Chat setAdminId(Integer adminId) {
		this.adminId = adminId;
		return this;
	}

	public List<Integer> getUsers() {
		return users;
	}

	public Chat setUsers(List<Integer> users) {
		this.users = users;
		return this;
	}

	public PushSettings getPushSettings() {
		return pushSettings;
	}

	public Chat setPushSettings(PushSettings pushSettings) {
		this.pushSettings = pushSettings;
		return this;
	}

	public String getPhoto50() {
		return photo50;
	}

	public Chat setPhoto50(String photo50) {
		this.photo50 = photo50;
		return this;
	}

	public String getPhoto100() {
		return photo100;
	}

	public Chat setPhoto100(String photo100) {
		this.photo100 = photo100;
		return this;
	}

	public String getPhoto200() {
		return photo200;
	}

	public Chat setPhoto200(String photo200) {
		this.photo200 = photo200;
		return this;
	}

	public boolean isLeft() {
		return left;
	}

	public Chat setLeft(boolean left) {
		this.left = left;
		return this;
	}

	public boolean isKicked() {
		return kicked;
	}

	public Chat setKicked(boolean kicked) {
		this.kicked = kicked;
		return this;
	}
}
