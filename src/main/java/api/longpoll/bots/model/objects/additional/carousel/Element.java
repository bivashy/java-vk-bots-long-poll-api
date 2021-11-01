package api.longpoll.bots.model.objects.additional.carousel;

import api.longpoll.bots.model.objects.additional.buttons.Button;
import com.google.gson.annotations.SerializedName;

import java.util.Arrays;
import java.util.List;

/**
 * Describes carousel element.
 */
public class Element {
    /**
     * Title, maximum 80 characters.
     */
    @SerializedName("title")
    private String title;

    /**
     * Subtitle, maximum 80 characters.
     */
    @SerializedName("description")
    private String description;

    /**
     * ID of an image that needs to be attached.
     */
    @SerializedName("photo_id")
    private Integer photoId;

    /**
     * List of buttons. One carousel element can contain up to 3 buttons.
     */
    @SerializedName("buttons")
    private List<Button> buttons;

    /**
     * An object describing the action that needs to happen after a carousel element is clicked.
     */
    @SerializedName("action")
    private Action action;

    /**
     * Describes carousel action.
     */
    public static abstract class Action {
        /**
         * Carousel action type.
         */
        @SerializedName("type")
        private final String type;

        public Action(String type) {
            this.type = type;
        }

        @Override
        public String toString() {
            return "Action{" +
                    "type='" + type + '\'' +
                    '}';
        }
    }

    /**
     * Opens a link from the "link" field.
     */
    public static class OpenLink extends Action {
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
    public static class OpenPhoto extends Action {
        public OpenPhoto() {
            super("open_photo");
        }
    }

    public String getTitle() {
        return title;
    }

    public Element setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Element setDescription(String description) {
        this.description = description;
        return this;
    }

    public Integer getPhotoId() {
        return photoId;
    }

    public Element setPhotoId(Integer photoId) {
        this.photoId = photoId;
        return this;
    }

    public List<Button> getButtons() {
        return buttons;
    }

    public Element setButtons(Button... buttons) {
        return setButtons(Arrays.asList(buttons));
    }

    public Element setButtons(List<Button> buttons) {
        this.buttons = buttons;
        return this;
    }

    public Action getAction() {
        return action;
    }

    public Element setAction(Action action) {
        this.action = action;
        return this;
    }

    @Override
    public String toString() {
        return "Element{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", photoId='" + photoId + '\'' +
                ", buttons=" + buttons +
                ", action=" + action +
                '}';
    }
}
