package bots.longpoll.sdk.model.document.preview.photo;

import com.google.gson.annotations.SerializedName;

/**
 * This class is a part of {@link PhotoPreview} class.
 * See <a href="https://vk.com/dev/objects/photo_sizes">https://vk.com/dev/objects/photo_sizes</a> for details.
 */
public class PhotoPreviewSize {
	/**
	 * Image URL.
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

	/**
	 * Photo preview type. Possible values:
	 * <ul>
	 * <li><b>s</b> — proportional copy with max side of 100 px;</li>
	 * <li><b>m</b> — proportional copy with max side of 130 px;</li>
	 * <li><b>x</b> — proportional copy with max side of 604 px;</li>
	 * <li><b>y</b> — proportional copy with max side of 807 px;</li>
	 * <li><b>z</b> — proportional copy with max size of 1080x1024 px;</li>
	 * <li><b>o</b> — original size image.</li>
	 * </ul>
	 */
	@SerializedName("type")
	private String type;

	public Integer getWidth() {
		return width;
	}

	public String getSrc() {
		return src;
	}

	public PhotoPreviewSize setSrc(String src) {
		this.src = src;
		return this;
	}

	public PhotoPreviewSize setWidth(Integer width) {
		this.width = width;
		return this;
	}

	public Integer getHeight() {
		return height;
	}

	public PhotoPreviewSize setHeight(Integer height) {
		this.height = height;
		return this;
	}

	public String getType() {
		return type;
	}

	public PhotoPreviewSize setType(String type) {
		this.type = type;
		return this;
	}
}
