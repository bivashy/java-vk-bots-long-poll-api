package api.longpoll.bots.model.objects.additional;

import api.longpoll.bots.model.objects.additional.buttons.Button;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Describes Keyboard object.
 */
public class Keyboard {
    /**
     * Hides the keyboard after the initial use.
     */
    @SerializedName("one_time")
    private Boolean oneTime;

    /**
     * Shows the keyboard inside the message.
     */
    @SerializedName("inline")
    private Boolean inline;

    /**
     * An array of button arrays.
     */
    @SerializedName("buttons")
    private List<List<Button>> buttons;

    public Keyboard(List<List<Button>> buttons) {
        this.buttons = buttons;
    }

    public String toJson() {
        return new Gson().toJson(this);
    }

    public Boolean getOneTime() {
        return oneTime;
    }

    public Keyboard setOneTime(Boolean oneTime) {
        this.oneTime = oneTime;
        return this;
    }

    public Boolean getInline() {
        return inline;
    }

    public Keyboard setInline(Boolean inline) {
        this.inline = inline;
        return this;
    }

    public List<List<Button>> getButtons() {
        return buttons;
    }

    public Keyboard setButtons(List<List<Button>> buttons) {
        this.buttons = buttons;
        return this;
    }

    @Override
    public String toString() {
        return toJson();
    }
}
