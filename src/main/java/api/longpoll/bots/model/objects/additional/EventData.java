package api.longpoll.bots.model.objects.additional;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

/**
 * An object of the action that should occur after clicking the button.
 */
public abstract class EventData {
    /**
     * Action type.
     */
    @SerializedName("type")
    private final String type;

    public EventData(String type) {
        this.type = type;
    }

    /**
     * To show disappearing message.
     */
    public static class ShowSnackbar extends EventData {
        /**
         * Text to display.
         */
        @SerializedName("text")
        private String text;

        public ShowSnackbar(String text) {
            super("show_snackbar");
            this.text = text;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public String toJson() {
            return new Gson().toJson(this);
        }

        @Override
        public String toString() {
            return toJson();
        }
    }

    /**
     * To open a link.
     */
    public static class OpenLink extends EventData {
        /**
         * A link to be opened.
         */
        @SerializedName("link")
        private String link;

        public OpenLink(String link) {
            super("open_link");
            this.link = link;
        }

        public String getLink() {
            return link;
        }

        public void setLink(String link) {
            this.link = link;
        }

        public String toJson() {
            return new Gson().toJson(this);
        }

        @Override
        public String toString() {
            return toJson();
        }
    }

    /**
     * To open a VK Mini App.
     */
    public static class OpenApp extends EventData {
        /**
         * Application ID.
         */
        @SerializedName("app_id")
        private int appId;

        /**
         * App hash.
         */
        @SerializedName("hash")
        private String hash;

        /**
         * Owner ID.
         */
        @SerializedName("owner_id")
        private Integer ownerId;

        public OpenApp(int appId, Integer ownerId, String hash) {
            super("open_app");
            this.appId = appId;
            this.ownerId = ownerId;
            this.hash = hash;
        }

        public int getAppId() {
            return appId;
        }

        public void setAppId(int appId) {
            this.appId = appId;
        }

        public String getHash() {
            return hash;
        }

        public void setHash(String hash) {
            this.hash = hash;
        }

        public Integer getOwnerId() {
            return ownerId;
        }

        public void setOwnerId(Integer ownerId) {
            this.ownerId = ownerId;
        }

        public String toJson() {
            return new Gson().toJson(this);
        }

        @Override
        public String toString() {
            return toJson();
        }
    }
}
