package api.longpoll.bots.model.response.docs;

import api.longpoll.bots.model.objects.additional.VkList;
import api.longpoll.bots.model.objects.media.Doc;
import com.google.gson.annotations.SerializedName;

/**
 * Response to <b>docs.search</b> request.
 */
public class DocsSearchResult {
	/**
	 * List of documents.
	 */
	@SerializedName("response")
	private VkList<Doc> docList;

	public VkList<Doc> getDocList() {
		return docList;
	}

	public DocsSearchResult setDocList(VkList<Doc> docList) {
		this.docList = docList;
		return this;
	}
}
