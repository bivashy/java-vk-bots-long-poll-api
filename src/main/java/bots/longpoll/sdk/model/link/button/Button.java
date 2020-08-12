package bots.longpoll.sdk.model.link.button;

import com.google.gson.annotations.SerializedName;

public class Button {
	@SerializedName("title")
	private String title;
	@SerializedName("action")
	private Action action;

	public String getTitle() {
		return title;
	}

	public Button setTitle(String title) {
		this.title = title;
		return this;
	}

	public Action getAction() {
		return action;
	}

	public Button setAction(Action action) {
		this.action = action;
		return this;
	}
}
