package api.longpoll.bots.model.response.groups;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GroupsGetTokenPermissionsResult {
    @SerializedName("response")
    private Response response;

    public static class Response {
        @SerializedName("mask")
        private Integer mask;
        @SerializedName("settings")
        private List<Setting> settings;

        public static class Setting {
            @SerializedName("setting")
            private Integer setting;
            @SerializedName("name")
            private String name;

            public Integer getSetting() {
                return setting;
            }

            public void setSetting(Integer setting) {
                this.setting = setting;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }

        public Integer getMask() {
            return mask;
        }

        public void setMask(Integer mask) {
            this.mask = mask;
        }

        public List<Setting> getSettings() {
            return settings;
        }

        public void setSettings(List<Setting> settings) {
            this.settings = settings;
        }
    }

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }
}
