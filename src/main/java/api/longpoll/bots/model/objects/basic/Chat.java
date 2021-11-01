package api.longpoll.bots.model.objects.basic;

import api.longpoll.bots.adapters.deserializers.BoolIntDeserializer;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Describes chat.
 *
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
    @JsonAdapter(BoolIntDeserializer.class)
    private Boolean left;

    /**
     * <b>true</b>, user has been kicked from the chat.
     */
    @SerializedName("kicked")
    @JsonAdapter(BoolIntDeserializer.class)
    private Boolean kicked;

    /**
     * Describes push settings.
     */
    public static class PushSettings {
        /**
         * <b>true</b>, if the sound is enabled.
         */
        @SerializedName("sound")
        @JsonAdapter(BoolIntDeserializer.class)
        private Boolean soundEnabled;

        /**
         * Time until notifications is disabled. -1 — forever.
         */
        @SerializedName("disabled_until")
        private Integer disabledUntil;

        public Boolean getSoundEnabled() {
            return soundEnabled;
        }

        public void setSoundEnabled(Boolean soundEnabled) {
            this.soundEnabled = soundEnabled;
        }

        public Integer getDisabledUntil() {
            return disabledUntil;
        }

        public void setDisabledUntil(Integer disabledUntil) {
            this.disabledUntil = disabledUntil;
        }

        @Override
        public String toString() {
            return "PushSettings{" +
                    "soundEnabled=" + soundEnabled +
                    ", disabledUntil=" + disabledUntil +
                    '}';
        }
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public List<Integer> getUsers() {
        return users;
    }

    public void setUsers(List<Integer> users) {
        this.users = users;
    }

    public PushSettings getPushSettings() {
        return pushSettings;
    }

    public void setPushSettings(PushSettings pushSettings) {
        this.pushSettings = pushSettings;
    }

    public String getPhoto50() {
        return photo50;
    }

    public void setPhoto50(String photo50) {
        this.photo50 = photo50;
    }

    public String getPhoto100() {
        return photo100;
    }

    public void setPhoto100(String photo100) {
        this.photo100 = photo100;
    }

    public String getPhoto200() {
        return photo200;
    }

    public void setPhoto200(String photo200) {
        this.photo200 = photo200;
    }

    public Boolean getLeft() {
        return left;
    }

    public void setLeft(Boolean left) {
        this.left = left;
    }

    public Boolean getKicked() {
        return kicked;
    }

    public void setKicked(Boolean kicked) {
        this.kicked = kicked;
    }

    @Override
    public String toString() {
        return "Chat{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", title='" + title + '\'' +
                ", adminId=" + adminId +
                ", users=" + users +
                ", pushSettings=" + pushSettings +
                ", photo50='" + photo50 + '\'' +
                ", photo100='" + photo100 + '\'' +
                ", photo200='" + photo200 + '\'' +
                ", left=" + left +
                ", kicked=" + kicked +
                '}';
    }
}
