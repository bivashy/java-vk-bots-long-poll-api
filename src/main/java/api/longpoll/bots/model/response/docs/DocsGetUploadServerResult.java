package api.longpoll.bots.model.response.docs;

import com.google.gson.annotations.SerializedName;

public class DocsGetUploadServerResult {
	@SerializedName("response")
	private Response response;

	public class Response {
		@SerializedName("upload_url")
		private String uploadUrl;

		public String getUploadUrl() {
			return uploadUrl;
		}

		public Response setUploadUrl(String uploadUrl) {
			this.uploadUrl = uploadUrl;
			return this;
		}
	}

	public Response getResponse() {
		return response;
	}

	public DocsGetUploadServerResult setResponse(Response response) {
		this.response = response;
		return this;
	}
}
