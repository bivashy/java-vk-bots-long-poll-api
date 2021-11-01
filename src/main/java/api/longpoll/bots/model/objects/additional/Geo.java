package api.longpoll.bots.model.objects.additional;

import com.google.gson.annotations.SerializedName;

/**
 * Contains information about location.
 */
public class Geo {
    /**
     * Location type.
     */
    @SerializedName("type")
    private String type;

    /**
     * Location coordinates.
     */
    @SerializedName("coordinates")
    private Coordinates coordinates;

    /**
     * Place description (if added).
     */
    @SerializedName("place")
    private Place place;

    /**
     * A class describing location coordinates.
     */
    public static class Coordinates {
        /**
         * Geographical latitude.
         */
        @SerializedName("latitude")
        private Float latitude;

        /**
         * Geographical longitude.
         */
        @SerializedName("longitude")
        private Float longitude;

        public Float getLatitude() {
            return latitude;
        }

        public void setLatitude(Float latitude) {
            this.latitude = latitude;
        }

        public Float getLongitude() {
            return longitude;
        }

        public void setLongitude(Float longitude) {
            this.longitude = longitude;
        }

        @Override
        public String toString() {
            return "Coordinates{" +
                    "latitude=" + latitude +
                    ", longitude=" + longitude +
                    '}';
        }
    }

    /**
     * Contains place description.
     */
    public static class Place {
        /**
         * Place ID (if available).
         */
        @SerializedName("id")
        private Integer id;

        /**
         * Place title (if available).
         */
        @SerializedName("title")
        private String title;

        /**
         * Geographical latitude.
         */
        @SerializedName("latitude")
        private Float latitude;

        /**
         * Geographical longitude.
         */
        @SerializedName("longitude")
        private Float longitude;

        /**
         * Date when the place has been created (if available).
         */
        @SerializedName("created")
        private Integer created;

        /**
         * URL of icon image.
         */
        @SerializedName("icon")
        private String icon;

        /**
         * Country name.
         */
        @SerializedName("country")
        private String country;

        /**
         * City name.
         */
        @SerializedName("city")
        private String city;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public Float getLatitude() {
            return latitude;
        }

        public void setLatitude(Float latitude) {
            this.latitude = latitude;
        }

        public Float getLongitude() {
            return longitude;
        }

        public void setLongitude(Float longitude) {
            this.longitude = longitude;
        }

        public Integer getCreated() {
            return created;
        }

        public void setCreated(Integer created) {
            this.created = created;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        @Override
        public String toString() {
            return "Place{" +
                    "id=" + id +
                    ", title='" + title + '\'' +
                    ", latitude=" + latitude +
                    ", longitude=" + longitude +
                    ", created=" + created +
                    ", icon='" + icon + '\'' +
                    ", country='" + country + '\'' +
                    ", city='" + city + '\'' +
                    '}';
        }
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    @Override
    public String toString() {
        return "Geo{" +
                "type='" + type + '\'' +
                ", coordinates=" + coordinates +
                ", place=" + place +
                '}';
    }
}
