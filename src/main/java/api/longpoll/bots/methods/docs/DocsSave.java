package api.longpoll.bots.methods.docs;

import api.longpoll.bots.methods.VkApiGetMethod;
import api.longpoll.bots.methods.VkApiProperties;
import api.longpoll.bots.model.response.docs.DocsSaveResult;
import org.jsoup.Connection;

import java.util.stream.Stream;

/**
 * Implements <b>docs.save</b> method.
 *
 * @see <a href="https://vk.com/dev/docs.save">https://vk.com/dev/docs.save</a>
 */
public class DocsSave extends VkApiGetMethod<DocsSaveResult> {
    /**
     * This parameter is returned when the file is uploaded to the server.
     */
    private String file;

    /**
     * Document title.
     */
    private String title;

    /**
     * Document tags.
     */
    private String tags;

    /**
     * <b>true</b> if flags should be returned.
     */
    private Boolean returnTags;

    public DocsSave(String accessToken) {
        super(accessToken);
    }

    @Override
    protected String getApi() {
        return VkApiProperties.get("docs.save");
    }

    @Override
    protected Stream<Connection.KeyVal> getParamsStream() {
        return Stream.of(
                keyVal("file", file),
                keyVal("title", title),
                keyVal("tags", tags),
                keyVal("return_tags", returnTags, true)
        );
    }

    @Override
    protected Class<? extends DocsSaveResult> getResultType() {
        return DocsSaveResult.class;
    }

    public DocsSave setFile(String file) {
        this.file = file;
        return this;
    }

    public DocsSave setTitle(String title) {
        this.title = title;
        return this;
    }

    public DocsSave setTags(String tags) {
        this.tags = tags;
        return this;
    }

    public DocsSave setReturnTags(Boolean returnTags) {
        this.returnTags = returnTags;
        return this;
    }
}
