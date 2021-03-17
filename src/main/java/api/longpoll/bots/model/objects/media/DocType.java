package api.longpoll.bots.model.objects.media;

import com.google.gson.annotations.SerializedName;

public enum DocType {
	@SerializedName("1") TEXT_DOCUMENT,
	@SerializedName("2") ARCHIVES,
	@SerializedName("3") GIF,
	@SerializedName("4") IMAGES,
	@SerializedName("5") AUDIO,
	@SerializedName("6") VIDEO,
	@SerializedName("7") E_BOOKS,
	@SerializedName("8") UNKNOWN
}
