package api.longpoll.bots.model.objects.additional.buttons;

import com.google.gson.JsonElement;
import com.google.gson.annotations.SerializedName;

/**
 * A button to open a link.
 */
public class OpenLinkButton extends Button {
    public OpenLinkButton(Action action) {
        super(action);
    }

    /**
     * Describes action for button type of Open link.
     */
    public static class Action extends Button.Action {
        /**
         * A link to be opened.
         */
        @SerializedName("link")
        private String link;

        /**
         * Button text.
         */
        @SerializedName("label")
        private String label;

        public Action(String link, String label) {
            this(link, label, null);
        }

        public Action(String link, String label, JsonElement payload) {
            super("open_link", payload);
            this.link = link;
            this.label = label;
        }

        public String getLink() {
            return link;
        }

        public void setLink(String link) {
            this.link = link;
        }

        public String getLabel() {
            return label;
        }

        public void setLabel(String label) {
            this.label = label;
        }

        @Override
        public String toString() {
            return "Action{" +
                    "link='" + link + '\'' +
                    ", label='" + label + '\'' +
                    "} " + super.toString();
        }
    }
}
