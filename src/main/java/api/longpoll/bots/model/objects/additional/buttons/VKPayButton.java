package api.longpoll.bots.model.objects.additional.buttons;

import com.google.gson.JsonElement;
import com.google.gson.annotations.SerializedName;

/**
 * A button to open VK Pay window
 */
public class VKPayButton extends Button {
    public VKPayButton(Action action) {
        super(action);
    }

    /**
     * Describes action for button type of VK Pay.
     */
    public static class Action extends Button.Action {
        /**
         * A string containing VK Pay payment parameters and the id of the app in the aid parameter, separated by &.
         * Example: action=transfer-to-group&group_id=1&aid=10
         */
        @SerializedName("hash")
        private String hash;

        public Action(String hash) {
            this(hash, null);
        }

        public Action(String hash, JsonElement payload) {
            super("vkpay", payload);
            this.hash = hash;
        }

        public String getHash() {
            return hash;
        }

        public void setHash(String hash) {
            this.hash = hash;
        }

        @Override
        public String toString() {
            return "Action{" +
                    "hash='" + hash + '\'' +
                    "} " + super.toString();
        }
    }
}
