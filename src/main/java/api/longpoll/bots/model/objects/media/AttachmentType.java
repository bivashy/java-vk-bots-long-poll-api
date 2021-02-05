package api.longpoll.bots.model.objects.media;

import com.google.gson.annotations.SerializedName;

public enum AttachmentType {
    @SerializedName("photo") PHOTO("photo"),
    @SerializedName("video") VIDEO("video"),
    @SerializedName("audio") AUDIO("audio"),
    @SerializedName("doc") DOCUMENT("doc"),
    @SerializedName("graffiti") GRAFFITI("graffiti"),
    @SerializedName("audio_message") AUDIO_MESSAGE("audio_message"),
    @SerializedName("sticker") STICKER("sticker"),
    @SerializedName("wall") WALL_POST("wall"),
    @SerializedName("wall_reply") WALL_REPLY("wall_reply"),
    @SerializedName("link") LINK("link"),
    @SerializedName("market_album") MARKET_ALBUM("market_album"),
    @SerializedName("market") MARKET("market");

    private String value;

    AttachmentType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
