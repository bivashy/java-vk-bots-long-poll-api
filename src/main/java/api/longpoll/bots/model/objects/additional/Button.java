package api.longpoll.bots.model.objects.additional;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.annotations.SerializedName;

/**
 * Describes Button object.
 */
public class Button {
    /**
     * Button color. This parameter is used only for buttons with the text type.
     * For possible values see {@link ButtonColor}.
     */
    @SerializedName("color")
    private ButtonColor color;

    /**
     * An object that describes the type of action and its parameters.
     */
    @SerializedName("action")
    private Action action;

    public Button() {
    }

    public Button(Action action) {
        this.action = action;
    }

    public Button(ButtonColor color, Action action) {
        this.color = color;
        this.action = action;
    }

    /**
     * Describes possible button colors.
     * {@link ButtonColor#PRIMARY}
     * {@link ButtonColor#SECONDARY}
     * {@link ButtonColor#POSITIVE}
     * {@link ButtonColor#NEGATIVE}
     */
    public enum ButtonColor {
        /**
         * Blue button, indicates the main action. #5181B8
         */
        @SerializedName("primary") PRIMARY,
        /**
         * Default white button. #FFFFFF
         */
        @SerializedName("secondary") SECONDARY,
        /**
         * Dangerous or negative action (cancel, delete etc.) #E64646
         */
        @SerializedName("negative") NEGATIVE,
        /**
         * Accept, agree. #4BB34B
         */
        @SerializedName("positive") POSITIVE
    }

    /**
     * Describes button action.
     */
    public abstract static class Action {
        /**
         * Button type.
         */
        @SerializedName("type")
        private String type;

        /**
         * Additional information.
         */
        @SerializedName("payload")
        private JsonElement payload;

        public Action(String type) {
            this.type = type;
        }

        public String getType() {
            return type;
        }

        public JsonElement getPayload() {
            return payload;
        }

        public Action setPayload(JsonElement payload) {
            this.payload = payload;
            return this;
        }
    }

    /**
     * Describes action for button type of location.
     */
    public static class LocationAction extends Action {
        /**
         * Button type.
         */
        private static final String TYPE = "location";

        public LocationAction() {
            super(TYPE);
        }
    }

    /**
     * Describes action for button type of text.
     */
    public static class TextAction extends Action {
        /**
         * Button type.
         */
        private static final String TYPE = "text";

        /**
         * Button text.
         */
        @SerializedName("label")
        private String label;

        public TextAction(String label) {
            this();
            this.label = label;
        }

        public TextAction(String label, JsonElement payload) {
            this(label);
            setPayload(payload);
        }

        public TextAction() {
            super(TYPE);
        }

        public String getLabel() {
            return label;
        }

        public TextAction setLabel(String label) {
            this.label = label;
            return this;
        }

        @Override
        public String toString() {
            return "TextAction{" +
                    "type='" + getType() + '\'' +
                    ", payload='" + getPayload() + '\'' +
                    ", label='" + label + '\'' +
                    '}';
        }
    }

    /**
     * Describes action for button type of location.
     */
    public static class VKAppsAction extends Action {
        /**
         * Button type.
         */
        private static final String TYPE = "vkpay";

        /**
         * Id of the launched VK Apps application.
         */
        @SerializedName("app_id")
        private int appId;

        /**
         * Id of the community in which the app is installed, if it needs to be opened in that community context.
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

        public VKAppsAction() {
            super(TYPE);
        }

        public int getAppId() {
            return appId;
        }

        public VKAppsAction setAppId(int appId) {
            this.appId = appId;
            return this;
        }

        public int getOwnerId() {
            return ownerId;
        }

        public VKAppsAction setOwnerId(int ownerId) {
            this.ownerId = ownerId;
            return this;
        }

        public String getLabel() {
            return label;
        }

        public VKAppsAction setLabel(String label) {
            this.label = label;
            return this;
        }

        public String getHash() {
            return hash;
        }

        public VKAppsAction setHash(String hash) {
            this.hash = hash;
            return this;
        }

        @Override
        public String toString() {
            return "VKAppsAction{" +
                    "type='" + getType() + '\'' +
                    ", payload='" + getPayload() + '\'' +
                    ", appId=" + appId +
                    ", ownerId=" + ownerId +
                    ", label='" + label + '\'' +
                    ", hash='" + hash + '\'' +
                    '}';
        }
    }

    /**
     * Describes action for button type of location.
     */
    public static class VKPayAction extends Action {
        /**
         * Button type.
         */
        private static final String TYPE = "vkpay";

