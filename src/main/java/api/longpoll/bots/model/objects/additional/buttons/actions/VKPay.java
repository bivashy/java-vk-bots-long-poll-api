package api.longpoll.bots.model.objects.additional.buttons.actions;

import com.google.gson.JsonElement;
import com.google.gson.annotations.SerializedName;

/**
 * Describes action for button type of VK Pay.
 */
public class VKPay extends ButtonAction {
    /**
     * A string containing VK Pay payment parameters and the id of the app in the aid parameter, separated by &.
     * Example: action=transfer-to-group&group_id=1&aid=10
     */
    @SerializedName("hash")
    private String hash;

    public VKPay(String hash) {
        this(hash, null);
    }

    public VKPay(String hash, JsonElement payload) {
        super("vkpay", payload);
        this.hash = hash;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    @Override
    public String toString() {
        return "VKPay{" +
                "hash='" + hash + '\'' +
                "} " + super.toString();
    }
}
