package api.longpoll.bots.model.objects.media;

import com.google.gson.annotations.SerializedName;

/**
 * Types of VK Attachments.
 */
public enum AttachmentType {
    @SerializedName("audio") AUDIO,
    @SerializedName("audio_message") AUDIO_MESSAGE,
    @SerializedName("doc") DOCUMENT,
    @SerializedName("graffiti") GRAFFITI,
    @SerializedName("link") LINK,
    @SerializedName("market") MARKET,
    @SerializedName("market_album") MARKET_ALBUM,
    @SerializedName("photo") PHOTO,
    @SerializedName("poll") POLL,
    @SerializedName("sticker") STICKER,
    @SerializedName("wall") WALL_POST,
    @SerializedName("wall_reply") WALL_REPLY,
    @SerializedName("video") VIDEO
}
