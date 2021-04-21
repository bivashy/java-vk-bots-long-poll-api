package api.longpoll.bots.methods.stories;

import api.longpoll.bots.converters.JsonToPojoConverter;
import api.longpoll.bots.converters.JsonToPojoConverterFactory;
import api.longpoll.bots.methods.GetMethod;
import api.longpoll.bots.methods.VkApi;
import api.longpoll.bots.model.response.GenericResult;
import api.longpoll.bots.model.response.stories.StoriesGetUploadServerResponse;
import com.google.gson.reflect.TypeToken;
import org.jsoup.Connection;

import java.util.List;
import java.util.stream.Stream;

/**
 * Implements <b>stories.getPhotoUploadServer</b> method.
 *
 * @see <a href="https://vk.com/dev/stories.getPhotoUploadServer">https://vk.com/dev/stories.getPhotoUploadServer</a>
 */
public class StoriesGetPhotoUploadServer extends GetMethod<GenericResult<StoriesGetUploadServerResponse>> {
    /**
     * To add the story to friend's feed.
     */
    private Boolean add_to_news;

    /**
     * ID of the story to reply with the current.
     */
    private String replyToStory;

    /**
     * Link text (for community's stories only). Possible values:
     * <ul>
     *     <li>to_store</li>
     *     <li>vote</li>
     *     <li>more</li>
     *     <li>book</li>
     *     <li>order</li>
     *     <li>enroll</li>
     *     <li>fill</li>
     *     <li>signup</li>
     *     <li>buy</li>
     *     <li>ticket</li>
     *     <li>write</li>
     *     <li>open</li>
     *     <li>learn_more</li>
     *     <li>view</li>
     *     <li>go_to</li>
     *     <li>contact</li>
     *     <li>watch</li>
     *     <li>play</li>
     *     <li>install</li>
     *     <li>read</li>
     * </ul>
     */
    private String linkText;

    /**
     * Link URL. Internal links on https://vk.com only.
     */
    private String linkUrl;

    /**
     * ID of the community to upload the story.
     */
    private Integer groupId;

    /**
     * JSON data.
     */
    private String clickableStickers;

    /**
     * List of users IDs who can see the story.
     */
    private List<Integer> userIds;

    public StoriesGetPhotoUploadServer(String accessToken) {
        super(accessToken);
    }

    @Override
    protected String getApi() {
        return VkApi.getInstance().storiesGetPhotoUploadServer();
    }

    @Override
    protected JsonToPojoConverter<GenericResult<StoriesGetUploadServerResponse>> getConverter() {
        return JsonToPojoConverterFactory.get(new TypeToken<GenericResult<StoriesGetUploadServerResponse>>(){}.getType());
    }

    @Override
    protected Stream<Connection.KeyVal> getKeyValStream() {
        return Stream.of(
                keyVal("add_to_news", add_to_news, true),
                keyVal("user_ids", userIds),
                keyVal("reply_to_story", replyToStory),
                keyVal("link_text", linkText),
                keyVal("link_url", linkUrl),
                keyVal("group_id", groupId),
                keyVal("clickable_stickers", clickableStickers)
        );
    }

    public Boolean getAdd_to_news() {
        return add_to_news;
    }

    public StoriesGetPhotoUploadServer setAdd_to_news(Boolean add_to_news) {
        this.add_to_news = add_to_news;
        return this;
    }

    public String getReplyToStory() {
        return replyToStory;
    }

    public StoriesGetPhotoUploadServer setReplyToStory(String replyToStory) {
        this.replyToStory = replyToStory;
        return this;
    }

    public String getLinkText() {
        return linkText;
    }

    public StoriesGetPhotoUploadServer setLinkText(String linkText) {
        this.linkText = linkText;
        return this;
    }

    public String getLinkUrl() {
        return linkUrl;
    }

    public StoriesGetPhotoUploadServer setLinkUrl(String linkUrl) {
        this.linkUrl = linkUrl;
        return this;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public StoriesGetPhotoUploadServer setGroupId(Integer groupId) {
        this.groupId = groupId;
        return this;
    }

    public String getClickableStickers() {
        return clickableStickers;
    }

    public StoriesGetPhotoUploadServer setClickableStickers(String clickableStickers) {
        this.clickableStickers = clickableStickers;
        return this;
    }

    public List<Integer> getUserIds() {
        return userIds;
    }

    public StoriesGetPhotoUploadServer setUserIds(List<Integer> userIds) {
        this.userIds = userIds;
        return this;
    }
}
