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

    public List<String> getButtonActions() {
        return buttonActions;
    }

    public void setButtonActions(List<String> buttonActions) {
        this.buttonActions = buttonActions;
    }

    public boolean isKeyboardAllowed() {
        return keyboardAllowed;
    }

    public void setKeyboardAllowed(boolean keyboardAllowed) {
        this.keyboardAllowed = keyboardAllowed;
    }

    public boolean isInlineKeyboardAllowed() {
        return inlineKeyboardAllowed;
    }

    public void setInlineKeyboardAllowed(boolean inlineKeyboardAllowed) {
        this.inlineKeyboardAllowed = inlineKeyboardAllowed;
    }

    public boolean isCarouselAllowed() {
        return carouselAllowed;
    }

    public void setCarouselAllowed(boolean carouselAllowed) {
        this.carouselAllowed = carouselAllowed;
    }

    public Integer getLangId() {
        return langId;
    }

    public void setLangId(Integer langId) {
        this.langId = langId;
    }

    @Override
    public String toString() {
        return "ClientInfo{" +
                "buttonActions=" + buttonActions +
                ", keyboardAllowed=" + keyboardAllowed +
                ", inlineKeyboardAllowed=" + inlineKeyboardAllowed +
                ", carouselAllowed=" + carouselAllowed +
                ", langId=" + langId +
                '}';
    }
}
