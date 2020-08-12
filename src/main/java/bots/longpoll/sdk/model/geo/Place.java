package bots.longpoll.sdk.model.geo;

import com.google.gson.annotations.SerializedName;

public class Place {
	@SerializedName("id")
	private Integer id;
	@SerializedName("title")
	private String title;
	@SerializedName("latitude")
	private Float latitude;
	@SerializedName("longitude")
	private Float longitude;
	@SerializedName("created")
	private Integer created;
	@SerializedName("icon")
	private String icon;
	@SerializedName("country")
	private String country;
	@SerializedName("city")
	private String city;

	public Integer getId() {
		return id;
	}

	public Place setId(Integer id) {
		this.id = id;
		return this;
	}

	public String getTitle() {
		return title;
	}

	public Place setTitle(String title) {
		this.title = title;
		return this;
	}

	public Float getLatitude() {
		return latitude;
	}

	public Place setLatitude(Float latitude) {
		this.latitude = latitude;
		return this;
	}

	public Float getLongitude() {
		return longitude;
	}

	public Place setLongitude(Float longitude) {
		this.longitude = longitude;
		return this;
	}

	public Integer getCreated() {
		return created;
	}

	public Place setCreated(Integer created) {
		this.created = created;
		return this;
	}

	public String getIcon() {
		return icon;
	}

	public Place setIcon(String icon) {
		this.icon = icon;
		return this;
	}

	public String getCountry() {
		return country;
	}

	public Place setCountry(String country) {
		this.country = country;
		return this;
	}

	public String getCity() {
		return city;
	}

	public Place setCity(String city) {
		this.city = city;
		return this;
	}
}