        /**
         * A string containing VK Pay payment parameters and the id of the app in the aid parameter, separated by &. Example: action=transfer-to-group&group_id=1&aid=10
         */
        @SerializedName("hash")
        private String hash;

        public VKPayAction() {
            super(TYPE);
        }

        public String getHash() {
            return hash;
        }

        public VKPayAction setHash(String hash) {
            this.hash = hash;
            return this;
        }

        @Override
        public String toString() {
            return "VKPayAction{" +
                    "type='" + getType() + '\'' +
                    ", payload='" + getPayload() + '\'' +
                    ", hash='" + hash + '\'' +
                    '}';
        }
    }

    /**
     * Describes action for button type of callback.
     */
    public static class CallbackAction extends Action {
        /**
         * Button type.
         */
        private static final String TYPE = "callback";

        /**
         * Button text.
         */
        @SerializedName("label")
        private String label;

        public CallbackAction(String label) {
            this();
            this.label = label;
        }

        public CallbackAction() {
            super(TYPE);
        }

        public String getLabel() {
            return label;
        }

        public CallbackAction setLabel(String label) {
            this.label = label;
            return this;
        }

        @Override
        public String toString() {
            return "CallbackAction{" +
                    "type='" + getType() + '\'' +
                    ", payload='" + getPayload() + '\'' +
                    ", label='" + label + '\'' +
                    '}';
        }
    }

    /**
     * An object of the action that should occur after clicking the button.
     */
    public static abstract class EventData {
        /**
         * Action type.
         */
        @SerializedName("type")
        private String type;

        public EventData(String type) {
            this.type = type;
        }

        public String getType() {
            return type;
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
     * To show disappearing message.
     */
    public static class ShowSnackbar extends EventData {
        /**
         * Action type.
         */
        private static final String TYPE = "show_snackbar";

        /**
         * Text to display.
         */
        @SerializedName("text")
        private String text;

        public ShowSnackbar(String text) {
            this();
            this.text = text;
        }

        public ShowSnackbar() {
            super(TYPE);
        }

        public String getText() {
            return text;
        }

        public ShowSnackbar setText(String text) {
            this.text = text;
            return this;
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
         * Action type.
         */
        private static final String TYPE = "open_link";

        /**
         * A link to be opened.
         */
        @SerializedName("link")
        private String link;

        public OpenLink(String link) {
            this();
            this.link = link;
        }

        public OpenLink() {
            super(TYPE);
        }

        public String getLink() {
            return link;
        }

        public OpenLink setLink(String link) {
            this.link = link;
            return this;
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
         * Action type.
         */
        private static final String TYPE = "open_app";

        /**
         * Application ID.
         */
        @SerializedName("app_id")
        private Integer appId;

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

        public OpenApp() {
            super(TYPE);
        }

        public Integer getAppId() {
            return appId;
        }

        public OpenApp setAppId(Integer appId) {
            this.appId = appId;
            return this;
        }

        public String getHash() {
            return hash;
        }

        public OpenApp setHash(String hash) {
            this.hash = hash;
            return this;
        }

        public Integer getOwnerId() {
            return ownerId;
        }

        public OpenApp setOwnerId(Integer ownerId) {
            this.ownerId = ownerId;
            return this;
        }

        public String toJson() {
            return new Gson().toJson(this);
        }

        @Override
        public String toString() {
            return toJson();
        }
    }

    public ButtonColor getColor() {
        return color;
    }

    public Button setColor(ButtonColor color) {
        this.color = color;
        return this;
    }

    public Action getAction() {
        return action;
    }

    public Button setAction(Action action) {
        this.action = action;
        return this;
    }

    public String toJson() {
        return new Gson().toJson(this);
    }

    @Override
    public String toString() {
        return toJson();
    }
}