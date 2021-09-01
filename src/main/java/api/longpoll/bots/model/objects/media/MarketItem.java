package api.longpoll.bots.model.objects.media;

import api.longpoll.bots.model.objects.additional.Price;
import com.google.gson.annotations.SerializedName;

/**
 * Describes market item.
 *
 * @see <a href="https://vk.com/dev/objects/market_item">Market Item</a>
 */
public class MarketItem implements Attachable {
    /**
     * Item ID.
     */
    @SerializedName("id")
    private Integer id;

    /**
     * Item owner ID.
     */
    @SerializedName("owner_id")
    private Integer ownerId;

    /**
     * Item title.
     */
    @SerializedName("title")
    private String title;

    /**
     * Item description.
     */
    @SerializedName("description")
    private String description;

    /**
     * Item price.
     */
    @SerializedName("price")
    private ItemPrice price;

    /**
     * Item category.
     */
    @SerializedName("category")
    private Category category;

    /**
     * URL of the item photo.
     */
    @SerializedName("thumb_photo")
    private String thumbPhoto;

    /**
     * Creation date in Unixtime.
     */
    @SerializedName("date")
    private Integer date;

    /**
     * Availability status. Possible values:
     * <ul>
     *     <li>0 — item is available;</li>
     *     <li>1 — item is deleted;</li>
     *     <li>2 — item is unavailable.</li>
     * </ul>
     */
    @SerializedName("availability")
    private Integer availability;

    /**
     * <b>true</b>, if object is added to favorites by current users.
     */
    @SerializedName("is_favorite")
    private boolean favourite;

    /**
     * Product SKU.
     */
    @SerializedName("sku")
    private String sku;

    /**
     * Describes item price.
     */
    public static class ItemPrice extends Price {
        /**
         * Old price value multiplied by 100.
         */
        @SerializedName("old_amount")
        private Integer oldAmount;

        public Integer getOldAmount() {
            return oldAmount;
        }

        public void setOldAmount(Integer oldAmount) {
            this.oldAmount = oldAmount;
        }


        @Override
        public String toString() {
            return "ItemPrice{" +
                    "oldAmount=" + oldAmount +
                    "} " + super.toString();
        }
    }

    /**
     * Describes item category.
     */
    public static class Category {
        /**
         * Category ID.
         */
        @SerializedName("id")
        private Integer id;

        /**
         * Category name.
         */
        @SerializedName("name")
        private String name;

        /**
         * Category section.
         */
        @SerializedName("section")
        private Section section;

        /**
         * Describes category section.
         */
        public static class Section {
            /**
             * Section ID.
             */
            @SerializedName("id")
            private Integer id;

            /**
             * Section name.
             */
            @SerializedName("name")
            private String name;

            public Integer getId() {
                return id;
            }

            public void setId(Integer id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            @Override
            public String toString() {
                return "Section{" +
                        "id=" + id +
                        ", name='" + name + '\'' +
                        '}';
            }
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Section getSection() {
            return section;
        }

        public void setSection(Section section) {
            this.section = section;
        }

        @Override
        public String toString() {
            return "Category{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", section=" + section +
                    '}';
        }
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ItemPrice getPrice() {
        return price;
    }

    public void setPrice(ItemPrice price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getThumbPhoto() {
        return thumbPhoto;
    }

    public void setThumbPhoto(String thumbPhoto) {
        this.thumbPhoto = thumbPhoto;
    }

    public Integer getDate() {
        return date;
    }

    public void setDate(Integer date) {
        this.date = date;
    }

    public Integer getAvailability() {
        return availability;
    }

    public void setAvailability(Integer availability) {
        this.availability = availability;
    }

    public boolean isFavourite() {
        return favourite;
    }

    public void setFavourite(boolean favourite) {
        this.favourite = favourite;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    @Override
    public String toString() {
        return "MarketItem{" +
                "id=" + id +
                ", ownerId=" + ownerId +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", category=" + category +
                ", thumbPhoto='" + thumbPhoto + '\'' +
                ", date=" + date +
                ", availability=" + availability +
                ", favourite=" + favourite +
                ", sku='" + sku + '\'' +
                '}';
    }
}
