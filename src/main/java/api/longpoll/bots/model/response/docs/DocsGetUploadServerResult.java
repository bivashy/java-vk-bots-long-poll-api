package api.longpoll.bots.model.response.docs;

import com.google.gson.annotations.SerializedName;

/**
 * Response to <b>docs.getUploadServer</b> request.
 */
public class DocsGetUploadServerResult {
	/**
	 * Response object.
	 */
	@SerializedName("response")
	private Response response;

	/**
	 * Describes response object.
	 */
	public class Response {
		/**
		 * Link to which the document can be uploaded.
		 */
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
