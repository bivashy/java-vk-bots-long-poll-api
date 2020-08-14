package api.longpoll.bots.model.objects.media;

import com.google.gson.annotations.SerializedName;

/**
 * Describes gift.
 * @see <a href="https://vk.com/dev/objects/gift">Gift</a>
 */
public class Gift implements Attachable {
	/**
	 * Gift ID.
	 */
	@SerializedName("id")
	private Integer id;

	/**
	 * URL of the image with size 256x256px.
	 */
	@SerializedName("thumb_256")
	private String thumb256;

	/**
	 * URL of the image with size 96x96px.
	 */
	@SerializedName("thumb_96")
	private String thumb96;

	/**
	 * URL of the image with size 48x48px.
	 */
	@SerializedName("thumb_48")
	private String thumb48;

	public Integer getId() {
		return id;
	}

	public Gift setId(Integer id) {
		this.id = id;
		return this;
	}

	public String getThumb256() {
		return thumb256;
	}

	public Gift setThumb256(String thumb256) {
		this.thumb256 = thumb256;
		return this;
	}

	public String getThumb96() {
		return thumb96;
	}

	public Gift setThumb96(String thumb96) {
		this.thumb96 = thumb96;
		return this;
	}

	public String getThumb48() {
		return thumb48;
	}

	public Gift setThumb48(String thumb48) {
		this.thumb48 = thumb48;
		return this;
	}
}
