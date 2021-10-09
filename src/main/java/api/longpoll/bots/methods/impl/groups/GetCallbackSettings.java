package api.longpoll.bots.methods.impl.groups;

import api.longpoll.bots.adapters.deserializers.BoolIntDeserializer;
import api.longpoll.bots.methods.AuthorizedVkApiMethod;
import api.longpoll.bots.methods.VkApiProperties;
import api.longpoll.bots.model.response.GenericResponse;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;

/**
 * Implements <b>groups.getCallbackSettings</b> method.
 * <p>
 * Returns Callback API notifications settings.
 *
 * @see <a href="https://vk.com/dev/groups.getCallbackSettings">https://vk.com/dev/groups.getCallbackSettings</a>
 */
public class GetCallbackSettings extends AuthorizedVkApiMethod<GetCallbackSettings.Response> {
    public GetCallbackSettings(String accessToken) {
        super(accessToken);
    }

    @Override
    protected String getUrl() {
        return VkApiProperties.get("groups.getCallbackSettings");
    }

    @Override
    protected Class<Response> getResponseType() {
        return Response.class;
    }

    public GetCallbackSettings setGroupId(int groupId) {
        return addParam("group_id", groupId);
    }

    public GetCallbackSettings setServerId(int serverId) {
        return addParam("server_id", serverId);
    }

    @Override
    public GetCallbackSettings addParam(String key, Object value) {
        return (GetCallbackSettings) super.addParam(key, value);
    }

    /**
     * Response to <b>groups.getCallbackSettings</b> request.
     */
    public static class Response extends GenericResponse<Response.ResponseObject> {
        /**
         * Response object.
         */
        public static class ResponseObject {
            /**
             * API version.
             */
            @SerializedName("api_version")
            private String apiVersion;

            /**
             * Server events.
             */
            @SerializedName("events")
            private Events events;

            /**
             * Describes events.
             */
            public static class Events {
                /**
                 * New message.
                 */
                @SerializedName("message_new")
                @JsonAdapter(BoolIntDeserializer.class)
                private Boolean messageNew;

                /**
                 * New outcoming message.
                 */
                @SerializedName("message_reply")
                @JsonAdapter(BoolIntDeserializer.class)
                private Boolean messageReply;

                /**
                 * Message has been edited.
                 */
                @SerializedName("message_edit")
                @JsonAdapter(BoolIntDeserializer.class)
                private Boolean messageEdit;

                /**
                 * New user consent to messages sending.
                 */
                @SerializedName("message_allow")
                @JsonAdapter(BoolIntDeserializer.class)
                private Boolean messageAllow;

                /**
                 * New user prohibition to messages sending.
                 */
                @SerializedName("message_deny")
                @JsonAdapter(BoolIntDeserializer.class)
                private Boolean messageDeny;

                /**
                 * New photo.
                 */
                @SerializedName("photo_new")
                @JsonAdapter(BoolIntDeserializer.class)
                private Boolean photoNew;

                /**
                 * New audio.
                 */
                @SerializedName("audio_new")
                @JsonAdapter(BoolIntDeserializer.class)
                private Boolean audioNew;

                /**
                 * New video.
                 */
                @SerializedName("video_new")
                @JsonAdapter(BoolIntDeserializer.class)
                private Boolean videoNew;

                /**
                 * New comment on wall.
                 */
                @SerializedName("wall_reply_new")
                @JsonAdapter(BoolIntDeserializer.class)
                private Boolean wallReplyNew;

                /**
                 * Comment on wall has been edited.
                 */
                @SerializedName("wall_reply_edit")
                @JsonAdapter(BoolIntDeserializer.class)
                private Boolean wallReplyEdit;

                /**
                 * Comment on wall has been deleted.
                 */
                @SerializedName("wall_reply_delete")
                @JsonAdapter(BoolIntDeserializer.class)
                private Boolean wallReplyDelete;

                /**
                 * New post on the wall.
                 */
                @SerializedName("wall_post_new")
                @JsonAdapter(BoolIntDeserializer.class)
                private Boolean wallPostNew;

                /**
                 * New repost form the community.
                 */
                @SerializedName("wall_repost")
                @JsonAdapter(BoolIntDeserializer.class)
                private Boolean wallRepost;

                /**
                 * New comment in board.
                 */
                @SerializedName("board_post_new")
                @JsonAdapter(BoolIntDeserializer.class)
                private Boolean boardPostNew;

                /**
                 * Board comment has been edited.
                 */
                @SerializedName("board_post_edit")
                @JsonAdapter(BoolIntDeserializer.class)
                private Boolean boardPostEdit;

                /**
                 * Board comment has been deleted.
                 */
                @SerializedName("board_post_delete")
                @JsonAdapter(BoolIntDeserializer.class)
                private Boolean boardPostDelete;

