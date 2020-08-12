package api.longpoll.bots.model.sticker;

import api.longpoll.bots.model.attachment.MediaObject;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Sticker extends MediaObject {
	@SerializedName("product_id")
	private Integer productId;
	@SerializedName("sticker_id")
	private Integer stickerId;
	@SerializedName("images")
	private List<Image> images;
	@SerializedName("images_with_background")
	private List<Image> imagesWithBackground;

	public Integer getProductId() {
		return productId;
	}

	public Sticker setProductId(Integer productId) {
		this.productId = productId;
		return this;
	}

	public Integer getStickerId() {
		return stickerId;
	}

	public Sticker setStickerId(Integer stickerId) {
		this.stickerId = stickerId;
		return this;
	}

	public List<Image> getImages() {
		return images;
	}

	public Sticker setImages(List<Image> images) {
		this.images = images;
		return this;
	}

	public List<Image> getImagesWithBackground() {
		return imagesWithBackground;
	}

	public Sticker setImagesWithBackground(List<Image> imagesWithBackground) {
		this.imagesWithBackground = imagesWithBackground;
		return this;
	}
}
