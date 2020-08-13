package api.longpoll.bots.model.response.other;

import com.google.gson.annotations.SerializedName;

public class IntegerResult {
	@SerializedName("response")
	private Integer response;

	public Integer getResponse() {
		return response;
	}

	public IntegerResult setResponse(Integer response) {
		this.response = response;
		return this;
	}
}