                /**
                 * Board comment has been restored.
                 */
                @SerializedName("board_post_restore")
                @JsonAdapter(BoolIntDeserializer.class)
                private Boolean boardPostRestore;

                /**
                 * New comment to photo.
                 */
                @SerializedName("photo_comment_new")
                @JsonAdapter(BoolIntDeserializer.class)
                private Boolean PhotoCommentNew;

                /**
                 * Photo comment has been edited.
                 */
                @SerializedName("photo_comment_edit")
                @JsonAdapter(BoolIntDeserializer.class)
                private Boolean photoCommentEdit;

                /**
                 * Photo comment has been deleted.
                 */
                @SerializedName("photo_comment_delete")
                @JsonAdapter(BoolIntDeserializer.class)
                private Boolean photoCommentDelete;

                /**
                 * Photo comment has been restored.
                 */
                @SerializedName("photo_comment_restore")
                @JsonAdapter(BoolIntDeserializer.class)
                private Boolean photoCommentRestore;

                /**
                 * New comment to video.
                 */
                @SerializedName("video_comment_new")
                @JsonAdapter(BoolIntDeserializer.class)
                private Boolean videoCommentNew;

                /**
                 * Video comment has been edited.
                 */
                @SerializedName("video_comment_edit")
                @JsonAdapter(BoolIntDeserializer.class)
                private Boolean videoCommentEdit;

                /**
                 * Video comment has been deleted.
                 */
                @SerializedName("video_comment_delete")
                @JsonAdapter(BoolIntDeserializer.class)
                private Boolean videoCommentDelete;

                /**
                 * Video comment has been restored.
                 */
                @SerializedName("video_comment_restore")
                @JsonAdapter(BoolIntDeserializer.class)
                private Boolean videoCommentRestore;

                /**
                 * New comment to market item.
                 */
                @SerializedName("market_comment_new")
                @JsonAdapter(BoolIntDeserializer.class)
                private Boolean marketCommentNew;

                /**
                 * Market comment has been edited.
                 */
                @SerializedName("market_comment_edit")
                @JsonAdapter(BoolIntDeserializer.class)
                private Boolean marketCommentEdit;

                /**
                 * Market comment has been deleted.
                 */
                @SerializedName("market_comment_delete")
                @JsonAdapter(BoolIntDeserializer.class)
                private Boolean marketCommentDelete;

                /**
                 * Market comment has been restored.
                 */
                @SerializedName("market_comment_restore")
                @JsonAdapter(BoolIntDeserializer.class)
                private Boolean marketCommentRestore;

                /**
                 * New vote in a public poll has been adeed.
                 */
                @SerializedName("poll_vote_new")
                @JsonAdapter(BoolIntDeserializer.class)
                private Boolean pollVoteNew;

                /**
                 * Joined community.
                 */
                @SerializedName("group_join")
                @JsonAdapter(BoolIntDeserializer.class)
                private Boolean groupJoin;

                /**
                 * Left community.
                 */
                @SerializedName("group_leave")
                @JsonAdapter(BoolIntDeserializer.class)
                private Boolean groupLeave;

                /**
                 * New user in the community's blacklist.
                 */
                @SerializedName("user_block")
                @JsonAdapter(BoolIntDeserializer.class)
                private Boolean userBlock;

                /**
                 * A user has been deleted from the community's blacklist.
                 */
                @SerializedName("user_unblock")
                @JsonAdapter(BoolIntDeserializer.class)
                private Boolean userUnblock;

                /**
                 * Community settings have been changed.
                 */
                @SerializedName("group_change_settings")
                @JsonAdapter(BoolIntDeserializer.class)
                private Boolean groupChangeSettings;

                /**
                 * Community main photo has been changed.
                 */
                @SerializedName("group_change_photo")
                @JsonAdapter(BoolIntDeserializer.class)
                private Boolean groupChangePhoto;

                /**
                 * Community officers list has been changed.
                 */
                @SerializedName("group_officers_edit")
                @JsonAdapter(BoolIntDeserializer.class)
                private Boolean groupOfficersEdit;

                public Boolean getMessageNew() {
                    return messageNew;
                }

                public void setMessageNew(Boolean messageNew) {
                    this.messageNew = messageNew;
                }

                public Boolean getMessageReply() {
                    return messageReply;
                }

                public void setMessageReply(Boolean messageReply) {
                    this.messageReply = messageReply;
                }

                public Boolean getMessageEdit() {
                    return messageEdit;
                }

                public void setMessageEdit(Boolean messageEdit) {
                    this.messageEdit = messageEdit;
                }

                public Boolean getMessageAllow() {
                    return messageAllow;
                }

