package api.longpoll.bots.model.response.docs;

import api.longpoll.bots.model.objects.media.Doc;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DocsSearchResult {
	@SerializedName("response")
	private Response response;

	public class Response {
		@SerializedName("count")
		private Integer count;
		@SerializedName("items")
		List<Doc> items;

		public Integer getCount() {
			return count;
		}

		public Response setCount(Integer count) {
			this.count = count;
			return this;
		}

		public List<Doc> getItems() {
			return items;
		}

		public Response setItems(List<Doc> items) {
			this.items = items;
			return this;
		}
	}

	public Response getResponse() {
		return response;
	}

	public DocsSearchResult setResponse(Response response) {
		this.response = response;
		return this;
	}
}
