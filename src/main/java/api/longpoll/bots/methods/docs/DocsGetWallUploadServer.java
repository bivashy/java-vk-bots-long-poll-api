package api.longpoll.bots.methods.docs;

import api.longpoll.bots.LongPollBot;
import api.longpoll.bots.converters.GenericConverterFactory;
import api.longpoll.bots.converters.JsonToPojoConverter;
import api.longpoll.bots.methods.GetMethod;
import api.longpoll.bots.methods.VkApi;
import api.longpoll.bots.model.response.docs.DocsGetUploadServerResult;
import org.jsoup.Connection;

import java.util.stream.Stream;

public class DocsGetWallUploadServer extends GetMethod<DocsGetUploadServerResult> {
	private Integer groupId;

	public DocsGetWallUploadServer(LongPollBot bot) {
		super(bot);
	}

	@Override
	protected String getApi() {
		return VkApi.getInstance().docsGetWallUploadServer();
	}

	@Override
	protected JsonToPojoConverter<DocsGetUploadServerResult> getConverter() {
		return GenericConverterFactory.get(DocsGetUploadServerResult.class);
	}

	@Override
	protected Stream<Connection.KeyVal> getKeyValStream() {
		return Stream.of(keyVal("group_id", groupId));
	}

	public Integer getGroupId() {
		return groupId;
	}

	public DocsGetWallUploadServer setGroupId(Integer groupId) {
		this.groupId = groupId;
		return this;
	}
}