                public void setMessageAllow(Boolean messageAllow) {
                    this.messageAllow = messageAllow;
                }

                public Boolean getMessageDeny() {
                    return messageDeny;
                }

                public void setMessageDeny(Boolean messageDeny) {
                    this.messageDeny = messageDeny;
                }

                public Boolean getPhotoNew() {
                    return photoNew;
                }

                public void setPhotoNew(Boolean photoNew) {
                    this.photoNew = photoNew;
                }

                public Boolean getAudioNew() {
                    return audioNew;
                }

                public void setAudioNew(Boolean audioNew) {
                    this.audioNew = audioNew;
                }

                public Boolean getVideoNew() {
                    return videoNew;
                }

                public void setVideoNew(Boolean videoNew) {
                    this.videoNew = videoNew;
                }

                public Boolean getWallReplyNew() {
                    return wallReplyNew;
                }

                public void setWallReplyNew(Boolean wallReplyNew) {
                    this.wallReplyNew = wallReplyNew;
                }

                public Boolean getWallReplyEdit() {
                    return wallReplyEdit;
                }

                public void setWallReplyEdit(Boolean wallReplyEdit) {
                    this.wallReplyEdit = wallReplyEdit;
                }

                public Boolean getWallReplyDelete() {
                    return wallReplyDelete;
                }

                public void setWallReplyDelete(Boolean wallReplyDelete) {
                    this.wallReplyDelete = wallReplyDelete;
                }

                public Boolean getWallPostNew() {
                    return wallPostNew;
                }

                public void setWallPostNew(Boolean wallPostNew) {
                    this.wallPostNew = wallPostNew;
                }

                public Boolean getWallRepost() {
                    return wallRepost;
                }

                public void setWallRepost(Boolean wallRepost) {
                    this.wallRepost = wallRepost;
                }

                public Boolean getBoardPostNew() {
                    return boardPostNew;
                }

                public void setBoardPostNew(Boolean boardPostNew) {
                    this.boardPostNew = boardPostNew;
                }

                public Boolean getBoardPostEdit() {
                    return boardPostEdit;
                }

                public void setBoardPostEdit(Boolean boardPostEdit) {
                    this.boardPostEdit = boardPostEdit;
                }

                public Boolean getBoardPostDelete() {
                    return boardPostDelete;
                }

                public void setBoardPostDelete(Boolean boardPostDelete) {
                    this.boardPostDelete = boardPostDelete;
                }

                public Boolean getBoardPostRestore() {
                    return boardPostRestore;
                }

                public void setBoardPostRestore(Boolean boardPostRestore) {
                    this.boardPostRestore = boardPostRestore;
                }

                public Boolean getPhotoCommentNew() {
                    return PhotoCommentNew;
                }

                public void setPhotoCommentNew(Boolean photoCommentNew) {
                    PhotoCommentNew = photoCommentNew;
                }

                public Boolean getPhotoCommentEdit() {
                    return photoCommentEdit;
                }

                public void setPhotoCommentEdit(Boolean photoCommentEdit) {
                    this.photoCommentEdit = photoCommentEdit;
                }

                public Boolean getPhotoCommentDelete() {
                    return photoCommentDelete;
                }

                public void setPhotoCommentDelete(Boolean photoCommentDelete) {
                    this.photoCommentDelete = photoCommentDelete;
                }

                public Boolean getPhotoCommentRestore() {
                    return photoCommentRestore;
                }

                public void setPhotoCommentRestore(Boolean photoCommentRestore) {
                    this.photoCommentRestore = photoCommentRestore;
                }

                public Boolean getVideoCommentNew() {
                    return videoCommentNew;
                }

                public void setVideoCommentNew(Boolean videoCommentNew) {
                    this.videoCommentNew = videoCommentNew;
                }

                public Boolean getVideoCommentEdit() {
                    return videoCommentEdit;
                }

                public void setVideoCommentEdit(Boolean videoCommentEdit) {
                    this.videoCommentEdit = videoCommentEdit;
                }

                public Boolean getVideoCommentDelete() {
                    return videoCommentDelete;
                }

                public void setVideoCommentDelete(Boolean videoCommentDelete) {
                    this.videoCommentDelete = videoCommentDelete;
                }

                public Boolean getVideoCommentRestore() {
                    return videoCommentRestore;
                }

                public void setVideoCommentRestore(Boolean videoCommentRestore) {
                    this.videoCommentRestore = videoCommentRestore;
                }

                public Boolean getMarketCommentNew() {
                    return marketCommentNew;
                }

                public void setMarketCommentNew(Boolean marketCommentNew) {
                    this.marketCommentNew = marketCommentNew;
                }

                public Boolean getMarketCommentEdit() {
                    return marketCommentEdit;
                }

