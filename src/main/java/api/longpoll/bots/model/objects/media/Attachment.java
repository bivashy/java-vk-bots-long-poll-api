package api.longpoll.bots.model.objects.media;

import com.google.gson.annotations.SerializedName;

/**
 * Describes attachment.
 */
public class Attachment {
	/**
	 * Attachment type.
	 */
	@SerializedName("type")
	private String type;

	/**
	 * Attachment object.
	 */
	private Attachable attachable;

	public String getType() {
		return type;
	}

	public Attachment setType(String type) {
		this.type = type;
		return this;
	}

	public Attachable getAttachable() {
		return attachable;
	}

	public Attachment setAttachable(Attachable attachable) {
		this.attachable = attachable;
		return this;
	}
}
