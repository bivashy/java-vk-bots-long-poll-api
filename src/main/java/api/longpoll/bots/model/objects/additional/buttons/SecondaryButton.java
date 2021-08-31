package api.longpoll.bots.model.objects.additional.buttons;

import api.longpoll.bots.model.objects.additional.buttons.actions.ButtonAction;

/**
 * Secondary button.
 */
public class SecondaryButton extends Button {
    public SecondaryButton(ButtonAction buttonAction) {
        super(ButtonColor.SECONDARY, buttonAction);
    }
}
