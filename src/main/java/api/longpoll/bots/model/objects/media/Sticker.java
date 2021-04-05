package api.longpoll.bots.model.objects.media;

import api.longpoll.bots.model.objects.additional.Image;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Describes sticker.
 *
 * @see <a href="https://vk.com/dev/objects/sticker">Sticker</a>
 */
public class Sticker implements Attachable {
    /**
     * Set ID.
     */
    @SerializedName("product_id")
    private Integer productId;

    /**
     * Sticker ID.
     */
    @SerializedName("sticker_id")
    private Integer stickerId;

    /**
     * Sticker images (with transparent background).
     */
    @SerializedName("images")
    private List<Image> images;

    /**
     * Sticker images (with an opaque background).
     */
    @SerializedName("images_with_background")
    private List<Image> imagesWithBackground;

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getStickerId() {
        return stickerId;
    }

    public void setStickerId(Integer stickerId) {
        this.stickerId = stickerId;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public List<Image> getImagesWithBackground() {
        return imagesWithBackground;
    }

    public void setImagesWithBackground(List<Image> imagesWithBackground) {
        this.imagesWithBackground = imagesWithBackground;
    }

    @Override
    public String toString() {
        return "Sticker{" +
                "productId=" + productId +
                ", stickerId=" + stickerId +
                ", images=" + images +
                ", imagesWithBackground=" + imagesWithBackground +
                '}';
    }
}
