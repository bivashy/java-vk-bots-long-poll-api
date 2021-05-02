package api.longpoll.bots.model.objects.media;

import com.google.gson.annotations.SerializedName;

public enum AttachmentType {
    @SerializedName("photo") PHOTO,
    @SerializedName("video") VIDEO,
    @SerializedName("audio") AUDIO,
    @SerializedName("doc") DOCUMENT,
    @SerializedName("graffiti") GRAFFITI,
    @SerializedName("audio_message") AUDIO_MESSAGE,
    @SerializedName("sticker") STICKER,
    @SerializedName("wall") WALL_POST,
    @SerializedName("wall_reply") WALL_REPLY,
    @SerializedName("link") LINK,
    @SerializedName("market_album") MARKET_ALBUM,
    @SerializedName("market") MARKET
}
