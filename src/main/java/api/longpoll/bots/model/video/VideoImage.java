package api.longpoll.bots.model.video;

import api.longpoll.bots.adapters.BoolIntAdapter;
import api.longpoll.bots.model.sticker.Image;
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
