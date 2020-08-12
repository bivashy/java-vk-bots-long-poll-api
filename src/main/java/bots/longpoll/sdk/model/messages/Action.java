package bots.longpoll.sdk.model.messages;

public class Action {
	private String type;
	private Integer memberId;
	private String text;
	private String email;
	private ActionPhoto photo;

	public String getType() {
		return type;
	}

	public Action setType(String type) {
		this.type = type;
		return this;
	}

	public Integer getMemberId() {
		return memberId;
	}

	public Action setMemberId(Integer memberId) {
		this.memberId = memberId;
		return this;
	}

	public String getText() {
		return text;
	}

	public Action setText(String text) {
		this.text = text;
		return this;
	}

	public String getEmail() {
		return email;
	}

	public Action setEmail(String email) {
		this.email = email;
		return this;
	}

	public ActionPhoto getPhoto() {
		return photo;
	}

	public Action setPhoto(ActionPhoto photo) {
		this.photo = photo;
		return this;
	}
}
