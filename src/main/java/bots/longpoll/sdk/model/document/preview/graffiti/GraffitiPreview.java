package bots.longpoll.sdk.model.document.preview.graffiti;

import com.google.gson.annotations.SerializedName;

/**
 * This class may be a part of
 * {@link bots.longpoll.sdk.model.document.preview.Preview} class.
 * <p>
 * See <a href="https://vk.com/dev/objects/doc">https://vk.com/dev/objects/doc</a> for details.
 *
 * <p>
 * Note: this class is not included into unit tests yet.
 * </p>
 */
public class GraffitiPreview {
	/**
	 * Document URL with graffiti
	 */
	@SerializedName("src")
	private String src;
	/**
	 * Image width in pixels.
	 */
	@SerializedName("width")
	private Integer width;
	/**
	 * Image height in pixels.
	 */
	@SerializedName("height")
	private Integer height;

	public String getSrc() {
		return src;
	}

	public GraffitiPreview setSrc(String src) {
		this.src = src;
		return this;
	}

	public Integer getWidth() {
		return width;
	}

	public GraffitiPreview setWidth(Integer width) {
		this.width = width;
		return this;
	}

	public Integer getHeight() {
		return height;
	}

	public GraffitiPreview setHeight(Integer height) {
		this.height = height;
		return this;
	}
}
