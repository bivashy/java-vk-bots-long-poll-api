package api.longpoll.bots.model.response.messages;

import com.google.gson.annotations.SerializedName;

/**
 * Response to <b>messages.getConversationMembers</b> request.
 */
public class MessagesGetConversationMembersResponseItem {
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
}
