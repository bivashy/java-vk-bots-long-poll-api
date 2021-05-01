package api.longpoll.bots.methods.stories;

import api.longpoll.bots.methods.GetMethod;
import api.longpoll.bots.methods.VkApi;
import api.longpoll.bots.model.response.stories.StoriesGetUploadServerResult;
import org.jsoup.Connection;

import java.util.List;
import java.util.stream.Stream;

/**
 * Implements <b>stories.getPhotoUploadServer</b> method.
 *
 * @see <a href="https://vk.com/dev/stories.getPhotoUploadServer">https://vk.com/dev/stories.getPhotoUploadServer</a>
 */
public class StoriesGetPhotoUploadServer extends GetMethod<StoriesGetUploadServerResult> {
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

    @Override
    protected Class<? extends StoriesGetUploadServerResult> getResultType() {
        return StoriesGetUploadServerResult.class;
    }

    public StoriesGetPhotoUploadServer setAdd_to_news(Boolean add_to_news) {
        this.add_to_news = add_to_news;
        return this;
    }

    public StoriesGetPhotoUploadServer setReplyToStory(String replyToStory) {
        this.replyToStory = replyToStory;
        return this;
    }

    public StoriesGetPhotoUploadServer setLinkText(String linkText) {
        this.linkText = linkText;
        return this;
    }

    public StoriesGetPhotoUploadServer setLinkUrl(String linkUrl) {
        this.linkUrl = linkUrl;
        return this;
    }

    public StoriesGetPhotoUploadServer setGroupId(Integer groupId) {
        this.groupId = groupId;
        return this;
    }

    public StoriesGetPhotoUploadServer setClickableStickers(String clickableStickers) {
        this.clickableStickers = clickableStickers;
        return this;
    }

    public StoriesGetPhotoUploadServer setUserIds(List<Integer> userIds) {
        this.userIds = userIds;
        return this;
    }
}