                public void setMarketCommentEdit(Boolean marketCommentEdit) {
                    this.marketCommentEdit = marketCommentEdit;
                }

                public Boolean getMarketCommentDelete() {
                    return marketCommentDelete;
                }

                public void setMarketCommentDelete(Boolean marketCommentDelete) {
                    this.marketCommentDelete = marketCommentDelete;
                }

                public Boolean getMarketCommentRestore() {
                    return marketCommentRestore;
                }

                public void setMarketCommentRestore(Boolean marketCommentRestore) {
                    this.marketCommentRestore = marketCommentRestore;
                }

                public Boolean getPollVoteNew() {
                    return pollVoteNew;
                }

                public void setPollVoteNew(Boolean pollVoteNew) {
                    this.pollVoteNew = pollVoteNew;
                }

                public Boolean getGroupJoin() {
                    return groupJoin;
                }

                public void setGroupJoin(Boolean groupJoin) {
                    this.groupJoin = groupJoin;
                }

                public Boolean getGroupLeave() {
                    return groupLeave;
                }

                public void setGroupLeave(Boolean groupLeave) {
                    this.groupLeave = groupLeave;
                }

                public Boolean getUserBlock() {
                    return userBlock;
                }

                public void setUserBlock(Boolean userBlock) {
                    this.userBlock = userBlock;
                }

                public Boolean getUserUnblock() {
                    return userUnblock;
                }

                public void setUserUnblock(Boolean userUnblock) {
                    this.userUnblock = userUnblock;
                }

                public Boolean getGroupChangeSettings() {
                    return groupChangeSettings;
                }

                public void setGroupChangeSettings(Boolean groupChangeSettings) {
                    this.groupChangeSettings = groupChangeSettings;
                }

                public Boolean getGroupChangePhoto() {
                    return groupChangePhoto;
                }

                public void setGroupChangePhoto(Boolean groupChangePhoto) {
                    this.groupChangePhoto = groupChangePhoto;
                }

                public Boolean getGroupOfficersEdit() {
                    return groupOfficersEdit;
                }

                public void setGroupOfficersEdit(Boolean groupOfficersEdit) {
                    this.groupOfficersEdit = groupOfficersEdit;
                }

                @Override
                public String toString() {
                    return "Events{" +
                            "messageNew=" + messageNew +
                            ", messageReply=" + messageReply +
                            ", messageEdit=" + messageEdit +
                            ", messageAllow=" + messageAllow +
                            ", messageDeny=" + messageDeny +
                            ", photoNew=" + photoNew +
                            ", audioNew=" + audioNew +
                            ", videoNew=" + videoNew +
                            ", wallReplyNew=" + wallReplyNew +
                            ", wallReplyEdit=" + wallReplyEdit +
                            ", wallReplyDelete=" + wallReplyDelete +
                            ", wallPostNew=" + wallPostNew +
                            ", wallRepost=" + wallRepost +
                            ", boardPostNew=" + boardPostNew +
                            ", boardPostEdit=" + boardPostEdit +
                            ", boardPostDelete=" + boardPostDelete +
                            ", boardPostRestore=" + boardPostRestore +
                            ", PhotoCommentNew=" + PhotoCommentNew +
                            ", photoCommentEdit=" + photoCommentEdit +
                            ", photoCommentDelete=" + photoCommentDelete +
                            ", photoCommentRestore=" + photoCommentRestore +
                            ", videoCommentNew=" + videoCommentNew +
                            ", videoCommentEdit=" + videoCommentEdit +
                            ", videoCommentDelete=" + videoCommentDelete +
                            ", videoCommentRestore=" + videoCommentRestore +
                            ", marketCommentNew=" + marketCommentNew +
                            ", marketCommentEdit=" + marketCommentEdit +
                            ", marketCommentDelete=" + marketCommentDelete +
                            ", marketCommentRestore=" + marketCommentRestore +
                            ", pollVoteNew=" + pollVoteNew +
                            ", groupJoin=" + groupJoin +
                            ", groupLeave=" + groupLeave +
                            ", userBlock=" + userBlock +
                            ", userUnblock=" + userUnblock +
                            ", groupChangeSettings=" + groupChangeSettings +
                            ", groupChangePhoto=" + groupChangePhoto +
                            ", groupOfficersEdit=" + groupOfficersEdit +
                            '}';
                }
            }

            public String getApiVersion() {
                return apiVersion;
            }

            public void setApiVersion(String apiVersion) {
                this.apiVersion = apiVersion;
            }

            public Events getEvents() {
                return events;
            }

            public void setEvents(Events events) {
                this.events = events;
            }

            @Override
            public String toString() {
                return "Response{" +
                        "apiVersion='" + apiVersion + '\'' +
                        ", events=" + events +
                        '}';
            }
        }
    }
}
