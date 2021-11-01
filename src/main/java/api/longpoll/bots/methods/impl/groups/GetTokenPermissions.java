package api.longpoll.bots.methods.impl.groups;

import api.longpoll.bots.methods.AuthorizedVkApiMethod;
import api.longpoll.bots.methods.VkApiProperties;
import api.longpoll.bots.model.response.GenericResponse;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Implements <b>groups.getTokenPermissions</b> method.
 * <p>
 * Returns permissions scope for the community's access_token.
 *
 * @see <a href="https://vk.com/dev/groups.getTokenPermissions">https://vk.com/dev/groups.getTokenPermissions</a>
 */
public class GetTokenPermissions extends AuthorizedVkApiMethod<GetTokenPermissions.Response> {
    public GetTokenPermissions(String accessToken) {
        super(accessToken);
    }

    @Override
    protected String getUrl() {
        return VkApiProperties.get("groups.getTokenPermissions");
    }

    @Override
    protected Class<Response> getResponseType() {
        return Response.class;
    }

    @Override
    public GetTokenPermissions addParam(String key, Object value) {
        return (GetTokenPermissions) super.addParam(key, value);
    }

    /**
     * Response to <b>groups.getTokenPermissions</b> request.
     */
    public static class Response extends GenericResponse<Response.ResponseObject> {
        /**
         * Response object.
         */
        public static class ResponseObject {
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
                return "ResponseObject{" +
                        "mask=" + mask +
                        ", settings=" + settings +
                        '}';
            }
        }
    }
}
