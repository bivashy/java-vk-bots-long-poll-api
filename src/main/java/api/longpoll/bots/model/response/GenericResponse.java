package api.longpoll.bots.model.response;

import com.google.gson.annotations.SerializedName;

/**
 * Generic response which contains only one field.
 *
 * @param <T> field type.
 */
public class GenericResponse<T> {
    /**
     * Response object.
     */
    @SerializedName("response")
    private T responseObject;

    public T getResponseObject() {
        return responseObject;
    }

    public void setResponseObject(T responseObject) {
        this.responseObject = responseObject;
    }


    @Override
    public String toString() {
        return "GenericResponse{" +
                "responseObject=" + responseObject +
                '}';
    }
}
