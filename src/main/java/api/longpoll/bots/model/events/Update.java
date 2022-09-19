package api.longpoll.bots.model.events;

import api.longpoll.bots.adapters.deserializers.UpdateDeserializer;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;

/**
 * An event that occurs on VK server.
 */
@JsonAdapter(UpdateDeserializer.class)
public class Update {
    /**
     * Event type.
     *
     * @see <a href="https://vk.com/dev/groups_events">list of event types</a>
     */
    @SerializedName("type")
    private Type type;

    /**
     * Object that has triggered the event.
     */
    @SerializedName("object")
    private Update.Object object;

    /**
     * Group ID, where the event occurred.
     */
    @SerializedName("group_id")
    private Integer groupId;

    /**
     * Unique event ID.
     */
    @SerializedName("event_id")
    private String eventId;

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    @Override
    public String toString() {
        return "Update{" +
                "type=" + type +
                ", object=" + object +
                ", groupId=" + groupId +
                ", eventId='" + eventId + '\'' +
                '}';
    }

    /**
     * Event type.
     */
    public enum Type {
        @SerializedName("app_payload") APP_PAYLOAD,
        @SerializedName("audio_new") AUDIO_NEW,
        @SerializedName("board_post_delete") BOARD_POST_DELETE,
        @SerializedName("board_post_edit") BOARD_POST_EDIT,
        @SerializedName("board_post_new") BOARD_POST_NEW,
        @SerializedName("board_post_restore") BOARD_POST_RESTORE,
        @SerializedName("group_change_photo") GROUP_CHANGE_PHOTO,
        @SerializedName("group_change_settings") GROUP_CHANGE_SETTINGS,
        @SerializedName("group_join") GROUP_JOIN,
        @SerializedName("group_leave") GROUP_LEAVE,
        @SerializedName("like_add") LIKE_ADD,
        @SerializedName("like_remove") LIKE_REMOVE,
        @SerializedName("market_comment_delete") MARKET_COMMENT_DELETE,
        @SerializedName("market_comment_edit") MARKET_COMMENT_EDIT,
        @SerializedName("market_comment_new") MARKET_COMMENT_NEW,
        @SerializedName("market_comment_restore") MARKET_COMMENT_RESTORE,
        @SerializedName("market_order_edit") MARKET_ORDER_EDIT,
        @SerializedName("market_order_new") MARKET_ORDER_NEW,
        @SerializedName("message_allow") MESSAGE_ALLOW,
        @SerializedName("message_deny") MESSAGE_DENY,
        @SerializedName("message_edit") MESSAGE_EDIT,
        @SerializedName("message_event") MESSAGE_EVENT,
        @SerializedName("message_new") MESSAGE_NEW,
        @SerializedName("message_reply") MESSAGE_REPLY,
        @SerializedName("message_typing_state") MESSAGE_TYPING_STATE,
        @SerializedName("photo_comment_delete") PHOTO_COMMENT_DELETE,
        @SerializedName("photo_comment_edit") PHOTO_COMMENT_EDIT,
        @SerializedName("photo_comment_new") PHOTO_COMMENT_NEW,
        @SerializedName("photo_comment_restore") PHOTO_COMMENT_RESTORE,
        @SerializedName("photo_new") PHOTO_NEW,
        @SerializedName("poll_vote_new") POLL_VOTE_NEW,
        @SerializedName("user_block") USER_BLOCK,
        @SerializedName("user_unblock") USER_UNBLOCK,
        @SerializedName("video_comment_delete") VIDEO_COMMENT_DELETE,
        @SerializedName("video_comment_edit") VIDEO_COMMENT_EDIT,
        @SerializedName("video_comment_new") VIDEO_COMMENT_NEW,
        @SerializedName("video_comment_restore") VIDEO_COMMENT_RESTORE,
        @SerializedName("video_new") VIDEO_NEW,
        @SerializedName("vkpay_transaction") VKPAY_TRANSACTION,
        @SerializedName("wall_post_new") WALL_POST_NEW,
        @SerializedName("wall_reply_delete") WALL_REPLY_DELETE,
        @SerializedName("wall_reply_edit") WALL_REPLY_EDIT,
        @SerializedName("wall_reply_new") WALL_REPLY_NEW,
        @SerializedName("wall_reply_restore") WALL_REPLY_RESTORE,
        @SerializedName("wall_repost") WALL_REPOST
    }

    /**
     * Marks that derived classes can be a part of <a href="https://vk.com/dev/bots_longpoll">events</a>.
     */
    public interface Object {
    }
}
