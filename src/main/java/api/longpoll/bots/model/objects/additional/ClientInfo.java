package api.longpoll.bots.model.objects.additional;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Contains information about features available to the user.
 */
public class ClientInfo {
	/**
	 * An array of buttons that the client supports.
	 *
	 * @see <a href="https://vk.com/dev/bots_docs_3?f=4.2.+Data+structure">https://vk.com/dev/bots_docs_3?f=4.2.+Data+structure</a>
	 */
	@SerializedName("button_actions")
	private List<String> buttonActions;

	/**
	 * Bot keyboard support.
	 */
	@SerializedName("keyboard")
	private boolean keyboardAllowed;

	/**
	 * Bot inline-keyboard support.
	 */
	@SerializedName("inline_keyboard")
	private boolean inlineKeyboardAllowed;

	/**
	 * Bot carousel support.
	 */
	@SerializedName("carousel")
	private boolean carouselAllowed;

	/**
	 * Id of the language used.
	 */
	@SerializedName("lang_id")
	private Integer langId;

	/**
	 * Sets button actions.
	 *
	 * @param buttonActions button actions.
	 * @return this ClientInfo
	 */
	public ClientInfo setButtonActions(List<String> buttonActions) {
		this.buttonActions = buttonActions;
		return this;
	}

	/**
	 * Sets keyboard allowed.
	 *
	 * @param keyboardAllowed keyboard_allowed.
	 * @return this ClientInfo.
	 */
	public ClientInfo setKeyboardAllowed(boolean keyboardAllowed) {
		this.keyboardAllowed = keyboardAllowed;
		return this;
	}

	/**
	 * Sets inline keyboard allowed.
	 *
	 * @param inlineKeyboardAllowed inline keyboard allowed.
	 * @return this ClientInfo.
	 */
	public ClientInfo setInlineKeyboardAllowed(boolean inlineKeyboardAllowed) {
		this.inlineKeyboardAllowed = inlineKeyboardAllowed;
		return this;
	}

	/**
	 * Sets carousel allowed.
	 *
	 * @param carouselAllowed carousel allowed.
	 * @return this ClientInfo.
	 */
	public ClientInfo setCarouselAllowed(boolean carouselAllowed) {
		this.carouselAllowed = carouselAllowed;
		return this;
	}

	/**
	 * Sets id of the language.
	 *
	 * @param langId id of the language.
	 * @return this ClientInfo.
	 */
	public ClientInfo setLangId(Integer langId) {
		this.langId = langId;
		return this;
	}

	/**
	 * Gets button actions.
	 *
	 * @return button actions.
	 */
	public List<String> getButtonActions() {
		return buttonActions;
	}

	/**
	 * Gets keyboard allowed.
	 *
	 * @return true if keyboard allowed.
	 */
	public boolean isKeyboardAllowed() {
		return keyboardAllowed;
	}

	/**
	 * Get inline keyboard allowed.
	 *
	 * @return true if inline keyboard allowed.
	 */
	public boolean isInlineKeyboardAllowed() {
		return inlineKeyboardAllowed;
	}

	/**
	 * Gets carousel allowed.
	 *
	 * @return true carousel allowed.
	 */
	public boolean isCarouselAllowed() {
		return carouselAllowed;
	}

	/**
	 * Gets id of the language.
	 *
	 * @return id of the language.
	 */
	public Integer getLangId() {
		return langId;
	}
}
