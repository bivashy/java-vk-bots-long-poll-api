package api.longpoll.bots.model.objects.additional.buttons;

import api.longpoll.bots.model.objects.additional.buttons.actions.ButtonAction;

/**
 * Negative button.
 */
public class NegativeButton extends Button {
    public NegativeButton(ButtonAction buttonAction) {
        super(ButtonColor.NEGATIVE, buttonAction);
    }
}
