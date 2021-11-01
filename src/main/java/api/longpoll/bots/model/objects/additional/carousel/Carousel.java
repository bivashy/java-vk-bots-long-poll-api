package api.longpoll.bots.model.objects.additional.carousel;

import api.longpoll.bots.model.objects.additional.Template;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

import java.util.Arrays;
import java.util.List;

/**
 * Describes carousel template.
 */
public class Carousel extends Template {
    /**
     * A list of carousel elements.
     */
    @SerializedName("elements")
    private List<Element> elements;

    public Carousel(Element... elements) {
        this(Arrays.asList(elements));
    }

    public Carousel(List<Element> elements) {
        super("carousel");
        this.elements = elements;
    }

    public List<Element> getElements() {
        return elements;
    }

    public void setElements(List<Element> elements) {
        this.elements = elements;
    }

    public String toJson() {
        return new Gson().toJson(this);
    }

    @Override
    public String toString() {
        return toJson();
    }
}
