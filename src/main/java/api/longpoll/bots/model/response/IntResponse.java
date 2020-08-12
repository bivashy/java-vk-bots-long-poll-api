package api.longpoll.bots.model.response;

import com.google.gson.annotations.SerializedName;

public class IntResponse {
	@SerializedName("response")
	private Integer response;

	public Integer getResponse() {
		return response;
	}

	public IntResponse setResponse(Integer response) {
		this.response = response;
		return this;
	}
}
