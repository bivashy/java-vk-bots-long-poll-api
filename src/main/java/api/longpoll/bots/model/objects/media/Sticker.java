package api.longpoll.bots.model.objects.media;

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

	public static class Image {
		@SerializedName("url")
		private String url;
		@SerializedName("width")
		private Integer width;
		@SerializedName("height")
		private Integer height;

		public String getUrl() {
			return url;
		}

		public Image setUrl(String url) {
			this.url = url;
			return this;
		}

		public Integer getWidth() {
			return width;
		}

		public Image setWidth(Integer width) {
			this.width = width;
			return this;
		}

		public Integer getHeight() {
			return height;
		}

		public Image setHeight(Integer height) {
			this.height = height;
			return this;
		}
	}

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
