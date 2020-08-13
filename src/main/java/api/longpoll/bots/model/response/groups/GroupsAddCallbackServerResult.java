package api.longpoll.bots.model.response.groups;

import com.google.gson.annotations.SerializedName;

public class GroupsAddCallbackServerResult {
	@SerializedName("response")
	private Response response;

	public Response getResponse() {
		return response;
	}

	public GroupsAddCallbackServerResult setResponse(Response response) {
		this.response = response;
		return this;
	}

	public class Response {
		@SerializedName("server_id")
		private Integer serverId;

		public Integer getServerId() {
			return serverId;
		}

		public Response setServerId(Integer serverId) {
			this.serverId = serverId;
			return this;
		}
	}
}
