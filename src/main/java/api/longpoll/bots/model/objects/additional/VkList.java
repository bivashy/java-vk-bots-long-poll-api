package api.longpoll.bots.model.objects.additional;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Describes VK list.
 *
 * @see <a href="https://vk.com/dev/list">Lists</a>
 */
public class VkList<T> {
    /**
     * The total number of elements.
     */
    @SerializedName("count")
    private Integer count;

    /**
     * List of element objects.
     */
    @SerializedName("items")
    private List<T> items;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "VkList{" +
                "count=" + count +
                ", items=" + items +
                '}';
    }
}
