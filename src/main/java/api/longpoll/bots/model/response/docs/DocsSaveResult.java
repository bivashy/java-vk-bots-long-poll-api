package api.longpoll.bots.model.response.docs;

import api.longpoll.bots.model.document.Document;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DocsSaveResult {
	@SerializedName("response")
	private List<Response> responses;

	public List<Response> getResponses() {
		return responses;
	}

	public DocsSaveResult setResponses(List<Response> responses) {
		this.responses = responses;
		return this;
	}

	public class Response {
		@SerializedName("type")
		private String type;
		@SerializedName("doc")
		private Document object;

		public String getType() {
			return type;
		}

		public Response setType(String type) {
			this.type = type;
			return this;
		}

		public Document getObject() {
			return object;
		}

		public Response setObject(Document object) {
			this.object = object;
			return this;
		}
	}
}

// TODO: 13.08.2020 update according to https://vk.com/dev/docs.save
