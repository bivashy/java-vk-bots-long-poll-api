package bots.longpoll.sdk.model.messages;

public class ActionPhoto {
	private String photo50;
	private String photo100;
	private String photo200;

	public String getPhoto50() {
		return photo50;
	}

	public ActionPhoto setPhoto50(String photo50) {
		this.photo50 = photo50;
		return this;
	}

	public String getPhoto100() {
		return photo100;
	}

	public ActionPhoto setPhoto100(String photo100) {
		this.photo100 = photo100;
		return this;
	}

	public String getPhoto200() {
		return photo200;
	}

	public ActionPhoto setPhoto200(String photo200) {
		this.photo200 = photo200;
		return this;
	}
}
