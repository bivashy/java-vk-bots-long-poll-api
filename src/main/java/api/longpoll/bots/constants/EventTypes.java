package api.longpoll.bots.constants;

// TODO: 13.11.2020 add message_allow and message_deny
public class EventTypes {
    public static final String MESSAGE_NEW = "message_new";
    public static final String MESSAGE_REPLY = "message_reply";
    public static final String MESSAGE_EDIT = "message_edit";
    public static final String MESSAGE_EVENT = "message_event";
    public static final String MESSAGE_TYPING_STATE = "message_typing_state";

    public static final String PHOTO_NEW = "photo_new";
    public static final String PHOTO_COMMENT_NEW = "photo_comment_new";
    public static final String PHOTO_COMMENT_EDIT = "photo_comment_edit";
    public static final String PHOTO_COMMENT_DELETE = "photo_comment_delete";
    public static final String PHOTO_COMMENT_RESTORE = "photo_comment_restore";

    public static final String AUDIO_NEW = "audio_new";

    public static final String VIDEO_NEW = "video_new";
    public static final String VIDEO_COMMENT_NEW = "video_comment_new";
    public static final String VIDEO_COMMENT_EDIT = "video_comment_edit";
    public static final String VIDEO_COMMENT_RESTORE = "video_comment_restore";
    public static final String VIDEO_COMMENT_DELETE = "video_comment_delete";

    public static final String WALL_POST_NEW = "wall_post_new";
    public static final String WALL_REPOST = "wall_repost";

    public static final String LIKE_ADD = "like_add";
    public static final String LIKE_REMOVE = "like_remove";

    public static final String WALL_REPLY_NEW = "wall_reply_new";
    public static final String WALL_REPLY_EDIT = "wall_reply_edit";
    public static final String WALL_REPLY_DELETE = "wall_reply_delete";
    public static final String WALL_REPLY_RESTORE = "wall_reply_restore";

    public static final String BOARD_POST_NEW = "board_post_new";
    public static final String BOARD_POST_EDIT = "board_post_edit";
    public static final String BOARD_POST_DELETE = "board_post_delete";
    public static final String BOARD_POST_RESTORE = "board_post_restore";

    public static final String MARKET_COMMENT_NEW = "market_comment_new";
    public static final String MARKET_COMMENT_EDIT = "market_comment_edit";
    public static final String MARKET_COMMENT_RESTORE = "market_comment_restore";
    public static final String MARKET_COMMENT_DELETE = "market_comment_delete";

    public static final String MARKET_ORDER_NEW = "market_order_new";
    public static final String MARKET_ORDER_EDIT = "market_order_edit";

    public static final String GROUP_LEAVE = "group_leave";
    public static final String GROUP_JOIN = "group_join";
    public static final String USER_BLOCK = "user_block";
    public static final String USER_UNBLOCK = "user_unblock";

    public static final String GROUP_CHANGE_SETTINGS = "group_change_settings";
    public static final String GROUP_CHANGE_PHOTO = "group_change_photo";
    public static final String VKPAY_TRANSACTION = "vkpay_transaction";
    public static final String APP_PAYLOAD = "app_payload";
}
