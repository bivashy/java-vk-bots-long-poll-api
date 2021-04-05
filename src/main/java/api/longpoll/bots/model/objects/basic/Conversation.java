package api.longpoll.bots.model.objects.basic;

import api.longpoll.bots.model.objects.additional.PinnedMessage;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Describes conversation.
 *
 * @see <a href="https://vk.com/dev/objects/conversation">Conversation</a>
 */
public class Conversation {
    /**
     * Information about location.
     */
    @SerializedName("peer")
    private Peer peer;

    /**
     * ID of the last read incoming message.
     */
    @SerializedName("in_read")
    private Integer inRead;

    /**
     * ID of the last read outcoming message.
     */
    @SerializedName("out_read")
    private Integer outRead;

    /**
     * Number of unread messages.
     */
    @SerializedName("unread_count")
    private Integer unreadAmount;

    /**
     * <b>true</b>, if the conversation marked as important (only for community messages).
     */
    @SerializedName("important")
    private Boolean important;

    /**
     * <b>true</b>, if the conversation marked as unanswered (only for community messages).
     */
    @SerializedName("unanswered")
    private Boolean unanswered;

    /**
     * Push-notifications settings.
     */
    @SerializedName("push_settings")
    private PushSettings pushSettings;

    /**
     * Whether current user can send message to the conversation.
     */
    @SerializedName("can_write")
    private CanWrite canWrite;

    /**
     * Conversation settings.
     */
    @SerializedName("chat_settings")
    private ChatSettings chatSettings;

    /**
     * Describes location.
     */
    public static class Peer {
        /**
         * Destination ID.
         */
        @SerializedName("id")
        private Integer id;

        /**
         * Conversation type.
         */
        @SerializedName("type")
        private String type;

        /**
         * Local destination ID.
         */
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

        @Override
        public String toString() {
            return "Peer{" +
                    "id=" + id +
                    ", type='" + type + '\'' +
                    ", localId=" + localId +
                    '}';
        }
    }

    /**
     * Describes push-notifications settings.
     */
    public static class PushSettings {
        /**
         * Timestamp, to which notification are disables.
         */
        @SerializedName("disabled_until")
        private Integer disabledUntil;

        /**
         * <b>true</b>, if notifications are disabled totally.
         */
        @SerializedName("disabled_forever")
        private Boolean disableForever;

        /**
         * <b>true</b>, if notification alert sound is disabled.
         */
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

        @Override
        public String toString() {
            return "PushSettings{" +
                    "disabledUntil=" + disabledUntil +
                    ", disableForever=" + disableForever +
                    ", noSound=" + noSound +
                    '}';
        }
    }

    /**
     * Information whether current user can send message to the conversation.
     */
    public static class CanWrite {
        /**
         * <b>true</b>, if the user can send message to the conversation.
         */
        @SerializedName("allowed")
        private Boolean allowed;

        /**
         * Reason number.
         */
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

        @Override
        public String toString() {
            return "CanWrite{" +
                    "allowed=" + allowed +
                    ", reason=" + reason +
                    '}';
        }
    }

    /**
     * Describes conversation settings.
     */
    public static class ChatSettings {
        /**
         * Conversation members number.
         */
        @SerializedName("members_count")
        private Integer membersCount;

        /**
         * Conversation title.
         */
        @SerializedName("title")
        private String title;

        /**
         * Pinned message.
         */
        @SerializedName("pinned_message")
        private PinnedMessage pinnedMessage;

        /**
         * Current user state.
         */
        @SerializedName("state")
        private String state;

        /**
         * Conversation cover image.
         */
        @SerializedName("photo")
        private Photo photo;

        /**
         * IDs of the last users who wrote to the conversation.
         */
        @SerializedName("active_ids")
        private List<Integer> activeIds;

        /**
         * Whether the conversation is a community channel.
         */
        @SerializedName("is_group_channel")
        private Boolean groupChannel;

        /**
         * Describes conversation cover image.
         */
        public static class Photo {
            /**
             * URL of conversation image with width size of 50 px.
             */
            @SerializedName("photo_50")
            private String photo50;

            /**
             * URL of conversation image with width size of 100 px.
             */
            @SerializedName("photo_100")
            private String photo100;

            /**
             * URL of conversation image with width size of 200 px.
             */
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

            @Override
            public String toString() {
                return "Photo{" +
                        "photo50='" + photo50 + '\'' +
                        ", photo100='" + photo100 + '\'' +
                        ", photo200='" + photo200 + '\'' +
                        '}';
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

        @Override
        public String toString() {
            return "ChatSettings{" +
                    "membersCount=" + membersCount +
                    ", title='" + title + '\'' +
                    ", pinnedMessage=" + pinnedMessage +
                    ", state='" + state + '\'' +
                    ", photo=" + photo +
                    ", activeIds=" + activeIds +
                    ", groupChannel=" + groupChannel +
                    '}';
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

    @Override
    public String toString() {
        return "Conversation{" +
                "peer=" + peer +
                ", inRead=" + inRead +
                ", outRead=" + outRead +
                ", unreadAmount=" + unreadAmount +
                ", important=" + important +
                ", unanswered=" + unanswered +
                ", pushSettings=" + pushSettings +
                ", canWrite=" + canWrite +
                ", chatSettings=" + chatSettings +
                '}';
    }
}
