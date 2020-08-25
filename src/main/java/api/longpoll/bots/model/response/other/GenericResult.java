package api.longpoll.bots.model.response.other;

import com.google.gson.annotations.SerializedName;

public class GenericResult<T> {
    @SerializedName("response")
    private T response;

    public T getResponse() {
        return response;
    }

    public void setResponse(T response) {
        this.response = response;
    }
}
