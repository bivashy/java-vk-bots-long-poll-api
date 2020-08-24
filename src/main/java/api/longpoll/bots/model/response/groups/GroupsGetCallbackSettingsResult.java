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

            public Events setMessageNew(Boolean messageNew) {
                this.messageNew = messageNew;
                return this;
            }

            public Boolean getMessageReply() {
                return messageReply;
            }

            public Events setMessageReply(Boolean messageReply) {
                this.messageReply = messageReply;
                return this;
            }

            public Boolean getMessageEdit() {
                return messageEdit;
            }

            public Events setMessageEdit(Boolean messageEdit) {
                this.messageEdit = messageEdit;
                return this;
            }

            public Boolean getMessageAllow() {
                return messageAllow;
            }

            public Events setMessageAllow(Boolean messageAllow) {
                this.messageAllow = messageAllow;
                return this;
            }

            public Boolean getMessageDeny() {
                return messageDeny;
            }

            public Events setMessageDeny(Boolean messageDeny) {
                this.messageDeny = messageDeny;
                return this;
            }

            public Boolean getPhotoNew() {
                return photoNew;
            }

            public Events setPhotoNew(Boolean photoNew) {
                this.photoNew = photoNew;
                return this;
            }

            public Boolean getAudioNew() {
                return audioNew;
            }

            public Events setAudioNew(Boolean audioNew) {
                this.audioNew = audioNew;
                return this;
            }

            public Boolean getVideoNew() {
                return videoNew;
            }

            public Events setVideoNew(Boolean videoNew) {
                this.videoNew = videoNew;
                return this;
            }

            public Boolean getWallReplyNew() {
                return wallReplyNew;
            }

            public Events setWallReplyNew(Boolean wallReplyNew) {
                this.wallReplyNew = wallReplyNew;
                return this;
            }

            public Boolean getWallReplyEdit() {
                return wallReplyEdit;
            }

            public Events setWallReplyEdit(Boolean wallReplyEdit) {
                this.wallReplyEdit = wallReplyEdit;
                return this;
            }

            public Boolean getWallReplyDelete() {
                return wallReplyDelete;
            }

            public Events setWallReplyDelete(Boolean wallReplyDelete) {
                this.wallReplyDelete = wallReplyDelete;
                return this;
            }

            public Boolean getWallPostNew() {
                return wallPostNew;
            }

            public Events setWallPostNew(Boolean wallPostNew) {
                this.wallPostNew = wallPostNew;
                return this;
            }

            public Boolean getWallRepost() {
                return wallRepost;
            }

            public Events setWallRepost(Boolean wallRepost) {
                this.wallRepost = wallRepost;
                return this;
            }

            public Boolean getBoardPostNew() {
                return boardPostNew;
            }

            public Events setBoardPostNew(Boolean boardPostNew) {
                this.boardPostNew = boardPostNew;
                return this;
            }

            public Boolean getBoardPostEdit() {
                return boardPostEdit;
            }

            public Events setBoardPostEdit(Boolean boardPostEdit) {
                this.boardPostEdit = boardPostEdit;
                return this;
            }

            public Boolean getBoardPostDelete() {
                return boardPostDelete;
            }

            public Events setBoardPostDelete(Boolean boardPostDelete) {
                this.boardPostDelete = boardPostDelete;
                return this;
            }

            public Boolean getBoardPostRestore() {
                return boardPostRestore;
            }

            public Events setBoardPostRestore(Boolean boardPostRestore) {
                this.boardPostRestore = boardPostRestore;
                return this;
            }

            public Boolean getPhotoCommentNew() {
                return PhotoCommentNew;
            }

            public Events setPhotoCommentNew(Boolean photoCommentNew) {
                PhotoCommentNew = photoCommentNew;
                return this;
            }

            public Boolean getPhotoCommentEdit() {
                return photoCommentEdit;
            }

            public Events setPhotoCommentEdit(Boolean photoCommentEdit) {
                this.photoCommentEdit = photoCommentEdit;
                return this;
            }

            public Boolean getPhotoCommentDelete() {
                return photoCommentDelete;
            }

            public Events setPhotoCommentDelete(Boolean photoCommentDelete) {
                this.photoCommentDelete = photoCommentDelete;
                return this;
            }

            public Boolean getPhotoCommentRestore() {
                return photoCommentRestore;
            }

            public Events setPhotoCommentRestore(Boolean photoCommentRestore) {
                this.photoCommentRestore = photoCommentRestore;
                return this;
            }

            public Boolean getVideoCommentNew() {
                return videoCommentNew;
            }

            public Events setVideoCommentNew(Boolean videoCommentNew) {
                this.videoCommentNew = videoCommentNew;
                return this;
            }

            public Boolean getVideoCommentEdit() {
                return videoCommentEdit;
            }

            public Events setVideoCommentEdit(Boolean videoCommentEdit) {
                this.videoCommentEdit = videoCommentEdit;
                return this;
            }

            public Boolean getVideoCommentDelete() {
                return videoCommentDelete;
            }

            public Events setVideoCommentDelete(Boolean videoCommentDelete) {
                this.videoCommentDelete = videoCommentDelete;
                return this;
            }

            public Boolean getVideoCommentRestore() {
                return videoCommentRestore;
            }

            public Events setVideoCommentRestore(Boolean videoCommentRestore) {
                this.videoCommentRestore = videoCommentRestore;
                return this;
            }

            public Boolean getMarketCommentNew() {
                return marketCommentNew;
            }

            public Events setMarketCommentNew(Boolean marketCommentNew) {
                this.marketCommentNew = marketCommentNew;
                return this;
            }

            public Boolean getMarketCommentEdit() {
                return marketCommentEdit;
            }

            public Events setMarketCommentEdit(Boolean marketCommentEdit) {
                this.marketCommentEdit = marketCommentEdit;
                return this;
            }

            public Boolean getMarketCommentDelete() {
                return marketCommentDelete;
            }

            public Events setMarketCommentDelete(Boolean marketCommentDelete) {
                this.marketCommentDelete = marketCommentDelete;
                return this;
            }

            public Boolean getMarketCommentRestore() {
                return marketCommentRestore;
            }

            public Events setMarketCommentRestore(Boolean marketCommentRestore) {
                this.marketCommentRestore = marketCommentRestore;
                return this;
            }

            public Boolean getPollVoteNew() {
                return pollVoteNew;
            }

            public Events setPollVoteNew(Boolean pollVoteNew) {
                this.pollVoteNew = pollVoteNew;
                return this;
            }

            public Boolean getGroupJoin() {
                return groupJoin;
            }

            public Events setGroupJoin(Boolean groupJoin) {
                this.groupJoin = groupJoin;
                return this;
            }

            public Boolean getGroupLeave() {
                return groupLeave;
            }

            public Events setGroupLeave(Boolean groupLeave) {
                this.groupLeave = groupLeave;
                return this;
            }

            public Boolean getUserBlock() {
                return userBlock;
            }

            public Events setUserBlock(Boolean userBlock) {
                this.userBlock = userBlock;
                return this;
            }

            public Boolean getUserUnblock() {
                return userUnblock;
            }

            public Events setUserUnblock(Boolean userUnblock) {
                this.userUnblock = userUnblock;
                return this;
            }

            public Boolean getGroupChangeSettings() {
                return groupChangeSettings;
            }

            public Events setGroupChangeSettings(Boolean groupChangeSettings) {
                this.groupChangeSettings = groupChangeSettings;
                return this;
            }

            public Boolean getGroupChangePhoto() {
                return groupChangePhoto;
            }

            public Events setGroupChangePhoto(Boolean groupChangePhoto) {
                this.groupChangePhoto = groupChangePhoto;
                return this;
            }

            public Boolean getGroupOfficersEdit() {
                return groupOfficersEdit;
            }

            public Events setGroupOfficersEdit(Boolean groupOfficersEdit) {
                this.groupOfficersEdit = groupOfficersEdit;
                return this;
            }
        }

        public String getApiVersion() {
            return apiVersion;
        }

        public Response setApiVersion(String apiVersion) {
            this.apiVersion = apiVersion;
            return this;
        }

        public Events getEvents() {
            return events;
        }

        public Response setEvents(Events events) {
            this.events = events;
            return this;
        }
    }

    public Response getResponse() {
        return response;
    }

    public GroupsGetCallbackSettingsResult setResponse(Response response) {
        this.response = response;
        return this;
    }
}
