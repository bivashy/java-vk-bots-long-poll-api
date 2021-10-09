package api.longpoll.bots.methods.impl.messages;

import api.longpoll.bots.adapters.deserializers.AttachmentDeserializer;
import api.longpoll.bots.http.params.BoolInt;
import api.longpoll.bots.methods.AuthorizedVkApiMethod;
import api.longpoll.bots.methods.VkApiProperties;
import api.longpoll.bots.model.objects.media.Attachment;
import api.longpoll.bots.model.response.GenericResponse;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;

import java.util.Arrays;
import java.util.List;

/**
 * Implements <b>messages.getHistoryAttachments</b> method.
 * <p>
 * Returns media files from the dialog or group chat.
 *
 * @see <a href="https://vk.com/dev/messages.getHistoryAttachments">https://vk.com/dev/messages.getHistoryAttachments</a>
 */
public class GetHistoryAttachments extends AuthorizedVkApiMethod<GetHistoryAttachments.Response> {
    public GetHistoryAttachments(String accessToken) {
        super(accessToken);
    }

    @Override
    protected String getUrl() {
        return VkApiProperties.get("messages.getHistoryAttachments");
    }

    @Override
    protected Class<Response> getResponseType() {
        return Response.class;
    }

    public GetHistoryAttachments setPeerId(int peerId) {
        return addParam("peer_id", peerId);
    }

    public GetHistoryAttachments setMediaType(String mediaType) {
        return addParam("media_type", mediaType);
    }

    public GetHistoryAttachments setStartFrom(String startFrom) {
        return addParam("start_from", startFrom);
    }

    public GetHistoryAttachments setCount(int count) {
        return addParam("count", count);
    }

    public GetHistoryAttachments setPhotoSizes(boolean photoSizes) {
        return addParam("photo_sizes", new BoolInt(photoSizes));
    }

    public GetHistoryAttachments setFields(String... fields) {
        return setFields(Arrays.asList(fields));
    }

    public GetHistoryAttachments setFields(List<String> fields) {
        return addParam("fields", fields);
    }

    public GetHistoryAttachments setGroupId(int groupId) {
        return addParam("group_id", groupId);
    }

    public GetHistoryAttachments setPreserveOrder(boolean preserveOrder) {
        return addParam("preserve_order", new BoolInt(preserveOrder));
    }

    public GetHistoryAttachments setMaxForwardsLevel(int maxForwardsLevel) {
        return addParam("max_forwards_level", maxForwardsLevel);
    }

    @Override
    public GetHistoryAttachments addParam(String key, Object value) {
        return (GetHistoryAttachments) super.addParam(key, value);
    }

    /**
     * Response to <b>messages.getHistoryAttachments</b> request.
     */
    public static class Response extends GenericResponse<Response.ResponseObject> {
        /**
         * Response object.
         */
        public static class ResponseObject {
            /**
             * List of photo, video, audio or doc.
             */
            @SerializedName("items")
            private List<Item> items;

            /**
             * Offset value.
             */
            @SerializedName("next_from")
            private String nextFrom;

            /**
             * Describes list item.
             */
            public static class Item {
                /**
                 * Message ID.
                 */
                @SerializedName("message_id")
                private Integer messageId;

                /**
                 * Attachment.
                 */
                @SerializedName("attachment")
                @JsonAdapter(AttachmentDeserializer.class)
                private Attachment attachment;

                public Integer getMessageId() {
                    return messageId;
                }

                public void setMessageId(Integer messageId) {
                    this.messageId = messageId;
                }

                public Attachment getAttachment() {
                    return attachment;
                }

                public void setAttachment(Attachment attachment) {
                    this.attachment = attachment;
                }

                @Override
                public String toString() {
                    return "Item{" +
                            "messageId=" + messageId +
                            ", attachment=" + attachment +
                            '}';
                }
            }

            public List<Item> getItems() {
                return items;
            }

            public void setItems(List<Item> items) {
                this.items = items;
            }

            public String getNextFrom() {
                return nextFrom;
            }

            public void setNextFrom(String nextFrom) {
                this.nextFrom = nextFrom;
            }


            @Override
            public String toString() {
                return "ResponseObject{" +
                        "items=" + items +
                        ", nextFrom='" + nextFrom + '\'' +
                        '}';
            }
        }
    }
}
