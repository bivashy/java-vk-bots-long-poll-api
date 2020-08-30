package api.longpoll.bots.model.response.groups;

import com.google.gson.annotations.SerializedName;

/**
 * Response to <b>groups.addCallbackServer</b> request.
 */
public class GroupsAddCallbackServerResult {
	/**
	 * Response object.
	 */
	@SerializedName("response")
	private Response response;

	/**
	 * Describes response object.
	 */
	public static class Response {
		/**
		 * Server ID.
		 */
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
