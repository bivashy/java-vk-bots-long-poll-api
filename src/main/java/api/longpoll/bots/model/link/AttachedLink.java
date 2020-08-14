package api.longpoll.bots.model.link;

import api.longpoll.bots.adapters.BoolIntAdapter;
import api.longpoll.bots.model.link.button.Button;
import api.longpoll.bots.model.link.product.Product;
import api.longpoll.bots.model.objects.media.Attachable;
import api.longpoll.bots.model.photos.Photo;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;

public class AttachedLink implements Attachable {
	@SerializedName("url")
	private String url;
	@SerializedName("title")
	private String title;
	@SerializedName("caption")
	private String caption;
	@SerializedName("description")
	private String description;
	@SerializedName("photo")
	private Photo photo;
	@SerializedName("product")
	private Product product;
	@SerializedName("button")
	private Button button;
	@SerializedName("previewPage")
	private String previewPage;
	@SerializedName("previewUrl")
	private String previewUrl;
	@SerializedName("is_external")
	@JsonAdapter(BoolIntAdapter.class)
	private boolean external;

	public String getUrl() {
		return url;
	}

	public AttachedLink setUrl(String url) {
		this.url = url;
		return this;
	}

	public String getTitle() {
		return title;
	}

	public AttachedLink setTitle(String title) {
		this.title = title;
		return this;
	}

	public String getCaption() {
		return caption;
	}

	public AttachedLink setCaption(String caption) {
		this.caption = caption;
		return this;
	}

	public String getDescription() {
		return description;
	}

	public AttachedLink setDescription(String description) {
		this.description = description;
		return this;
	}

	public Photo getPhoto() {
		return photo;
	}

	public AttachedLink setPhoto(Photo photo) {
		this.photo = photo;
		return this;
	}

	public Product getProduct() {
		return product;
	}

	public AttachedLink setProduct(Product product) {
		this.product = product;
		return this;
	}

	public Button getButton() {
		return button;
	}

	public AttachedLink setButton(Button button) {
		this.button = button;
		return this;
	}

	public String getPreviewPage() {
		return previewPage;
	}

	public AttachedLink setPreviewPage(String previewPage) {
		this.previewPage = previewPage;
		return this;
	}

	public String getPreviewUrl() {
		return previewUrl;
	}

	public AttachedLink setPreviewUrl(String previewUrl) {
		this.previewUrl = previewUrl;
		return this;
	}

	public boolean isExternal() {
		return external;
	}

	public AttachedLink setExternal(boolean external) {
		this.external = external;
		return this;
	}
}
