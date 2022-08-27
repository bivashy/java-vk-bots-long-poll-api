package api.longpoll.bots.model.objects.media;

import com.google.gson.JsonElement;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Describes Event object.
 */
public class Event {
    @SerializedName("button_text")
    private String buttonText;

    @SerializedName("id")
    private Integer id;

    @SerializedName("is_favorite")
    private boolean favorite;

    @SerializedName("text")
    private String text;

    @SerializedName("address")
    private String address;

    @SerializedName("friends")
    private List<JsonElement> friends;

    @SerializedName("member_status")
    private Integer memberStatus;

    @SerializedName("time")
    private Integer time;

    public String getButtonText() {
        return buttonText;
    }

    public void setButtonText(String buttonText) {
        this.buttonText = buttonText;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean isFavorite() {
        return favorite;
    }

    public void setFavorite(boolean favorite) {
        this.favorite = favorite;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<JsonElement> getFriends() {
        return friends;
    }

    public void setFriends(List<JsonElement> friends) {
        this.friends = friends;
    }

    public Integer getMemberStatus() {
        return memberStatus;
    }

    public void setMemberStatus(Integer memberStatus) {
        this.memberStatus = memberStatus;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Event{" +
                "buttonText='" + buttonText + '\'' +
                ", id=" + id +
                ", favorite=" + favorite +
                ", text='" + text + '\'' +
                ", address='" + address + '\'' +
                ", friends=" + friends +
                ", memberStatus=" + memberStatus +
                ", time=" + time +
                '}';
    }
}
