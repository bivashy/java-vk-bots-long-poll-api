package api.longpoll.bots.methods;

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

import java.util.function.Supplier;

/**
 * Provides Groups methods.
 */
public class GroupsMethods {
    /**
     * Access token.
     */
    private final Supplier<String> accessTokenSupplier;

    public GroupsMethods(Supplier<String> accessTokenSupplier) {
        this.accessTokenSupplier = accessTokenSupplier;
    }

    public AddAddress addAddress() {
        return new AddAddress(accessTokenSupplier.get());
    }

    public AddCallbackServer addCallbackServer() {
        return new AddCallbackServer(accessTokenSupplier.get());
    }

    public DeleteAddress deleteAddress() {
        return new DeleteAddress(accessTokenSupplier.get());
    }

    public DeleteCallbackServer deleteCallbackServer() {
        return new DeleteCallbackServer(accessTokenSupplier.get());
    }

    public DisableOnline disableOnline() {
        return new DisableOnline(accessTokenSupplier.get());
    }

    public EditAddress editAddress() {
        return new EditAddress(accessTokenSupplier.get());
    }

    public EditCallbackServer editCallbackServer() {
        return new EditCallbackServer(accessTokenSupplier.get());
    }

    public EnableOnline enableOnline() {
        return new EnableOnline(accessTokenSupplier.get());
    }

    public GetBanned getBanned() {
        return new GetBanned(accessTokenSupplier.get());
    }

    public GetById getById() {
        return new GetById(accessTokenSupplier.get());
    }

    public GetCallbackConfirmationCode getCallbackConfirmationCode() {
        return new GetCallbackConfirmationCode(accessTokenSupplier.get());
    }

    public GetCallbackServers getCallbackServers() {
        return new GetCallbackServers(accessTokenSupplier.get());
    }

    public GetCallbackSettings getCallbackSettings() {
        return new GetCallbackSettings(accessTokenSupplier.get());
    }

    public GetLongPollServer getLongPollServer() {
        return new GetLongPollServer(accessTokenSupplier.get());
    }

    public GetLongPollSettings getLongPollSettings() {
        return new GetLongPollSettings(accessTokenSupplier.get());
    }

    public GetMembers getMembers() {
        return new GetMembers(accessTokenSupplier.get());
    }

    public GetOnlineStatus getOnlineStatus() {
        return new GetOnlineStatus(accessTokenSupplier.get());
    }

    public GetTokenPermissions getTokenPermissions() {
        return new GetTokenPermissions(accessTokenSupplier.get());
    }

    public IsMember isMember() {
        return new IsMember(accessTokenSupplier.get());
    }

    public SetCallbackSettings setCallbackSettings() {
        return new SetCallbackSettings(accessTokenSupplier.get());
    }

    public SetLongPollSettings setLongPollSettings() {
        return new SetLongPollSettings(accessTokenSupplier.get());
    }

    public SetSettings setSettings() {
        return new SetSettings(accessTokenSupplier.get());
    }
}
