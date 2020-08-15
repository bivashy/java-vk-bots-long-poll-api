package api.longpoll.bots.model.objects.basic;

import api.longpoll.bots.adapters.BoolIntAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Describes chat.
 * @see <a href="https://vk.com/dev/objects/chat">Chat</a>
 */
public class Chat {
	/**
	 * Chat ID.
	 */
	@SerializedName("id")
	private Integer id;

	/**
	 * Dialog type.
	 */
	@SerializedName("type")
	private String type;

	/**
	 * Chat title.
	 */
	@SerializedName("title")
	private String title;

	/**
	 * ID of the chat starter.
	 */
	@SerializedName("admin_id")
	private Integer adminId;

	/**
	 * List of chat participants' IDs.
	 */
	@SerializedName("users")
	private List<Integer> users;

	/**
	 * Push settings for the chat.
	 */
	@SerializedName("push_settings")
	private PushSettings pushSettings;

	/**
	 * URL chat photo with 50 px in width (if available).
	 */
	@SerializedName("photo_50")
	private String photo50;

	/**
	 * URL chat photo with 100 px in width (if available).
	 */
	@SerializedName("photo_100")
	private String photo100;

	/**
	 * URL chat photo with 200 px in width (if available).
	 */
	@SerializedName("photo_200")
	private String photo200;

	/**
	 * <b>true</b>, if user has been left the chat.
	 */
	@SerializedName("left")
	@JsonAdapter(BoolIntAdapter.class)
	private boolean left;

	/**
	 * <b>true</b>, user has been kicked from the chat.
	 */
	@SerializedName("kicked")
	@JsonAdapter(BoolIntAdapter.class)
	private boolean kicked;

	/**
	 * Describes push settings.
	 */
	public class PushSettings {
		/**
		 * <b>true</b>, if the sound is enabled.
		 */
		@SerializedName("sound")
		@JsonAdapter(BoolIntAdapter.class)
		private boolean soundEnabled;

		/**
		 * Time until notifications is disabled. -1 — forever.
		 */
		@SerializedName("disabled_until")
		private Integer disabledUntil;

		public boolean isSoundEnabled() {
			return soundEnabled;
		}

		public PushSettings setSoundEnabled(boolean soundEnabled) {
			this.soundEnabled = soundEnabled;
			return this;
		}

		public Integer getDisabledUntil() {
			return disabledUntil;
		}

		public PushSettings setDisabledUntil(Integer disabledUntil) {
			this.disabledUntil = disabledUntil;
			return this;
		}
	}

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
