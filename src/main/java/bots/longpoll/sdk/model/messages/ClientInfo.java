package bots.longpoll.sdk.model.messages;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ClientInfo {
	@SerializedName("button_actions")
	private List<String> buttonActions;
	@SerializedName("keyboard")
	private boolean keyboardAllowed;
	@SerializedName("inline_keyboard")
	private boolean inlineKeyboardAllowed;
	@SerializedName("carousel")
	private boolean carouselAllowed;
	@SerializedName("lang_id")
	private Integer langId;

	public ClientInfo setButtonActions(List<String> buttonActions) {
		this.buttonActions = buttonActions;
		return this;
	}

	public ClientInfo setKeyboardAllowed(boolean keyboardAllowed) {
		this.keyboardAllowed = keyboardAllowed;
		return this;
	}

	public ClientInfo setInlineKeyboardAllowed(boolean inlineKeyboardAllowed) {
		this.inlineKeyboardAllowed = inlineKeyboardAllowed;
		return this;
	}

	public ClientInfo setCarouselAllowed(boolean carouselAllowed) {
		this.carouselAllowed = carouselAllowed;
		return this;
	}

	public ClientInfo setLangId(Integer langId) {
		this.langId = langId;
		return this;
	}

	public List<String> getButtonActions() {
		return buttonActions;
	}

	public boolean isKeyboardAllowed() {
		return keyboardAllowed;
	}

	public boolean isInlineKeyboardAllowed() {
		return inlineKeyboardAllowed;
	}

	public boolean isCarouselAllowed() {
		return carouselAllowed;
	}

	public Integer getLangId() {
		return langId;
	}
}
