package api.longpoll.bots.methods.docs;

import api.longpoll.bots.LongPollBot;
import api.longpoll.bots.converters.GenericConverterFactory;
import api.longpoll.bots.converters.JsonToPojoConverter;
import api.longpoll.bots.methods.GetMethod;
import api.longpoll.bots.methods.VkApi;
import api.longpoll.bots.model.response.docs.DocsSearchResult;

public class DocsSearch extends GetMethod<DocsSearchResult> {
	private static final String Q = "q";
	private static final String COUNT = "count";
	private static final String OFFSET = "offset";
	private static final String RETURN_TAGS = "return_tags";

	public DocsSearch(LongPollBot bot) {
		super(bot);
	}

	public DocsSearch setQ(String q) {
		params.put(Q, q);
		return this;
	}

	public String getQ() {
		return (String) params.get(Q);
	}

	public DocsSearch setCount(int count) {
		params.put(COUNT, count);
		return this;
	}

	public int getCount() {
		return (int) params.get(COUNT);
	}

	public DocsSearch setOffset(int offset) {
		params.put(OFFSET, offset);
		return this;
	}

	public int getOffset() {
		return (int) params.get(OFFSET);
	}

	public DocsSearch setReturnTags(boolean returnTags) {
		params.put(RETURN_TAGS, returnTags ? 1 : 0);
		return this;
	}

	public boolean getReturnTags() {
		return (int) params.get(RETURN_TAGS) == 1;
	}
	@Override
	protected String getApi() {
		return VkApi.Docs.SEARCH;
	}

	@Override
	protected JsonToPojoConverter<DocsSearchResult> getConverter() {
		return GenericConverterFactory.get(DocsSearchResult.class);
	}
}
