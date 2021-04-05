package api.longpoll.bots.model.objects.additional;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Marks special message.
 */
public abstract class Template {
    /**
     * Type of message.
     */
    @SerializedName("type")
    private String type;

    public Template(String type) {
        this.type = type;
    }

    /**
     * Describes carousel template.
     */
    public static class Carousel extends Template {
        /**
         * Type of templete.
         */
        private static final String TYPE = "carousel";

        /**
         * A list of carousel elements.
         */
        @SerializedName("elements")
        private List<Element> elements;

        public Carousel() {
            super(TYPE);
        }

        /**
         * Describes carousel element.
         */
        public static class Element {
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
            private String photoId;

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
                private String type;

                public Action(String type) {
                    this.type = type;
                }

                public String getType() {
                    return type;
                }
            }

            /**
             * Opens a link from the "link" field.
             */
            public static class OpenLink extends Action {
                /**
                 * Type of action.
                 */
                private static final String TYPE = "open_link";

                /**
                 * Link to be opened.
                 */
                @SerializedName("link")
                private String link;

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

                @Override
                public String toString() {
                    return "OpenLink{" +
                            "type='" + getType() + '\'' +
                            ", link='" + link + '\'' +
                            '}';
                }
            }

            /**
             * Opens an image from the current carousel element.
             */
            public static class OpenPhoto extends Action {
                /**
                 * Type of action.
                 */
                private static final String TYPE = "open_photo";

                public OpenPhoto() {
                    super(TYPE);
                }

                @Override
                public String toString() {
                    return "OpenPhoto{" +
                            "type='" + getType() + '\'' +
                            '}';
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

            public String getPhotoId() {
                return photoId;
            }

            public Element setPhotoId(String photoId) {
                this.photoId = photoId;
                return this;
            }

            public List<Button> getButtons() {
                return buttons;
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

        public List<Element> getElements() {
            return elements;
        }

        public Carousel setElements(List<Element> elements) {
            this.elements = elements;
            return this;
        }

        @Override
        public String toString() {
            return "Carousel{" +
                    "type='" + getType() + '\'' +
                    ", elements=" + elements +
                    '}';
        }
    }

    public String toJson() {
        return new Gson().toJson(this);
    }

    @Override
    public String toString() {
        return toJson();
    }

    public String getType() {
        return type;
    }
}
