package bots.longpoll.sdk.model.geo;

import com.google.gson.annotations.SerializedName;

public class Geo {
	@SerializedName("type")
	private String type;
	@SerializedName("coordinates")
	private Coordinates coordinates;
	@SerializedName("place")
	private Place place;

	public String getType() {
		return type;
	}

	public Geo setType(String type) {
		this.type = type;
		return this;
	}

	public Coordinates getCoordinates() {
		return coordinates;
	}

	public Geo setCoordinates(Coordinates coordinates) {
		this.coordinates = coordinates;
		return this;
	}

	public Place getPlace() {
		return place;
	}

	public Geo setPlace(Place place) {
		this.place = place;
		return this;
	}
}
