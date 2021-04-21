package api.longpoll.bots.methods.utils;

import api.longpoll.bots.converters.JsonToPojoConverter;
import api.longpoll.bots.converters.JsonToPojoConverterFactory;
import api.longpoll.bots.methods.GetMethod;
import api.longpoll.bots.methods.VkApi;
import api.longpoll.bots.model.response.GenericResult;
import api.longpoll.bots.model.response.utils.UtilsGetLinkStatsResponse;
import com.google.gson.reflect.TypeToken;
import org.jsoup.Connection;

import java.util.stream.Stream;

/**
 * Implements <b>utils.getLinkStats</b> method.
 *
 * @see <a href="https://vk.com/dev/utils.getLinkStats">https://vk.com/dev/utils.getLinkStats</a>
 */
public class UtilsGetLinkStats extends GetMethod<GenericResult<UtilsGetLinkStatsResponse>> {
    /**
     * Part of the link after "vk.cc/".
     */
    private String key;

    /**
     * Source.
     */
    private String source;

    /**
     * Access key for private link stats.
     */
    private String accessKey;

    /**
     * Interval.
     */
    private String interval;

    /**
     * Number of intervals to return.
     */
    private Integer intervalsCount;

    /**
     * <b>true</b> — to return extended stats data (sex, age, geo).
     */
    private Boolean extended;

    public UtilsGetLinkStats(String accessToken) {
        super(accessToken);
    }

    @Override
    protected String getApi() {
        return VkApi.getInstance().utilsGetLinkStats();
    }

    @Override
    protected JsonToPojoConverter<GenericResult<UtilsGetLinkStatsResponse>> getConverter() {
        return JsonToPojoConverterFactory.get(new TypeToken<GenericResult<UtilsGetLinkStatsResponse>>(){}.getType());
    }

    @Override
    protected Stream<Connection.KeyVal> getKeyValStream() {
        return Stream.of(
                keyVal("key", key),
                keyVal("source", source),
                keyVal("access_key", accessKey),
                keyVal("interval", interval),
                keyVal("intervals_count", intervalsCount),
                keyVal("extended", extended, true)
        );
    }

    public String getKey() {
        return key;
    }

    public UtilsGetLinkStats setKey(String key) {
        this.key = key;
        return this;
    }

    public String getSource() {
        return source;
    }

    public UtilsGetLinkStats setSource(String source) {
        this.source = source;
        return this;
    }

    public String getAccessKey() {
        return accessKey;
    }

    public UtilsGetLinkStats setAccessKey(String accessKey) {
        this.accessKey = accessKey;
        return this;
    }

    public String getInterval() {
        return interval;
    }

    public UtilsGetLinkStats setInterval(String interval) {
        this.interval = interval;
        return this;
    }

    public Integer getIntervalsCount() {
        return intervalsCount;
    }

    public UtilsGetLinkStats setIntervalsCount(Integer intervalsCount) {
        this.intervalsCount = intervalsCount;
        return this;
    }

    public Boolean getExtended() {
        return extended;
    }

    public UtilsGetLinkStats setExtended(Boolean extended) {
        this.extended = extended;
        return this;
    }
}
