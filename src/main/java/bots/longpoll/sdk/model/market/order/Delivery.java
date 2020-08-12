package bots.longpoll.sdk.model.market.order;

import com.google.gson.annotations.SerializedName;

public class Delivery {
	@SerializedName("address")
	private String address;
	@SerializedName("type")
	private String type;
	@SerializedName("track_number")
	private String trackNumber;
	@SerializedName("track_link")
	private String trackLink;
	// TODO: 06.08.2020 https://vk.com/dev/objects/market_order find out what is delivery_point


	public String getAddress() {
		return address;
	}

	public Delivery setAddress(String address) {
		this.address = address;
		return this;
	}

	public String getType() {
		return type;
	}

	public Delivery setType(String type) {
		this.type = type;
		return this;
	}

	public String getTrackNumber() {
		return trackNumber;
	}

	public Delivery setTrackNumber(String trackNumber) {
		this.trackNumber = trackNumber;
		return this;
	}

	public String getTrackLink() {
		return trackLink;
	}

	public Delivery setTrackLink(String trackLink) {
		this.trackLink = trackLink;
		return this;
	}
}
