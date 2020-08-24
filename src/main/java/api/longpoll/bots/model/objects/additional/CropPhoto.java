package api.longpoll.bots.model.objects.additional;

import api.longpoll.bots.model.objects.media.Photo;
import com.google.gson.annotations.SerializedName;

/**
 * Data about points used for cropping of photo.
 */
public class CropPhoto {
    /**
     * Photo object with user photo used for cropping.
     */
    @SerializedName("photo")
    private Photo photo;

    /**
     * Cropped photo.
     */
    @SerializedName("crop")
    private Crop crop;

    /**
     * Preview square photo cropped from crop photo.
     */
    @SerializedName("rect")
    private Crop rect;

    /**
     * Describes cropped photo.
     */
    public static class Crop {
        /**
         * X coordinate for the left upper corner, %.
         */
        @SerializedName("x")
        private Float x;

        /**
         * Y coordinate for the left upper corner, %.
         */
        @SerializedName("y")
        private Float y;

        /**
         * X coordinate for the right bottom corner, %.
         */
        @SerializedName("x2")
        private Float x2;

        /**
         * Y coordinate for the right bottom corner, %.
         */
        @SerializedName("y2")
        private Float y2;

        public Float getX() {
            return x;
        }

        public Crop setX(Float x) {
            this.x = x;
            return this;
        }

        public Float getY() {
            return y;
        }

        public Crop setY(Float y) {
            this.y = y;
            return this;
        }

        public Float getX2() {
            return x2;
        }

        public Crop setX2(Float x2) {
            this.x2 = x2;
            return this;
        }

        public Float getY2() {
            return y2;
        }

        public Crop setY2(Float y2) {
            this.y2 = y2;
            return this;
        }
    }

    public Photo getPhoto() {
        return photo;
    }

    public CropPhoto setPhoto(Photo photo) {
        this.photo = photo;
        return this;
    }

    public Crop getCrop() {
        return crop;
    }

    public CropPhoto setCrop(Crop crop) {
        this.crop = crop;
        return this;
    }

    public Crop getRect() {
        return rect;
    }

    public CropPhoto setRect(Crop rect) {
        this.rect = rect;
        return this;
    }
}