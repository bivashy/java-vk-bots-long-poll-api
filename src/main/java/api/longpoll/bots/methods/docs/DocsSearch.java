package api.longpoll.bots.methods.docs;

import api.longpoll.bots.LongPollBot;
import api.longpoll.bots.converters.GenericConverterFactory;
import api.longpoll.bots.converters.JsonToPojoConverter;
import api.longpoll.bots.methods.GetMethod;
import api.longpoll.bots.methods.VkApi;
import api.longpoll.bots.model.objects.additional.VkList;
import api.longpoll.bots.model.objects.media.Doc;
import com.google.gson.reflect.TypeToken;
import org.jsoup.Connection;

import java.util.stream.Stream;

public class DocsSearch extends GetMethod<VkList<Doc>> {
	private String q;
	private Integer count;
	private Integer offset;
	private Boolean returnTags;

	public DocsSearch(LongPollBot bot) {
		super(bot);
	}

	@Override
	protected String getApi() {
		return VkApi.getInstance().docsSearch();
	}

	@Override
	protected JsonToPojoConverter<VkList<Doc>> getConverter() {
		return GenericConverterFactory.get(new TypeToken<VkList<Doc>>(){}.getType());
	}

	@Override
	protected Stream<Connection.KeyVal> getKeyValStream() {
		return Stream.of(
				keyVal("q", q),
				keyVal("count", count),
				keyVal("offset", offset),
				keyVal("return_tags", returnTags, true)
		);
	}

	public String getQ() {
		return q;
	}

	public DocsSearch setQ(String q) {
		this.q = q;
		return this;
	}

	public Integer getCount() {
		return count;
	}

	public DocsSearch setCount(Integer count) {
		this.count = count;
		return this;
	}

	public Integer getOffset() {
		return offset;
	}

	public DocsSearch setOffset(Integer offset) {
		this.offset = offset;
		return this;
	}

	public Boolean getReturnTags() {
		return returnTags;
	}

	public DocsSearch setReturnTags(Boolean returnTags) {
		this.returnTags = returnTags;
		return this;
	}
}
