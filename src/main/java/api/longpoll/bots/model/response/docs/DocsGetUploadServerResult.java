package api.longpoll.bots.model.response.docs;

import api.longpoll.bots.model.response.GenericResult;
import com.google.gson.annotations.SerializedName;

/**
 * Response to <b>docs.getUploadServer</b> request.
 */
public class DocsGetUploadServerResult extends GenericResult<DocsGetUploadServerResult.Response> {
    /**
     * Response object.
     */
    public static class Response {
        /**
         * Link to which the document can be uploaded.
         */
        @SerializedName("upload_url")
        private String uploadUrl;

        public String getUploadUrl() {
            return uploadUrl;
        }

        public void setUploadUrl(String uploadUrl) {
            this.uploadUrl = uploadUrl;
        }

        @Override
        public String toString() {
            return "Response{" +
                    "uploadUrl='" + uploadUrl + '\'' +
                    '}';
        }
    }
}
