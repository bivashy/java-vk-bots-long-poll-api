package api.longpoll.bots.model.response.docs;

import api.longpoll.bots.model.objects.media.Attachable;
import com.google.gson.annotations.SerializedName;

public class DocsSaveResult {
	@SerializedName("response")
	private Response response;

	public class Response {
		@SerializedName("type")
		private String type;
		private Attachable attachable;

		public String getType() {
			return type;
		}

		public Response setType(String type) {
			this.type = type;
			return this;
		}

		public Attachable getAttachable() {
			return attachable;
		}

		public Response setAttachable(Attachable attachable) {
			this.attachable = attachable;
			return this;
		}
	}

	public Response getResponse() {
		return response;
	}

	public DocsSaveResult setResponse(Response response) {
		this.response = response;
		return this;
	}
}

// TODO: 13.08.2020 update according to https://vk.com/dev/docs.save
