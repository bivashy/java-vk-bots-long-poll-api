package api.longpoll.bots.model.objects.additional.templete;

import com.google.gson.annotations.SerializedName;

/**
 * Describes carousel action.
 */
public abstract class ElementAction {
    /**
     * Carousel action type.
     */
    @SerializedName("type")
    private String type;

    public ElementAction(String type) {
        this.type = type;
    }

    /**
     * Opens a link from the "link" field.
     */
    public static class OpenLink extends ElementAction {
        /**
         * Link to be opened.
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


        @Override
        public String toString() {
            return "OpenLink{" +
                    "link='" + link + '\'' +
                    "} " + super.toString();
        }
    }

    /**
     * Opens an image from the current carousel element.
     */
    public static class OpenPhoto extends ElementAction {
        public OpenPhoto() {
            super("open_photo");
        }
    }

    @Override
    public String toString() {
        return "ElementAction{" +
                "type='" + type + '\'' +
                '}';
    }
}
