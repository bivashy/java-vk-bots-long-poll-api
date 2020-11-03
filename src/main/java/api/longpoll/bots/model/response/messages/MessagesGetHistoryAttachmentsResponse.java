package api.longpoll.bots.model.response.messages;

import api.longpoll.bots.model.objects.media.Attachment;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Response to <b>messages.getHistoryAttachments</b> request.
 */
public class MessagesGetHistoryAttachmentsResponse {
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
}
