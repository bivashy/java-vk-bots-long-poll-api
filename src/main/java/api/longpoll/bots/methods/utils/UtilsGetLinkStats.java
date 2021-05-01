package api.longpoll.bots.methods.utils;

import api.longpoll.bots.methods.VkApiGetMethod;
import api.longpoll.bots.methods.VkApi;
import api.longpoll.bots.model.response.utils.UtilsGetLinkStatsResult;

import java.util.Map;
import java.util.stream.Stream;

/**
 * Implements <b>utils.getLinkStats</b> method.
 *
 * @see <a href="https://vk.com/dev/utils.getLinkStats">https://vk.com/dev/utils.getLinkStats</a>
 */
public class UtilsGetLinkStats extends VkApiGetMethod<UtilsGetLinkStatsResult> {
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
    protected Stream<Map.Entry<String, Object>> getParamsStream() {
        return Stream.of(
                param("key", key),
                param("source", source),
                param("access_key", accessKey),
                param("interval", interval),
                param("intervals_count", intervalsCount),
                param("extended", extended, true)
        );
    }

    @Override
    protected Class<? extends UtilsGetLinkStatsResult> getResultType() {
        return UtilsGetLinkStatsResult.class;
    }

    public UtilsGetLinkStats setKey(String key) {
        this.key = key;
        return this;
    }

    public UtilsGetLinkStats setSource(String source) {
        this.source = source;
        return this;
    }

    public UtilsGetLinkStats setAccessKey(String accessKey) {
        this.accessKey = accessKey;
        return this;
    }

    public UtilsGetLinkStats setInterval(String interval) {
        this.interval = interval;
        return this;
    }

    public UtilsGetLinkStats setIntervalsCount(Integer intervalsCount) {
        this.intervalsCount = intervalsCount;
        return this;
    }

    public UtilsGetLinkStats setExtended(Boolean extended) {
        this.extended = extended;
        return this;
    }
}
