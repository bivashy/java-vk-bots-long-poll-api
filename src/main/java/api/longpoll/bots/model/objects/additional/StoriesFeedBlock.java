package api.longpoll.bots.model.objects.additional;

import api.longpoll.bots.model.objects.basic.Application;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Describes stories feed block.
 *
 * @see <a href="https://vk.com/dev/objects/story_feed_item">Stories feed block</a>
 */
public class StoriesFeedBlock {
    /**
     * Type of feed element. Possible values:
     * <ul>
     *     <li><b>stories</b> — story</li>
     *     <li><b>community_grouped_stories</b> — grouped community stories</li>
     *     <li><b>app_grouped_stories</b> — grouped mini-app stories</li>
     * </ul>
     */
    @SerializedName("type")
    private String type;

    /**
     * List of stories.
     */
    @SerializedName("stories")
    private List<Story> stories;

    /**
     * List of stories feed block objects.
     */
    @SerializedName("grouped")
    private List<StoriesFeedBlock> grouped;

    /**
     * App object.
     */
    @SerializedName("app")
    private Application app;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Story> getStories() {
        return stories;
    }

    public void setStories(List<Story> stories) {
        this.stories = stories;
    }

    public List<StoriesFeedBlock> getGrouped() {
        return grouped;
    }

    public void setGrouped(List<StoriesFeedBlock> grouped) {
        this.grouped = grouped;
    }

    public Application getApp() {
        return app;
    }

    public void setApp(Application app) {
        this.app = app;
    }

    @Override
    public String toString() {
        return "StoriesFeedBlock{" +
                "type='" + type + '\'' +
                ", stories=" + stories +
                ", grouped=" + grouped +
                ", app=" + app +
                '}';
    }
}
