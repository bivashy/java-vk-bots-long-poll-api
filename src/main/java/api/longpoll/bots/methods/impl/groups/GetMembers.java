package api.longpoll.bots.methods.impl.groups;

import api.longpoll.bots.adapters.deserializers.GroupsGetMemberResponseDeserializer;
import api.longpoll.bots.methods.AuthorizedVkApiMethod;
import api.longpoll.bots.methods.VkApiProperties;
import api.longpoll.bots.model.objects.additional.VkList;
import api.longpoll.bots.model.objects.basic.User;
import api.longpoll.bots.model.response.GenericResponse;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;

import java.util.Arrays;
import java.util.List;

/**
 * Implements <b>groups.getMembers</b> method.
 * <p>
 * Returns a list of community members.
 *
 * @see <a href="https://vk.com/dev/groups.getMembers">https://vk.com/dev/groups.getMembers</a>
 */
public class GetMembers extends AuthorizedVkApiMethod<GetMembers.Response> {
    public GetMembers(String accessToken) {
        super(accessToken);
    }

    @Override
    protected String getUrl() {
        return VkApiProperties.get("groups.getMembers");
    }

    @Override
    protected Class<Response> getResponseType() {
        return Response.class;
    }

    public GetMembers setGroupId(int groupId) {
        return addParam("group_id", groupId);
    }

    public GetMembers setSort(String sort) {
        return addParam("sort", sort);
    }

    public GetMembers setOffset(int offset) {
        return addParam("offset", offset);
    }

    public GetMembers setCount(int count) {
        return addParam("count", count);
    }

    public GetMembers setFields(String... fields) {
        return setFields(Arrays.asList(fields));
    }

    public GetMembers setFields(List<String> fields) {
        return addParam("fields", fields);
    }

    public GetMembers setFilter(String filter) {
        return addParam("filter", filter);
    }

    @Override
    public GetMembers addParam(String key, Object value) {
        return (GetMembers) super.addParam(key, value);
    }

    /**
     * Result to <b>groups.getMembers</b> request.
     */
    @JsonAdapter(GroupsGetMemberResponseDeserializer.class)
    public static class Response extends GenericResponse<VkList<Object>> {
        /**
         * Response Item.
         */
        public static class Item extends User {
            /**
             * Group role.
             */
            @SerializedName("role")
            private String role;

            public String getRole() {
                return role;
            }

            public void setRole(String role) {
                this.role = role;
            }


            @Override
            public String toString() {
                return "Item{" +
                        "role='" + role + '\'' +
                        "} " + super.toString();
            }
        }
    }
}
