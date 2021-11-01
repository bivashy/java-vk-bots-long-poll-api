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

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Country{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}