package api.longpoll.bots.model.response.messages;

import com.google.gson.annotations.SerializedName;

public class MessagesSendResult {
	@SerializedName("response")
	private Object response;

	public Object getResponse() {
		return response;
	}

	public MessagesSendResult setResponse(Object response) {
		this.response = response;
		return this;
	}

	public class Response {
		@SerializedName("peer_id")
		private Integer peerId;
		@SerializedName("message_id")
		private Integer messageId;
		@SerializedName("error")
		private String error;

		public Integer getPeerId() {
			return peerId;
		}

		public Response setPeerId(Integer peerId) {
			this.peerId = peerId;
			return this;
		}

		public Integer getMessageId() {
			return messageId;
		}

		public Response setMessageId(Integer messageId) {
			this.messageId = messageId;
			return this;
		}

		public String getError() {
			return error;
		}

		public Response setError(String error) {
			this.error = error;
			return this;
		}
	}
}
