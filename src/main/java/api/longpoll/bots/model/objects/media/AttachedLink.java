package api.longpoll.bots.model.objects.media;

import api.longpoll.bots.adapters.deserializers.BoolIntDeserializer;
import api.longpoll.bots.model.objects.additional.Price;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;

/**
 * Describes attached link.
 *
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
    @JsonAdapter(BoolIntDeserializer.class)
    private Boolean external;

    /**
     * Describes product.
     *
     * @see <a href="https://vk.com/dev/link_product">Product</a>
     */
    public static class Product {
        /**
         * Product price.
         */
        @SerializedName("price")
        private Price price;

        public Price getPrice() {
            return price;
        }

        public void setPrice(Price price) {
            this.price = price;
        }

        @Override
        public String toString() {
            return "Product{" +
                    "price=" + price +
                    '}';
        }
    }

    /**
     * Describes link button.
     *
     * @see <a href="https://vk.com/dev/link_button">Link Button</a>
     */
    public static class Button {
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
        public static class Action {
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

            public void setType(String type) {
                this.type = type;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            @Override
            public String toString() {
                return "Action{" +
                        "type='" + type + '\'' +
                        ", url='" + url + '\'' +
                        '}';
            }
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public Action getAction() {
            return action;
        }

        public void setAction(Action action) {
            this.action = action;
        }

        @Override
        public String toString() {
            return "Button{" +
                    "title='" + title + '\'' +
                    ", action=" + action +
                    '}';
        }
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Photo getPhoto() {
        return photo;
    }

    public void setPhoto(Photo photo) {
        this.photo = photo;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Button getButton() {
        return button;
    }

    public void setButton(Button button) {
        this.button = button;
    }

    public String getPreviewPage() {
        return previewPage;
    }

    public void setPreviewPage(String previewPage) {
        this.previewPage = previewPage;
    }

    public String getPreviewUrl() {
        return previewUrl;
    }

    public void setPreviewUrl(String previewUrl) {
        this.previewUrl = previewUrl;
    }

    public Boolean getExternal() {
        return external;
    }

    public void setExternal(Boolean external) {
        this.external = external;
    }

    @Override
    public String toString() {
        return "AttachedLink{" +
                "url='" + url + '\'' +
                ", title='" + title + '\'' +
                ", caption='" + caption + '\'' +
                ", description='" + description + '\'' +
                ", photo=" + photo +
                ", product=" + product +
                ", button=" + button +
                ", previewPage='" + previewPage + '\'' +
                ", previewUrl='" + previewUrl + '\'' +
                ", external=" + external +
                '}';
    }
}
