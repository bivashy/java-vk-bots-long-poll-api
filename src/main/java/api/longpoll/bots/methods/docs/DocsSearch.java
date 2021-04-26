package api.longpoll.bots.methods.docs;

import api.longpoll.bots.methods.GetMethod;
import api.longpoll.bots.methods.VkApi;
import api.longpoll.bots.model.response.docs.DocsSearchResult;
import org.jsoup.Connection;

import java.util.stream.Stream;

/**
 * Implements <b>docs.search</b> method.
 *
 * @see <a href="https://vk.com/dev/docs.search">https://vk.com/dev/docs.search</a>
 */
public class DocsSearch extends GetMethod<DocsSearchResult> {
    /**
     * Search query.
     */
    private String q;

    /**
     * Number of results to return.
     */
    private Integer count;

    /**
     * Offset needed to return a specific subset of results.
     */
    private Integer offset;

    /**
     * <b>true</b> if flags should be returned.
     */
    private Boolean returnTags;

    public DocsSearch(String accessToken) {
        super(accessToken);
    }

    @Override
    protected String getApi() {
        return VkApi.getInstance().docsSearch();
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

    @Override
    protected Class<? extends DocsSearchResult> getResultType() {
        return DocsSearchResult.class;
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
