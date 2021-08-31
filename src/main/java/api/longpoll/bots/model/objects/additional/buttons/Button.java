package api.longpoll.bots.model.objects.additional.buttons;

import api.longpoll.bots.model.objects.additional.buttons.actions.ButtonAction;
import com.google.gson.annotations.SerializedName;

/**
 * Describes Button object.
 */
public abstract class Button {
    /**
     * Button color. This parameter is used only for buttons with the Text or Callback actions.
     */
    @SerializedName("color")
    private ButtonColor color;

    /**
     * An object that describes the type of action and its parameters.
     */
    @SerializedName("action")
    private ButtonAction buttonAction;

    public Button(ButtonColor color, ButtonAction buttonAction) {
        this.color = color;
        this.buttonAction = buttonAction;
    }


    @Override
    public String toString() {
        return "Button{" +
                "color=" + color +
                ", action=" + buttonAction +
                '}';
    }
}
