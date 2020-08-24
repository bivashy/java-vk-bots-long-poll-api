package api.longpoll.bots.methods.docs;

import api.longpoll.bots.LongPollBot;
import api.longpoll.bots.converters.JsonToPojoConverter;
import api.longpoll.bots.converters.response.docs.DocsSaveResultConverterImpl;
import api.longpoll.bots.methods.GetMethod;
import api.longpoll.bots.methods.VkApi;
import api.longpoll.bots.model.response.docs.DocsSaveResult;
import org.jsoup.Connection;

import java.util.stream.Stream;

public class DocsSave extends GetMethod<DocsSaveResult> {
	private String file;
	private String title;
	private String tags;
	private Boolean returnTags;

	public DocsSave(LongPollBot bot) {
		super(bot);
	}

	@Override
	protected String getApi() {
		return VkApi.getInstance().docsSave();
	}

	@Override
	protected JsonToPojoConverter<DocsSaveResult> getConverter() {
		return new DocsSaveResultConverterImpl();
	}

	@Override
	protected Stream<Connection.KeyVal> getKeyValStream() {
		return Stream.of(
				keyVal("file", file),
				keyVal("title", title),
				keyVal("tags", tags),
				keyVal("return_tags", returnTags, true)
		);
	}

	public String getFile() {
		return file;
	}

	public DocsSave setFile(String file) {
		this.file = file;
		return this;
	}

	public String getTitle() {
		return title;
	}

	public DocsSave setTitle(String title) {
		this.title = title;
		return this;
	}

	public String getTags() {
		return tags;
	}

	public DocsSave setTags(String tags) {
		this.tags = tags;
		return this;
	}

	public Boolean getReturnTags() {
		return returnTags;
	}

	public DocsSave setReturnTags(Boolean returnTags) {
		this.returnTags = returnTags;
		return this;
	}
}
