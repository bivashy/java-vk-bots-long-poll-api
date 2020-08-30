package api.longpoll.bots.methods.docs;

import api.longpoll.bots.LongPollBot;
import api.longpoll.bots.converters.GenericConverterFactory;
import api.longpoll.bots.converters.JsonToPojoConverter;
import api.longpoll.bots.methods.GetMethod;
import api.longpoll.bots.methods.VkApi;
import api.longpoll.bots.model.response.docs.DocsGetUploadServerResult;
import org.jsoup.Connection;

import java.util.stream.Stream;

/**
* Implements <b>docs.getWallUploadServer</b> method.
* @see <a href="https://vk.com/dev/docs.getWallUploadServer">https://vk.com/dev/docs.getWallUploadServer</a>
*/
public class DocsGetWallUploadServer extends GetMethod<DocsGetUploadServerResult> {
	/**
	 * Community ID
	 */
	private Integer groupId;

	public DocsGetWallUploadServer(LongPollBot bot) {
		super(bot);
	}

	/**
	* {@inheritDoc}
	*/
	@Override
	protected String getApi() {
		return VkApi.getInstance().docsGetWallUploadServer();
	}

	/**
	* {@inheritDoc}
	*/
	@Override
	protected JsonToPojoConverter<DocsGetUploadServerResult> getConverter() {
		return GenericConverterFactory.get(DocsGetUploadServerResult.class);
	}

	/**
	* {@inheritDoc}
	*/
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
