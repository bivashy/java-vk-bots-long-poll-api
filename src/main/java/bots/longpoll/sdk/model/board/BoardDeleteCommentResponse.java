package bots.longpoll.sdk.model.board;

import com.google.gson.annotations.SerializedName;

public class BoardDeleteCommentResponse {
	@SerializedName("response")
	private Integer response;


	public Integer getResponse() {
		return response;
	}

	public BoardDeleteCommentResponse setResponse(Integer response) {
		this.response = response;
		return this;
	}
}
