package api.longpoll.bots.methods.impl.messages;

import api.longpoll.bots.methods.AuthorizedVkApiMethod;
import api.longpoll.bots.methods.VkApiProperties;
import api.longpoll.bots.model.response.ExtendedVkList;
import api.longpoll.bots.model.response.GenericResponse;
import com.google.gson.annotations.SerializedName;

import java.util.Arrays;
import java.util.List;

/**
 * Implements <b>messages.getConversationMembers</b> method.
 * <p>
 * Returns a list of IDs of users participating in a conversation.
 *
 * @see <a href="https://vk.com/dev/messages.getConversationMembers">https://vk.com/dev/messages.getConversationMembers</a>
 */
public class GetConversationMembers extends AuthorizedVkApiMethod<GetConversationMembers.Response> {
    public GetConversationMembers(String accessToken) {
        super(accessToken);
    }

    @Override
    protected String getUrl() {
        return VkApiProperties.get("messages.getConversationMembers");
    }


    @Override
    protected Class<Response> getResponseType() {
        return Response.class;
    }

    public GetConversationMembers setPeerId(int peerId) {
        return addParam("peer_id", peerId);
    }

    public GetConversationMembers setFields(String... fields) {
        return setFields(Arrays.asList(fields));
    }

    public GetConversationMembers setFields(List<String> fields) {
        return addParam("fields", fields);
    }

    public GetConversationMembers setGroupId(int groupId) {
        return addParam("group_id", groupId);
    }

    @Override
    public GetConversationMembers addParam(String key, Object value) {
        return (GetConversationMembers) super.addParam(key, value);
    }

    /**
     * Response to <b>messages.getConversationMembers</b> request.
     */
    public static class Response extends GenericResponse<ExtendedVkList<Response.Item>> {
        /**
         * Response item.
         */
        public static class Item {
            /**
             * Conversation member ID.
             */
            @SerializedName("member_id")
            private Integer memberId;

            /**
             * ID of the user who invited this member to the conversation.
             */
            @SerializedName("invited_by")
            private Integer invitedBy;

            /**
             * Date of joining the conversation.
             */
            @SerializedName("join_date")
            private Integer joinDate;

            /**
             * Whether the user is conversation admin.
             */
            @SerializedName("is_admin")
            private Boolean admin;

            /**
             * Whether the user can kick.
             */
            @SerializedName("can_kick")
            private Boolean canKick;

            public Integer getMemberId() {
                return memberId;
            }

            public void setMemberId(Integer memberId) {
                this.memberId = memberId;
            }

            public Integer getInvitedBy() {
                return invitedBy;
            }

            public void setInvitedBy(Integer invitedBy) {
                this.invitedBy = invitedBy;
            }

            public Integer getJoinDate() {
                return joinDate;
            }

            public void setJoinDate(Integer joinDate) {
                this.joinDate = joinDate;
            }

            public Boolean getAdmin() {
                return admin;
            }

            public void setAdmin(Boolean admin) {
                this.admin = admin;
            }

            public Boolean getCanKick() {
                return canKick;
            }

            public void setCanKick(Boolean canKick) {
                this.canKick = canKick;
            }


            @Override
            public String toString() {
                return "Item{" +
                        "memberId=" + memberId +
                        ", invitedBy=" + invitedBy +
                        ", joinDate=" + joinDate +
                        ", admin=" + admin +
                        ", canKick=" + canKick +
                        '}';
            }
        }
    }
}
