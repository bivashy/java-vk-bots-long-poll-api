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

        public void setX(Float x) {
            this.x = x;
        }

        public Float getY() {
            return y;
        }

        public void setY(Float y) {
            this.y = y;
        }

        public Float getX2() {
            return x2;
        }

        public void setX2(Float x2) {
            this.x2 = x2;
        }

        public Float getY2() {
            return y2;
        }

        public void setY2(Float y2) {
            this.y2 = y2;
        }

        @Override
        public String toString() {
            return "Crop{" +
                    "x=" + x +
                    ", y=" + y +
                    ", x2=" + x2 +
                    ", y2=" + y2 +
                    '}';
        }
    }

    public Photo getPhoto() {
        return photo;
    }

    public void setPhoto(Photo photo) {
        this.photo = photo;
    }

    public Crop getCrop() {
        return crop;
    }

    public void setCrop(Crop crop) {
        this.crop = crop;
    }

    public Crop getRect() {
        return rect;
    }

    public void setRect(Crop rect) {
        this.rect = rect;
    }

    @Override
    public String toString() {
        return "CropPhoto{" +
                "photo=" + photo +
                ", crop=" + crop +
                ", rect=" + rect +
                '}';
    }
}