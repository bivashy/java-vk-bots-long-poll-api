package api.longpoll.bots.model.response.groups;

import com.google.gson.annotations.SerializedName;

public class GroupsAddCallbackServerResult {
	@SerializedName("response")
	private Response response;

	public static class Response {
		@SerializedName("server_id")
		private Integer serverId;

		public Integer getServerId() {
			return serverId;
		}

		public void setServerId(Integer serverId) {
			this.serverId = serverId;
		}
	}

	public Response getResponse() {
		return response;
	}

	public void setResponse(Response response) {
		this.response = response;
	}
}
