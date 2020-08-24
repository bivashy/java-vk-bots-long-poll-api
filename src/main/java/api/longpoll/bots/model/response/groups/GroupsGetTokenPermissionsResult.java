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

            public Setting setSetting(Integer setting) {
                this.setting = setting;
                return this;
            }

            public String getName() {
                return name;
            }

            public Setting setName(String name) {
                this.name = name;
                return this;
            }
        }

        public Integer getMask() {
            return mask;
        }

        public Response setMask(Integer mask) {
            this.mask = mask;
            return this;
        }

        public List<Setting> getSettings() {
            return settings;
        }

        public Response setSettings(List<Setting> settings) {
            this.settings = settings;
            return this;
        }
    }

    public Response getResponse() {
        return response;
    }

    public GroupsGetTokenPermissionsResult setResponse(Response response) {
        this.response = response;
        return this;
    }
}
