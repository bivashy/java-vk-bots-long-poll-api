package api.longpoll.bots.model.response.groups;

import com.google.gson.annotations.SerializedName;

public class GroupsGetLongPollServerResult {
	@SerializedName("response")
	private Response response;

	public static class Response {
		@SerializedName("key")
		private String key;
		@SerializedName("server")
		private String server;
		@SerializedName("ts")
		private Integer ts;

		public String getKey() {
			return key;
		}

		public void setKey(String key) {
			this.key = key;
		}

		public String getServer() {
			return server;
		}

		public void setServer(String server) {
			this.server = server;
		}

		public Integer getTs() {
			return ts;
		}

		public void setTs(Integer ts) {
			this.ts = ts;
		}
	}

	public Response getResponse() {
		return response;
	}

	public void setResponse(Response response) {
		this.response = response;
	}
}
