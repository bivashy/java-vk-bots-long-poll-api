package api.longpoll.bots.model.response.messages;

import api.longpoll.bots.adapters.deserializers.AttachmentDeserializer;
import api.longpoll.bots.model.objects.media.Attachment;
import api.longpoll.bots.model.response.GenericResult;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Response to <b>messages.getHistoryAttachments</b> request.
 */
public class MessagesGetHistoryAttachmentsResult extends GenericResult<MessagesGetHistoryAttachmentsResult.Response> {
    /**
     * Response object.
     */
    public static class Response {
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
            return "Response{" +
                    "items=" + items +
                    ", nextFrom='" + nextFrom + '\'' +
                    '}';
        }
    }
}
