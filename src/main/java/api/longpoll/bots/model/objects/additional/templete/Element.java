package api.longpoll.bots.model.objects.additional.templete;

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
    private ElementAction elementAction;



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

    public ElementAction getElementAction() {
        return elementAction;
    }

    public Element setElementAction(ElementAction elementAction) {
        this.elementAction = elementAction;
        return this;
    }

    @Override
    public String toString() {
        return "Element{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", photoId='" + photoId + '\'' +
                ", buttons=" + buttons +
                ", action=" + elementAction +
                '}';
    }
}
