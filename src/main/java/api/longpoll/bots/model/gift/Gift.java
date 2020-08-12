package api.longpoll.bots.model.gift;

import api.longpoll.bots.model.attachment.MediaObject;
import com.google.gson.annotations.SerializedName;

public class Gift extends MediaObject {
	@SerializedName("id")
	private Integer id;
	@SerializedName("thumb_256")
	private String thumb256;
	@SerializedName("thumb_96")
	private String thumb96;
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
