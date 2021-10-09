package api.longpoll.bots.methods.impl.stories;

import api.longpoll.bots.methods.AuthorizedVkApiMethod;
import api.longpoll.bots.methods.VkApiProperties;
import api.longpoll.bots.model.response.GenericResponse;
import com.google.gson.annotations.SerializedName;

/**
 * Implements <b>stories.getStats</b> method.
 * <p>
 * Returns statistics data for the story.
 *
 * @see <a href="https://vk.com/dev/stories.getStats">https://vk.com/dev/stories.getStats</a>
 */
public class GetStats extends AuthorizedVkApiMethod<GetStats.Response> {
    public GetStats(String accessToken) {
        super(accessToken);
    }

    @Override
    protected String getUrl() {
        return VkApiProperties.get("stories.getStats");
    }

    @Override
    protected Class<Response> getResponseType() {
        return Response.class;
    }

    public GetStats setOwnerId(int ownerId) {
        return addParam("owner_id", ownerId);
    }

    public GetStats setStoryId(int storyId) {
        return addParam("story_id", storyId);
    }

    @Override
    public GetStats addParam(String key, Object value) {
        return (GetStats) super.addParam(key, value);
    }

    /**
     * Response to <b>stories.getStats</b>
     */
    public static class Response extends GenericResponse<Response.ResponseObject> {
        /**
         * Response object.
         */
        public static class ResponseObject {
            /**
             * Views.
             */
            @SerializedName("views")
            private Stats views;

            /**
             * Replies to the story.
             */
            @SerializedName("replies")
            private Stats replies;

            /**
             * How many times this story was answered with a message through the field below the story.
             */
            @SerializedName("answer")
            private Stats answer;

            /**
             * Shares.
             */
            @SerializedName("shares")
            private Stats shares;

            /**
             * New subscribers.
             */
            @SerializedName("subscribers")
            private Stats subscribers;

            /**
             * Bans.
             */
            @SerializedName("bans")
            private Stats bans;

            /**
             * Link's clicks.
             */
            @SerializedName("open_link")
            private Stats openLink;

            /**
             * Describes stats object.
             */
            public static class Stats {
                /**
                 * Counter's availability (on — available, off — unavailable).
                 */
                @SerializedName("state")
                private String state;

                /**
                 * Counter's value.
                 */
                @SerializedName("count")
                private Integer count;

                public String getState() {
                    return state;
                }

                public void setState(String state) {
                    this.state = state;
                }

                public Integer getCount() {
                    return count;
                }

                public void setCount(Integer count) {
                    this.count = count;
                }

                @Override
                public String toString() {
                    return "Stats{" +
                            "state='" + state + '\'' +
                            ", count=" + count +
                            '}';
                }
            }

            public Stats getViews() {
                return views;
            }

            public void setViews(Stats views) {
                this.views = views;
            }

            public Stats getReplies() {
                return replies;
            }

            public void setReplies(Stats replies) {
                this.replies = replies;
            }

            public Stats getAnswer() {
                return answer;
            }

            public void setAnswer(Stats answer) {
                this.answer = answer;
            }

            public Stats getShares() {
                return shares;
            }

            public void setShares(Stats shares) {
                this.shares = shares;
            }

            public Stats getSubscribers() {
                return subscribers;
            }

            public void setSubscribers(Stats subscribers) {
                this.subscribers = subscribers;
            }

            public Stats getBans() {
                return bans;
            }

            public void setBans(Stats bans) {
                this.bans = bans;
            }

            public Stats getOpenLink() {
                return openLink;
            }

            public void setOpenLink(Stats openLink) {
                this.openLink = openLink;
            }

            @Override
            public String toString() {
                return "ResponseObject{" +
                        "views=" + views +
                        ", replies=" + replies +
                        ", answer=" + answer +
                        ", shares=" + shares +
                        ", subscribers=" + subscribers +
                        ", bans=" + bans +
                        ", openLink=" + openLink +
                        '}';
            }
        }
    }
}
