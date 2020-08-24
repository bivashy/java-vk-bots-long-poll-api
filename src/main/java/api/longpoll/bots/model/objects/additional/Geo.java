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

		/**
		 * Gets geographical latitude.
		 *
		 * @return geographical latitude.
		 */
		public Float getLatitude() {
			return latitude;
		}

		/**
		 * Sets geographical latitude.
		 *
		 * @param latitude geographical latitude.
		 * @return this Coordinates.
		 */
		public Coordinates setLatitude(Float latitude) {
			this.latitude = latitude;
			return this;
		}

		/**
		 * Gets geographical longitude.
		 *
		 * @return geographical longitude.
		 */
		public Float getLongitude() {
			return longitude;
		}

		/**
		 * Sets geographical longitude.
		 *
		 * @param longitude geographical longitude.
		 * @return this Coordinates.
		 */
		public Coordinates setLongitude(Float longitude) {
			this.longitude = longitude;
			return this;
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

		/**
		 * Gets place ID.
		 *
		 * @return place ID.
		 */
		public Integer getId() {
			return id;
		}

		/**
		 * Sets place ID.
		 *
		 * @param id place ID.
		 * @return this Place.
		 */
		public Place setId(Integer id) {
			this.id = id;
			return this;
		}

		/**
		 * Gets place title.
		 *
		 * @return place title.
		 */
		public String getTitle() {
			return title;
		}

		/**
		 * Sets place title.
		 *
		 * @param title place title
		 * @return this Place.
		 */
		public Place setTitle(String title) {
			this.title = title;
			return this;
		}

		/**
		 * Gets geographical latitude.
		 *
		 * @return geographical latitude.
		 */
		public Float getLatitude() {
			return latitude;
		}

		/**
		 * Sets geographical latitude.
		 *
		 * @param latitude geographical latitude.
		 * @return this Place.
		 */
		public Place setLatitude(Float latitude) {
			this.latitude = latitude;
			return this;
		}

		/**
		 * Gets geographical longitude.
		 *
		 * @return geographical longitude.
		 */
		public Float getLongitude() {
			return longitude;
		}

		/**
		 * Sets geographical longitude.
		 *
		 * @param longitude geographical longitude
		 * @return this Place.
		 */
		public Place setLongitude(Float longitude) {
			this.longitude = longitude;
			return this;
		}

		/**
		 * Gets created date.
		 *
		 * @return created date.
		 */
		public Integer getCreated() {
			return created;
		}

		/**
		 * Sets created date.
		 *
		 * @param created created date.
		 * @return this Place.
		 */
		public Place setCreated(Integer created) {
			this.created = created;
			return this;
		}

		/**
		 * Gets icon URL.
		 *
		 * @return icon URL.
		 */
		public String getIcon() {
			return icon;
		}

		/**
		 * Sets icon URL.
		 *
		 * @param icon icon URL.
		 * @return this Place.
		 */
		public Place setIcon(String icon) {
			this.icon = icon;
			return this;
		}

		/**
		 * Gets country name.
		 *
		 * @return country name.
		 */
		public String getCountry() {
			return country;
		}

		/**
		 * Sets country name.
		 *
		 * @param country country name.
		 * @return this Place.
		 */
		public Place setCountry(String country) {
			this.country = country;
			return this;
		}

		/**
		 * Gets city name.
		 *
		 * @return city name.
		 */
		public String getCity() {
			return city;
		}

		/**
		 * Sets city name.
		 *
		 * @param city city name.
		 * @return this Place.
		 */
		public Place setCity(String city) {
			this.city = city;
			return this;
		}
	}

	/**
	 * Gets location type.
	 *
	 * @return location type.
	 */
	public String getType() {
		return type;
	}

	/**
	 * Sets location type.
	 *
	 * @param type location type.
	 * @return this Geo.
	 */
	public Geo setType(String type) {
		this.type = type;
		return this;
	}

	/**
	 * Gets location coordinates.
	 *
	 * @return location coordinates.
	 */
	public Coordinates getCoordinates() {
		return coordinates;
	}

	/**
	 * Sets location coordinates.
	 *
	 * @param coordinates location coordinates
	 * @return this Geo.
	 */
	public Geo setCoordinates(Coordinates coordinates) {
		this.coordinates = coordinates;
		return this;
	}

	/**
	 * Gets place description.
	 *
	 * @return place description.
	 */
	public Place getPlace() {
		return place;
	}

	/**
	 * Sets place description.
	 *
	 * @param place place description.
	 * @return this Geo.
	 */
	public Geo setPlace(Place place) {
		this.place = place;
		return this;
	}
}
