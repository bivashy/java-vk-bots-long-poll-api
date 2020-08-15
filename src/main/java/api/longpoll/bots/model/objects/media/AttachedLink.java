package api.longpoll.bots.model.objects.media;

import api.longpoll.bots.adapters.BoolIntAdapter;
import api.longpoll.bots.model.objects.additional.Price;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;

/**
 * Describes attached link.
 * @see <a href="https://vk.com/dev/objects/link">Attached Link</a>
 */
public class AttachedLink implements Attachable {
	/**
	 * Link URL.
	 */
	@SerializedName("url")
	private String url;

	/**
	 * Link title.
	 */
	@SerializedName("title")
	private String title;

	/**
	 * Link caption (if any).
	 */
	@SerializedName("caption")
	private String caption;

	/**
	 * Link description.
	 */
	@SerializedName("description")
	private String description;

	/**
	 * Preview image (if any).
	 */
	@SerializedName("photo")
	private Photo photo;

	/**
	 * Product info (if any).
	 */
	@SerializedName("product")
	private Product product;

	/**
	 * Button info (if any).
	 */
	@SerializedName("button")
	private Button button;

	/**
	 * ID of the wiki page with the content for preview ("<b>owner_id_page_id</b>").
	 */
	@SerializedName("previewPage")
	private String previewPage;

	/**
	 * URL of the page for preview.
	 */
	@SerializedName("previewUrl")
	private String previewUrl;

	/**
	 * Whether the link is external.
	 */
	@SerializedName("is_external")
	@JsonAdapter(BoolIntAdapter.class)
	private boolean external;

	/**
	 * Describes product.
	 * @see <a href="https://vk.com/dev/link_product">Product</a>
	 */
	public class Product {
		/**
		 * Product price.
		 */
		@SerializedName("price")
		private Price price;

		public boolean hasPrice() {
			return price != null;
		}

		public Price getPrice() {
			return price;
		}

		public Product setPrice(Price price) {
			this.price = price;
			return this;
		}
	}

	/**
	 * Describes link button.
	 * @see <a href="https://vk.com/dev/link_button">Link Button</a>
	 */
	public class Button {
		/**
		 * Button title.
		 */
		@SerializedName("title")
		private String title;

		/**
		 * Button action.
		 */
		@SerializedName("action")
		private Action action;

		/**
		 * Describes button action.
		 */
		public class Action {
			/**
			 * Action type. Possible values:
			 * <ul>
			 *     <li>open_url — open link using {@link Action#url} address.</li>
			 * </ul>
			 */
			@SerializedName("type")
			private String type;

			/**
			 * URL address.
			 */
			@SerializedName("url")
			private String url;

			public String getType() {
				return type;
			}

			public Action setType(String type) {
				this.type = type;
				return this;
			}

			public String getUrl() {
				return url;
			}

			public Action setUrl(String url) {
				this.url = url;
				return this;
			}
		}

		public String getTitle() {
			return title;
		}

		public Button setTitle(String title) {
			this.title = title;
			return this;
		}

		public Action getAction() {
			return action;
		}

		public Button setAction(Action action) {
			this.action = action;
			return this;
		}
	}

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
