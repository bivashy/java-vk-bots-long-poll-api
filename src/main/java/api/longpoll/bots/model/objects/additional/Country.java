package api.longpoll.bots.model.objects.additional;

import com.google.gson.annotations.SerializedName;

/**
 * Describes country objects.
 */
public class Country {
    /**
     * Country ID.
     */
    @SerializedName("id")
    private Integer id;

    /**
     * Country name.
     */
    @SerializedName("title")
    private String title;

    public Integer getId() {
        return id;
    }

    public Country setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Country setTitle(String title) {
        this.title = title;
        return this;
    }
}