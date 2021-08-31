package api.longpoll.bots.model.objects.additional.buttons.actions;

import com.google.gson.JsonElement;
import com.google.gson.annotations.SerializedName;

/**
 * Action to open a link.
 */
public class OpenLink extends ButtonAction {
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


    public OpenLink(String link, String label) {
        this(link, label, null);
    }

    public OpenLink(String link, String label, JsonElement payload) {
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
        return "ButtonOpenLink{" +
                "link='" + link + '\'' +
                ", label='" + label + '\'' +
                "} " + super.toString();
    }
}
