package api.longpoll.bots.methods.utils;

import api.longpoll.bots.LongPollBot;
import api.longpoll.bots.converters.GenericConverterFactory;
import api.longpoll.bots.converters.JsonToPojoConverter;
import api.longpoll.bots.methods.GetMethod;
import api.longpoll.bots.methods.VkApi;
import api.longpoll.bots.model.response.utils.UtilsGetLinkStatsResult;
import org.jsoup.Connection;

import java.util.stream.Stream;

public class UtilsGetLinkStats extends GetMethod<UtilsGetLinkStatsResult> {
    private String key;
    private String source;
    private String accessKey;
    private String interval;
    private Integer intervalsCount;
    private Boolean extended;

    public UtilsGetLinkStats(LongPollBot bot) {
        super(bot);
    }

    @Override
    protected String getApi() {
        return VkApi.getInstance().utilsGetLinkStats();
    }

    @Override
    protected JsonToPojoConverter<UtilsGetLinkStatsResult> getConverter() {
        return GenericConverterFactory.get(UtilsGetLinkStatsResult.class);
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
