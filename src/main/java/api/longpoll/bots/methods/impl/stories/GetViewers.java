package api.longpoll.bots.methods.impl.stories;

import api.longpoll.bots.adapters.deserializers.StoriesGetViewersResultDeserializer;
import api.longpoll.bots.http.params.BoolInt;
import api.longpoll.bots.methods.AuthorizedVkApiMethod;
import api.longpoll.bots.methods.VkApiProperties;
import api.longpoll.bots.model.objects.additional.VkList;
import api.longpoll.bots.model.response.GenericResponse;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;

import java.util.Arrays;
import java.util.List;

/**
 * Implements <b>messages.getById</b> method.
 * <p>
 * Returns messages by their IDs.
 *
 * @see <a href="https://vk.com/dev/messages.getById">https://vk.com/dev/messages.getById</a>
 */
public class GetViewers extends AuthorizedVkApiMethod<GetViewers.Response> {
    public GetViewers(String accessToken) {
        super(accessToken);
    }

    @Override
    protected String getUrl() {
        return VkApiProperties.get("stories.getViewers");
    }

    @Override
    protected Class<Response> getResponseType() {
        return Response.class;
    }

    public GetViewers setMessageIds(Integer... messageIds) {
        return setMessageIds(Arrays.asList(messageIds));
    }

    public GetViewers setMessageIds(List<Integer> messageIds) {
        return addParam("message_ids", messageIds);
    }

    public GetViewers setPreviewLength(int previewLength) {
        return addParam("preview_length", previewLength);
    }

    public GetViewers setExtended(boolean extended) {
        return addParam("extended", new BoolInt(extended));
    }

    public GetViewers setFields(String... fields) {
        return setFields(Arrays.asList(fields));
    }

    public GetViewers setFields(List<String> fields) {
        return addParam("fields", fields);
    }

    public GetViewers setGroupId(int groupId) {
        return addParam("group_id", groupId);
    }

    @Override
    public GetViewers addParam(String key, Object value) {
        return (GetViewers) super.addParam(key, value);
    }

    /**
     * Response to <b>stories.getViewers</b>.
     */
    @JsonAdapter(StoriesGetViewersResultDeserializer.class)
    public static class Response extends GenericResponse<VkList<Object>> {
        /**
         * Response item.
         */
        public static class ResponseObject {
            /**
             * Whether the story is liked.
             */
            @SerializedName("is_liked")
            private Boolean isLiked;

            /**
             * User ID.
             */
            @SerializedName("user_id")
            private Integer userId;

            public Boolean getLiked() {
                return isLiked;
            }

            public void setLiked(Boolean liked) {
                isLiked = liked;
            }

            public Integer getUserId() {
                return userId;
            }

            public void setUserId(Integer userId) {
                this.userId = userId;
            }

            @Override
            public String toString() {
                return "ResponseObject{" +
                        "isLiked=" + isLiked +
                        ", userId=" + userId +
                        '}';
            }
        }
    }
}
