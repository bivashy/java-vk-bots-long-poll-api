package api.longpoll.bots.model.response.groups;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Response to <b>groups.getTokenPermissions</b> request.
 */
public class GroupsGetTokenPermissionsResponse {
    /**
     * <i>access_token</i> permissions bit mask.
     */
    @SerializedName("mask")
    private Integer mask;

    /**
     * List of permissions.
     */
    @SerializedName("settings")
    private List<Setting> settings;

    /**
     * Describes permissions.
     */
    public static class Setting {
        /**
         * Permission's bit mask.
         */
        @SerializedName("setting")
        private Integer setting;

        /**
         * Permission's name.
         */
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

        @Override
        public String toString() {
            return "Setting{" +
                    "setting=" + setting +
                    ", name='" + name + '\'' +
                    '}';
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

    @Override
    public String toString() {
        return "GroupsGetTokenPermissionsResponse{" +
                "mask=" + mask +
                ", settings=" + settings +
                '}';
    }
}
