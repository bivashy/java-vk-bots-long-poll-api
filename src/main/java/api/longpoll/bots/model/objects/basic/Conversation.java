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

        public void setId(Integer id) {
            this.id = id;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public Integer getLocalId() {
            return localId;
        }

        public void setLocalId(Integer localId) {
            this.localId = localId;
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

        public void setDisabledUntil(Integer disabledUntil) {
            this.disabledUntil = disabledUntil;
        }

        public Boolean getDisableForever() {
            return disableForever;
        }

        public void setDisableForever(Boolean disableForever) {
            this.disableForever = disableForever;
        }

        public Boolean getNoSound() {
            return noSound;
        }

        public void setNoSound(Boolean noSound) {
            this.noSound = noSound;
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

        public void setAllowed(Boolean allowed) {
            this.allowed = allowed;
        }

        public Integer getReason() {
            return reason;
        }

        public void setReason(Integer reason) {
            this.reason = reason;
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
        }

        public Integer getMembersCount() {
            return membersCount;
        }

        public void setMembersCount(Integer membersCount) {
            this.membersCount = membersCount;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public PinnedMessage getPinnedMessage() {
            return pinnedMessage;
        }

        public void setPinnedMessage(PinnedMessage pinnedMessage) {
            this.pinnedMessage = pinnedMessage;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public Photo getPhoto() {
            return photo;
        }

        public void setPhoto(Photo photo) {
            this.photo = photo;
        }

        public List<Integer> getActiveIds() {
            return activeIds;
        }

        public void setActiveIds(List<Integer> activeIds) {
            this.activeIds = activeIds;
        }

        public Boolean getGroupChannel() {
            return groupChannel;
        }

        public void setGroupChannel(Boolean groupChannel) {
            this.groupChannel = groupChannel;
        }
    }

    public Peer getPeer() {
        return peer;
    }

    public void setPeer(Peer peer) {
        this.peer = peer;
    }

    public Integer getInRead() {
        return inRead;
    }

    public void setInRead(Integer inRead) {
        this.inRead = inRead;
    }

    public Integer getOutRead() {
        return outRead;
    }

    public void setOutRead(Integer outRead) {
        this.outRead = outRead;
    }

    public Integer getUnreadAmount() {
        return unreadAmount;
    }

    public void setUnreadAmount(Integer unreadAmount) {
        this.unreadAmount = unreadAmount;
    }

    public Boolean getImportant() {
        return important;
    }

    public void setImportant(Boolean important) {
        this.important = important;
    }

    public Boolean getUnanswered() {
        return unanswered;
    }

    public void setUnanswered(Boolean unanswered) {
        this.unanswered = unanswered;
    }

    public PushSettings getPushSettings() {
        return pushSettings;
    }

    public void setPushSettings(PushSettings pushSettings) {
        this.pushSettings = pushSettings;
    }

    public CanWrite getCanWrite() {
        return canWrite;
    }

    public void setCanWrite(CanWrite canWrite) {
        this.canWrite = canWrite;
    }

    public ChatSettings getChatSettings() {
        return chatSettings;
    }

    public void setChatSettings(ChatSettings chatSettings) {
        this.chatSettings = chatSettings;
    }
}
