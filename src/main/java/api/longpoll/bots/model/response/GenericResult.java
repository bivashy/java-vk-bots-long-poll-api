package api.longpoll.bots.model.response;

import com.google.gson.annotations.SerializedName;

/**
 * Generic response which contains only one field.
 *
 * @param <T> field type.
 */
public class GenericResult<T> {
    /**
     * Response object.
     */
    @SerializedName("response")
    private T response;

    public T getResponse() {
        return response;
    }

    public void setResponse(T response) {
        this.response = response;
    }
}
