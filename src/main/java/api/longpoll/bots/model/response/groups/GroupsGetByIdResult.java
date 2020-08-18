package api.longpoll.bots.model.response.groups;

import api.longpoll.bots.model.objects.basic.Community;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GroupsGetByIdResult {
    @SerializedName("response")
    private List<Community> communities;

    public List<Community> getCommunities() {
        return communities;
    }

    public GroupsGetByIdResult setCommunities(List<Community> communities) {
        this.communities = communities;
        return this;
    }
}
