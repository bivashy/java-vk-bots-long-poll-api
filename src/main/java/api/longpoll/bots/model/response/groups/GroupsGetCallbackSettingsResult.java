package api.longpoll.bots.model.response.groups;

import api.longpoll.bots.adapters.BoolIntAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;

public class GroupsGetCallbackSettingsResult {
    @SerializedName("response")
    private Response response;

    public static class Response {
        @SerializedName("api_version")
        private String apiVersion;
        @SerializedName("events")
        private Events events;

        public static class Events {
            @SerializedName("message_new")
            @JsonAdapter(BoolIntAdapter.class)
            private Boolean messageNew;
            @SerializedName("message_reply")
            @JsonAdapter(BoolIntAdapter.class)
            private Boolean messageReply;
            @SerializedName("message_edit")
            @JsonAdapter(BoolIntAdapter.class)
            private Boolean messageEdit;
            @SerializedName("message_allow")
            @JsonAdapter(BoolIntAdapter.class)
            private Boolean messageAllow;
            @SerializedName("message_deny")
            @JsonAdapter(BoolIntAdapter.class)
            private Boolean messageDeny;
            @SerializedName("photo_new")
            @JsonAdapter(BoolIntAdapter.class)
            private Boolean photoNew;
            @SerializedName("audio_new")
            @JsonAdapter(BoolIntAdapter.class)
            private Boolean audioNew;
            @SerializedName("video_new")
            @JsonAdapter(BoolIntAdapter.class)
            private Boolean videoNew;
            @SerializedName("wall_reply_new")
            @JsonAdapter(BoolIntAdapter.class)
            private Boolean wallReplyNew;
            @SerializedName("wall_reply_edit")
            @JsonAdapter(BoolIntAdapter.class)
            private Boolean wallReplyEdit;
            @SerializedName("wall_reply_delete")
            @JsonAdapter(BoolIntAdapter.class)
            private Boolean wallReplyDelete;
            @SerializedName("wall_post_new")
            @JsonAdapter(BoolIntAdapter.class)
            private Boolean wallPostNew;
            @SerializedName("wall_repost")
            @JsonAdapter(BoolIntAdapter.class)
            private Boolean wallRepost;
            @SerializedName("board_post_new")
            @JsonAdapter(BoolIntAdapter.class)
            private Boolean boardPostNew;
            @SerializedName("board_post_edit")
            @JsonAdapter(BoolIntAdapter.class)
            private Boolean boardPostEdit;
            @SerializedName("board_post_delete")
            @JsonAdapter(BoolIntAdapter.class)
            private Boolean boardPostDelete;
            @SerializedName("board_post_restore")
            @JsonAdapter(BoolIntAdapter.class)
            private Boolean boardPostRestore;
            @SerializedName("photo_comment_new")
            @JsonAdapter(BoolIntAdapter.class)
            private Boolean PhotoCommentNew;
            @SerializedName("photo_comment_edit")
            @JsonAdapter(BoolIntAdapter.class)
            private Boolean photoCommentEdit;
            @SerializedName("photo_comment_delete")
            @JsonAdapter(BoolIntAdapter.class)
            private Boolean photoCommentDelete;
            @SerializedName("photo_comment_restore")
            @JsonAdapter(BoolIntAdapter.class)
            private Boolean photoCommentRestore;
            @SerializedName("video_comment_new")
            @JsonAdapter(BoolIntAdapter.class)
            private Boolean videoCommentNew;
            @SerializedName("video_comment_edit")
            @JsonAdapter(BoolIntAdapter.class)
            private Boolean videoCommentEdit;
            @SerializedName("video_comment_delete")
            @JsonAdapter(BoolIntAdapter.class)
            private Boolean videoCommentDelete;
            @SerializedName("video_comment_restore")
            @JsonAdapter(BoolIntAdapter.class)
            private Boolean videoCommentRestore;
            @SerializedName("market_comment_new")
            @JsonAdapter(BoolIntAdapter.class)
            private Boolean marketCommentNew;
            @SerializedName("market_comment_edit")
            @JsonAdapter(BoolIntAdapter.class)
            private Boolean marketCommentEdit;
            @SerializedName("market_comment_delete")
            @JsonAdapter(BoolIntAdapter.class)
            private Boolean marketCommentDelete;
            @SerializedName("market_comment_restore")
            @JsonAdapter(BoolIntAdapter.class)
            private Boolean marketCommentRestore;
            @SerializedName("poll_vote_new")
            @JsonAdapter(BoolIntAdapter.class)
            private Boolean pollVoteNew;
            @SerializedName("group_join")
            @JsonAdapter(BoolIntAdapter.class)
            private Boolean groupJoin;
            @SerializedName("group_leave")
            @JsonAdapter(BoolIntAdapter.class)
            private Boolean groupLeave;
            @SerializedName("user_block")
            @JsonAdapter(BoolIntAdapter.class)
            private Boolean userBlock;
            @SerializedName("user_unblock")
            @JsonAdapter(BoolIntAdapter.class)
            private Boolean userUnblock;
            @SerializedName("group_change_settings")
            @JsonAdapter(BoolIntAdapter.class)
            private Boolean groupChangeSettings;
            @SerializedName("group_change_photo")
            @JsonAdapter(BoolIntAdapter.class)
            private Boolean groupChangePhoto;
            @SerializedName("group_officers_edit")
            @JsonAdapter(BoolIntAdapter.class)
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
    }

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }
}
