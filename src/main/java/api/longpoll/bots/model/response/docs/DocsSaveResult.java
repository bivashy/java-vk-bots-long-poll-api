package api.longpoll.bots.model.response.docs;

import api.longpoll.bots.model.objects.media.Attachable;
import com.google.gson.annotations.SerializedName;

/**
 * Response to <b>docs.save</b> request.
 */
public class DocsSaveResult {
    /**
     * Response object.
     */
    @SerializedName("response")
    private Response response;

    /**
     * Describes response object.
     */
    public static class Response {
        /**
         * Type of document. Possible values:
         * <ul>
         *     <li>graffiti</li>
         *     <li>audio_message</li>
         *     <li>doc</li>
         * </ul>
         */
        @SerializedName("type")
        private String type;

        /**
         * Saved document.
         */
        private Attachable attachable;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public Attachable getAttachable() {
            return attachable;
        }

        public void setAttachable(Attachable attachable) {
            this.attachable = attachable;
        }
    }

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }
}
