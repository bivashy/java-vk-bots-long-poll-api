package api.longpoll.bots.model.objects.additional;

import com.google.gson.annotations.SerializedName;

/**
 * Describes currency.
 */
public class Currency {
    /**
     * Currency ID.
     */
    @SerializedName("id")
    private Integer id;

    /**
     * Currency letter.
     */
    @SerializedName("name")
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Currency{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}