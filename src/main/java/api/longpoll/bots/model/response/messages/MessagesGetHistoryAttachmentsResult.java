package api.longpoll.bots.model.response.messages;

import api.longpoll.bots.model.objects.media.Attachment;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MessagesGetHistoryAttachmentsResult {
    @SerializedName("response")
    private Response response;

    public static class Response {
        @SerializedName("items")
        private List<Item> items;
        @SerializedName("next_from")
        private String nextFrom;

        public static class Item {
            @SerializedName("message_id")
            private Integer messageId;
            @SerializedName("attachment")
            private Attachment attachment;

            public Integer getMessageId() {
                return messageId;
            }

            public Item setMessageId(Integer messageId) {
                this.messageId = messageId;
                return this;
            }

            public Attachment getAttachment() {
                return attachment;
            }

            public Item setAttachment(Attachment attachment) {
                this.attachment = attachment;
                return this;
            }
        }

        public List<Item> getItems() {
            return items;
        }

        public Response setItems(List<Item> items) {
            this.items = items;
            return this;
        }

        public String getNextFrom() {
            return nextFrom;
        }

        public Response setNextFrom(String nextFrom) {
            this.nextFrom = nextFrom;
            return this;
        }
    }

    public Response getResponse() {
        return response;
    }

    public MessagesGetHistoryAttachmentsResult setResponse(Response response) {
        this.response = response;
        return this;
    }
}
