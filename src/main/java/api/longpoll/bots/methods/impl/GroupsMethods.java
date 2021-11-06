package api.longpoll.bots.methods.impl;

import api.longpoll.bots.methods.impl.groups.AddAddress;
import api.longpoll.bots.methods.impl.groups.AddCallbackServer;
import api.longpoll.bots.methods.impl.groups.DeleteAddress;
import api.longpoll.bots.methods.impl.groups.DeleteCallbackServer;
import api.longpoll.bots.methods.impl.groups.DisableOnline;
import api.longpoll.bots.methods.impl.groups.EditAddress;
import api.longpoll.bots.methods.impl.groups.EditCallbackServer;
import api.longpoll.bots.methods.impl.groups.EnableOnline;
import api.longpoll.bots.methods.impl.groups.GetBanned;
import api.longpoll.bots.methods.impl.groups.GetById;
import api.longpoll.bots.methods.impl.groups.GetCallbackConfirmationCode;
import api.longpoll.bots.methods.impl.groups.GetCallbackServers;
import api.longpoll.bots.methods.impl.groups.GetCallbackSettings;
import api.longpoll.bots.methods.impl.groups.GetLongPollServer;
import api.longpoll.bots.methods.impl.groups.GetLongPollSettings;
import api.longpoll.bots.methods.impl.groups.GetMembers;
import api.longpoll.bots.methods.impl.groups.GetOnlineStatus;
import api.longpoll.bots.methods.impl.groups.GetTokenPermissions;
import api.longpoll.bots.methods.impl.groups.IsMember;
import api.longpoll.bots.methods.impl.groups.SetCallbackSettings;
import api.longpoll.bots.methods.impl.groups.SetLongPollSettings;
import api.longpoll.bots.methods.impl.groups.SetSettings;

/**
 * Provides Groups methods.
 */
public class GroupsMethods {
    /**
     * Access token.
     */
    private final String accessToken;

    public GroupsMethods(String accessToken) {
        this.accessToken = accessToken;
    }

    public AddAddress addAddress() {
        return new AddAddress(accessToken);
    }

    public AddCallbackServer addCallbackServer() {
        return new AddCallbackServer(accessToken);
    }

    public DeleteAddress deleteAddress() {
        return new DeleteAddress(accessToken);
    }

    public DeleteCallbackServer deleteCallbackServer() {
        return new DeleteCallbackServer(accessToken);
    }

    public DisableOnline disableOnline() {
        return new DisableOnline(accessToken);
    }

    public EditAddress editAddress() {
        return new EditAddress(accessToken);
    }

    public EditCallbackServer editCallbackServer() {
        return new EditCallbackServer(accessToken);
    }

    public EnableOnline enableOnline() {
        return new EnableOnline(accessToken);
    }

    public GetBanned getBanned() {
        return new GetBanned(accessToken);
    }

    public GetById getById() {
        return new GetById(accessToken);
    }

    public GetCallbackConfirmationCode getCallbackConfirmationCode() {
        return new GetCallbackConfirmationCode(accessToken);
    }

    public GetCallbackServers getCallbackServers() {
        return new GetCallbackServers(accessToken);
    }

    public GetCallbackSettings getCallbackSettings() {
        return new GetCallbackSettings(accessToken);
    }

    public GetLongPollServer getLongPollServer() {
        return new GetLongPollServer(accessToken);
    }

    public GetLongPollSettings getLongPollSettings() {
        return new GetLongPollSettings(accessToken);
    }

    public GetMembers getMembers() {
        return new GetMembers(accessToken);
    }

    public GetOnlineStatus getOnlineStatus() {
        return new GetOnlineStatus(accessToken);
    }

    public GetTokenPermissions getTokenPermissions() {
        return new GetTokenPermissions(accessToken);
    }

    public IsMember isMember() {
        return new IsMember(accessToken);
    }

    public SetCallbackSettings setCallbackSettings() {
        return new SetCallbackSettings(accessToken);
    }

    public SetLongPollSettings setLongPollSettings() {
        return new SetLongPollSettings(accessToken);
    }

    public SetSettings setSettings() {
        return new SetSettings(accessToken);
    }
}
