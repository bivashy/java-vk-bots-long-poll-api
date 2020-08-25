package api.longpoll.bots.model.objects.media;

import api.longpoll.bots.model.objects.additional.Image;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Sticker implements Attachable {
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

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public Integer getStickerId() {
		return stickerId;
	}

	public void setStickerId(Integer stickerId) {
		this.stickerId = stickerId;
	}

	public List<Image> getImages() {
		return images;
	}

	public void setImages(List<Image> images) {
		this.images = images;
	}

	public List<Image> getImagesWithBackground() {
		return imagesWithBackground;
	}

	public void setImagesWithBackground(List<Image> imagesWithBackground) {
		this.imagesWithBackground = imagesWithBackground;
	}
}
