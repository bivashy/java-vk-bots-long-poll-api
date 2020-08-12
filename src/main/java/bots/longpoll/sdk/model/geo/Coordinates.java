package bots.longpoll.sdk.model.geo;

import com.google.gson.annotations.SerializedName;

public class Coordinates {
	@SerializedName("latitude")
	private Float latitude;
	@SerializedName("longitude")
	private Float longitude;

	public Float getLatitude() {
		return latitude;
	}

	public Coordinates setLatitude(Float latitude) {
		this.latitude = latitude;
		return this;
	}

	public Float getLongitude() {
		return longitude;
	}

	public Coordinates setLongitude(Float longitude) {
		this.longitude = longitude;
		return this;
	}
}
