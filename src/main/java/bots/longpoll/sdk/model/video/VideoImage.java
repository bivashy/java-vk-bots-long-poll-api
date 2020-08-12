package bots.longpoll.sdk.model.video;

import bots.longpoll.sdk.adapters.BoolIntAdapter;
import bots.longpoll.sdk.model.sticker.Image;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;

public class VideoImage extends Image {
	@SerializedName("with_padding")
	@JsonAdapter(BoolIntAdapter.class)
	private boolean withPadding;

	public boolean isWithPadding() {
		return withPadding;
	}

	public VideoImage setWithPadding(boolean withPadding) {
		this.withPadding = withPadding;
		return this;
	}
}
