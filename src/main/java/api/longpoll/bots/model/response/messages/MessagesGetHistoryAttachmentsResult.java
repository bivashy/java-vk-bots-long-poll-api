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

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }
}
