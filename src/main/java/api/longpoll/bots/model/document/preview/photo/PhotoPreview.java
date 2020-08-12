package api.longpoll.bots.model.document.preview.photo;

import api.longpoll.bots.model.document.preview.Preview;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * This class may be a part of
 * {@link Preview} class.
 * <p>
 * See <a href="https://vk.com/dev/objects/doc">https://vk.com/dev/objects/doc</a> for details.
 *
 * @see PhotoPreviewSize
 */
public class PhotoPreview {
	/**
	 * List of images in different sizes.
	 */
	@SerializedName("sizes")
	private List<PhotoPreviewSize> sizes;

	public List<PhotoPreviewSize> getSizes() {
		return sizes;
	}

	public PhotoPreview setSizes(List<PhotoPreviewSize> sizes) {
		this.sizes = sizes;
		return this;
	}
}
