package api.longpoll.bots.model.objects.media;

import com.google.gson.annotations.SerializedName;

public enum DocPreviewType {
    @SerializedName("photo") PHOTO,
    @SerializedName("graffiti") GRAFFITI,
    @SerializedName("audio_msg") AUDIO_MSG,
    @SerializedName("video") VIDEO
}
