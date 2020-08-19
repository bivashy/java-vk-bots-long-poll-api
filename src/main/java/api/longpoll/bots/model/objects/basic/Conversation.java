package api.longpoll.bots.model.objects.basic;

import api.longpoll.bots.model.objects.additional.PinnedMessage;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Conversation {
    @SerializedName("peer")
    private Peer peer;
    @SerializedName("in_read")
    private Integer inRead;
    @SerializedName("out_read")
    private Integer outRead;
    @SerializedName("unread_count")
    private Integer unreadAmount;
    @SerializedName("important")
    private Boolean important;
    @SerializedName("unanswered")
    private Boolean unanswered;
    @SerializedName("push_settings")
    private PushSettings pushSettings;
    @SerializedName("can_write")
    private CanWrite canWrite;
    @SerializedName("chat_settings")
    private ChatSettings chatSettings;

    public static class Peer {
        @SerializedName("id")
        private Integer id;
        @SerializedName("type")
        private String type;
        @SerializedName("local_id")
        private Integer localId;

        public Integer getId() {
            return id;
        }

        public Peer setId(Integer id) {
            this.id = id;
            return this;
        }

        public String getType() {
            return type;
        }

        public Peer setType(String type) {
            this.type = type;
            return this;
        }

        public Integer getLocalId() {
            return localId;
        }

        public Peer setLocalId(Integer localId) {
            this.localId = localId;
            return this;
        }
    }

    public static class PushSettings {
        @SerializedName("disabled_until")
        private Integer disabledUntil;
        @SerializedName("disabled_forever")
        private Boolean disableForever;
        @SerializedName("no_sound")
        private Boolean noSound;

        public Integer getDisabledUntil() {
            return disabledUntil;
        }

        public PushSettings setDisabledUntil(Integer disabledUntil) {
            this.disabledUntil = disabledUntil;
            return this;
        }

        public Boolean getDisableForever() {
            return disableForever;
        }

        public PushSettings setDisableForever(Boolean disableForever) {
            this.disableForever = disableForever;
            return this;
        }

        public Boolean getNoSound() {
            return noSound;
        }

        public PushSettings setNoSound(Boolean noSound) {
            this.noSound = noSound;
            return this;
        }
    }

    public static class CanWrite {
        @SerializedName("allowed")
        private Boolean allowed;
        @SerializedName("reason")
        private Integer reason;

        public Boolean getAllowed() {
            return allowed;
        }

        public CanWrite setAllowed(Boolean allowed) {
            this.allowed = allowed;
            return this;
        }

        public Integer getReason() {
            return reason;
        }

        public CanWrite setReason(Integer reason) {
            this.reason = reason;
            return this;
        }
    }

    public static class ChatSettings {
        @SerializedName("members_count")
        private Integer membersCount;
        @SerializedName("title")
        private String title;
        @SerializedName("pinned_message")
        private PinnedMessage pinnedMessage;
        @SerializedName("state")
        private String state;
        @SerializedName("photo")
        private Photo photo;
        @SerializedName("active_ids")
        private List<Integer> activeIds;
        @SerializedName("is_group_channel")
        private Boolean groupChannel;

        public static class Photo {
            @SerializedName("photo_50")
            private String photo50;
            @SerializedName("photo_100")
            private String photo100;
            @SerializedName("photo_200")
            private String photo200;

            public String getPhoto50() {
                return photo50;
            }

            public Photo setPhoto50(String photo50) {
                this.photo50 = photo50;
                return this;
            }

            public String getPhoto100() {
                return photo100;
            }

            public Photo setPhoto100(String photo100) {
                this.photo100 = photo100;
                return this;
            }

            public String getPhoto200() {
                return photo200;
            }

            public Photo setPhoto200(String photo200) {
                this.photo200 = photo200;
                return this;
            }
        }

        public Integer getMembersCount() {
            return membersCount;
        }

        public ChatSettings setMembersCount(Integer membersCount) {
            this.membersCount = membersCount;
            return this;
        }

        public String getTitle() {
            return title;
        }

        public ChatSettings setTitle(String title) {
            this.title = title;
            return this;
        }

        public PinnedMessage getPinnedMessage() {
            return pinnedMessage;
        }

        public ChatSettings setPinnedMessage(PinnedMessage pinnedMessage) {
            this.pinnedMessage = pinnedMessage;
            return this;
        }

        public String getState() {
            return state;
        }

        public ChatSettings setState(String state) {
            this.state = state;
            return this;
        }

        public Photo getPhoto() {
            return photo;
        }

        public ChatSettings setPhoto(Photo photo) {
            this.photo = photo;
            return this;
        }

        public List<Integer> getActiveIds() {
            return activeIds;
        }

        public ChatSettings setActiveIds(List<Integer> activeIds) {
            this.activeIds = activeIds;
            return this;
        }

        public Boolean getGroupChannel() {
            return groupChannel;
        }

        public ChatSettings setGroupChannel(Boolean groupChannel) {
            this.groupChannel = groupChannel;
            return this;
        }
    }

    public Peer getPeer() {
        return peer;
    }

    public Conversation setPeer(Peer peer) {
        this.peer = peer;
        return this;
    }

    public Integer getInRead() {
        return inRead;
    }

    public Conversation setInRead(Integer inRead) {
        this.inRead = inRead;
        return this;
    }

    public Integer getOutRead() {
        return outRead;
    }

    public Conversation setOutRead(Integer outRead) {
        this.outRead = outRead;
        return this;
    }

    public Integer getUnreadAmount() {
        return unreadAmount;
    }

    public Conversation setUnreadAmount(Integer unreadAmount) {
        this.unreadAmount = unreadAmount;
        return this;
    }

    public Boolean getImportant() {
        return important;
    }

    public Conversation setImportant(Boolean important) {
        this.important = important;
        return this;
    }

    public Boolean getUnanswered() {
        return unanswered;
    }

    public Conversation setUnanswered(Boolean unanswered) {
        this.unanswered = unanswered;
        return this;
    }

    public PushSettings getPushSettings() {
        return pushSettings;
    }

    public Conversation setPushSettings(PushSettings pushSettings) {
        this.pushSettings = pushSettings;
        return this;
    }

    public CanWrite getCanWrite() {
        return canWrite;
    }

    public Conversation setCanWrite(CanWrite canWrite) {
        this.canWrite = canWrite;
        return this;
    }

    public ChatSettings getChatSettings() {
        return chatSettings;
    }

    public Conversation setChatSettings(ChatSettings chatSettings) {
        this.chatSettings = chatSettings;
        return this;
    }
}
