package api.longpoll.bots.model.objects.additional.buttons;

import api.longpoll.bots.model.objects.additional.buttons.actions.ButtonAction;

/**
 * Positive button.
 */
public class PositiveButton extends Button {
    public PositiveButton(ButtonAction buttonAction) {
        super(ButtonColor.POSITIVE, buttonAction);
    }
}
