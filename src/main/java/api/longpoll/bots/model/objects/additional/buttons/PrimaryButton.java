package api.longpoll.bots.model.objects.additional.buttons;

import api.longpoll.bots.model.objects.additional.buttons.actions.ButtonAction;

/**
 * Primary button.
 */
public class PrimaryButton extends Button {
    public PrimaryButton(ButtonAction buttonAction) {
        super(ButtonColor.PRIMARY, buttonAction);
    }
}
