package api.longpoll.bots.model.objects.additional.buttons;

import com.google.gson.JsonElement;
import com.google.gson.annotations.SerializedName;

/**
 * A button to open VK App.
 */
public class VKAppsButton extends Button {
    public VKAppsButton(Action action) {
        super(action);
    }

    /**
     * Describes action for button type of VK Apps.
     */
    public static class Action extends Button.Action {
        /**
         * ID of the launched VK Apps application.
         */
        @SerializedName("app_id")
        private int appId;

        /**
         * ID of the community in which the app is installed, if it needs to be opened in that community context.
         */
        @SerializedName("owner_id")
        private int ownerId;

        /**
         * The name of the app, specified on the button.
         */
        @SerializedName("label")
        private String label;

        /**
         * Hash for navigation inside the app; is sent inside the launch parameters string after the # symbol.
         */
        @SerializedName("hash")
        private String hash;

        public Action(int appId, int ownerId, String label, String hash) {
            this(appId, ownerId, label, hash, null);
        }

        public Action(int appId, int ownerId, String label, String hash, JsonElement payload) {
            super("open_app", payload);
            this.appId = appId;
            this.ownerId = ownerId;
            this.label = label;
            this.hash = hash;
        }

        public int getAppId() {
            return appId;
        }

        public void setAppId(int appId) {
            this.appId = appId;
        }

        public int getOwnerId() {
            return ownerId;
        }

        public void setOwnerId(int ownerId) {
            this.ownerId = ownerId;
        }

        public String getLabel() {
            return label;
        }

        public void setLabel(String label) {
            this.label = label;
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
                    "appId=" + appId +
                    ", ownerId=" + ownerId +
                    ", label='" + label + '\'' +
                    ", hash='" + hash + '\'' +
                    "} " + super.toString();
        }
    }
}
