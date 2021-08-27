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
public class GroupsApi extends AbstractVkApi {
    public GroupsApi(String accessToken) {
        super(accessToken);
    }

    public AddAddress addAddress() {
        return new AddAddress(getAccessToken());
    }

    public AddCallbackServer addCallbackServer() {
        return new AddCallbackServer(getAccessToken());
    }

    public DeleteAddress deleteAddress() {
        return new DeleteAddress(getAccessToken());
    }

    public DeleteCallbackServer deleteCallbackServer() {
        return new DeleteCallbackServer(getAccessToken());
    }

    public DisableOnline disableOnline() {
        return new DisableOnline(getAccessToken());
    }

    public EditAddress editAddress() {
        return new EditAddress(getAccessToken());
    }

    public EditCallbackServer editCallbackServer() {
        return new EditCallbackServer(getAccessToken());
    }

    public EnableOnline enableOnline() {
        return new EnableOnline(getAccessToken());
    }

    public GetBanned getBanned() {
        return new GetBanned(getAccessToken());
    }

    public GetById getById() {
        return new GetById(getAccessToken());
    }

    public GetCallbackConfirmationCode getCallbackConfirmationCode() {
        return new GetCallbackConfirmationCode(getAccessToken());
    }

    public GetCallbackServers getCallbackServers() {
        return new GetCallbackServers(getAccessToken());
    }

    public GetCallbackSettings getCallbackSettings() {
        return new GetCallbackSettings(getAccessToken());
    }

    public GetLongPollServer getLongPollServer() {
        return new GetLongPollServer(getAccessToken());
    }

    public GetLongPollSettings getLongPollSettings() {
        return new GetLongPollSettings(getAccessToken());
    }

    public GetMembers getMembers() {
        return new GetMembers(getAccessToken());
    }

    public GetOnlineStatus getOnlineStatus() {
        return new GetOnlineStatus(getAccessToken());
    }

    public GetTokenPermissions getTokenPermissions() {
        return new GetTokenPermissions(getAccessToken());
    }

    public IsMember isMember() {
        return new IsMember(getAccessToken());
    }

    public SetCallbackSettings setCallbackSettings() {
        return new SetCallbackSettings(getAccessToken());
    }

    public SetLongPollSettings setLongPollSettings() {
        return new SetLongPollSettings(getAccessToken());
    }

    public SetSettings setSettings() {
        return new SetSettings(getAccessToken());
    }
}
