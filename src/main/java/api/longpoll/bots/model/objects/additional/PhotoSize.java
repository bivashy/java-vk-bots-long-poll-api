package api.longpoll.bots.model.objects.additional;

import com.google.gson.annotations.SerializedName;

/**
 * Describes photo size.
 * @see <a href="https://vk.com/dev/objects/photo_sizes">Photo sizes format</a>
 */
public class PhotoSize {
	@SerializedName("url")
	private String url;
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

	public String getUrl() {
		return url;
	}

	public PhotoSize setUrl(String url) {
		this.url = url;
		return this;
	}

	public Integer getWidth() {
		return width;
	}

	public PhotoSize setWidth(Integer width) {
		this.width = width;
		return this;
	}

	public Integer getHeight() {
		return height;
	}

	public PhotoSize setHeight(Integer height) {
		this.height = height;
		return this;
	}

	public String getType() {
		return type;
	}

	public PhotoSize setType(String type) {
		this.type = type;
		return this;
	}
}
