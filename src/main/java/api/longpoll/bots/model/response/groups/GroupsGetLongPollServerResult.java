package api.longpoll.bots.model.response.groups;

import com.google.gson.annotations.SerializedName;

public class GroupsGetLongPollServerResult {
	@SerializedName("response")
	private Response response;

	public Response getResponse() {
		return response;
	}

	public GroupsGetLongPollServerResult setResponse(Response response) {
		this.response = response;
		return this;
	}

	public class Response {
		@SerializedName("key")
		private String key;
		@SerializedName("server")
		private String server;
		@SerializedName("ts")
		private Integer ts;

		public String getKey() {
			return key;
		}

		public Response setKey(String key) {
			this.key = key;
			return this;
		}

		public String getServer() {
			return server;
		}

		public Response setServer(String server) {
			this.server = server;
			return this;
		}

		public Integer getTs() {
			return ts;
		}

		public Response setTs(Integer ts) {
			this.ts = ts;
			return this;
		}
	}
}
