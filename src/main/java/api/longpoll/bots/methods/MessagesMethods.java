package api.longpoll.bots.methods;

import api.longpoll.bots.methods.impl.messages.CreateChat;
import api.longpoll.bots.methods.impl.messages.Delete;
import api.longpoll.bots.methods.impl.messages.DeleteChatPhoto;
import api.longpoll.bots.methods.impl.messages.DeleteConversation;
import api.longpoll.bots.methods.impl.messages.Edit;
import api.longpoll.bots.methods.impl.messages.EditChat;
import api.longpoll.bots.methods.impl.messages.GetByConversationMessageId;
import api.longpoll.bots.methods.impl.messages.GetById;
import api.longpoll.bots.methods.impl.messages.GetConversationMembers;
import api.longpoll.bots.methods.impl.messages.GetConversations;
import api.longpoll.bots.methods.impl.messages.GetConversationsById;
import api.longpoll.bots.methods.impl.messages.GetHistory;
import api.longpoll.bots.methods.impl.messages.GetHistoryAttachments;
import api.longpoll.bots.methods.impl.messages.GetImportantMessages;
import api.longpoll.bots.methods.impl.messages.GetInviteLink;
import api.longpoll.bots.methods.impl.messages.IsMessagesFromGroupAllowed;
import api.longpoll.bots.methods.impl.messages.MarkAsAnsweredConversation;
import api.longpoll.bots.methods.impl.messages.MarkAsImportantConversation;
import api.longpoll.bots.methods.impl.messages.MarkAsRead;
import api.longpoll.bots.methods.impl.messages.Pin;
import api.longpoll.bots.methods.impl.messages.RemoveChatUser;
import api.longpoll.bots.methods.impl.messages.Restore;
import api.longpoll.bots.methods.impl.messages.SearchConversations;
import api.longpoll.bots.methods.impl.messages.Send;
import api.longpoll.bots.methods.impl.messages.SendEventAnswer;
import api.longpoll.bots.methods.impl.messages.SetActivity;
import api.longpoll.bots.methods.impl.messages.SetChatPhoto;
import api.longpoll.bots.methods.impl.messages.Unpin;

import java.util.function.Supplier;

/**
 * Provides Messages methods.
 */
public class MessagesMethods {
    /**
     * Access token.
     */
    private final Supplier<String> accessTokenSupplier;

    public MessagesMethods(Supplier<String> accessTokenSupplier) {
        this.accessTokenSupplier = accessTokenSupplier;
    }

    public CreateChat createChat() {
        return new CreateChat(accessTokenSupplier.get());
    }

    public Delete delete() {
        return new Delete(accessTokenSupplier.get());
    }

    public DeleteConversation deleteConversation() {
        return new DeleteConversation(accessTokenSupplier.get());
    }

    public DeleteChatPhoto deleteChatPhoto() {
        return new DeleteChatPhoto(accessTokenSupplier.get());
    }

    public Edit edit() {
        return new Edit(accessTokenSupplier.get());
    }

    public EditChat editChat() {
        return new EditChat(accessTokenSupplier.get());
    }

    public GetByConversationMessageId getByConversationMessageId() {
        return new GetByConversationMessageId(accessTokenSupplier.get());
    }

    public GetById getById() {
        return new GetById(accessTokenSupplier.get());
    }

    public GetConversationMembers getConversationMembers() {
        return new GetConversationMembers(accessTokenSupplier.get());
    }

    public GetConversations getConversations() {
        return new GetConversations(accessTokenSupplier.get());
    }

    public GetConversationsById getConversationsById() {
        return new GetConversationsById(accessTokenSupplier.get());
    }

    public GetHistory getHistory() {
        return new GetHistory(accessTokenSupplier.get());
    }

    public GetHistoryAttachments getHistoryAttachments() {
        return new GetHistoryAttachments(accessTokenSupplier.get());
    }

    public GetImportantMessages getImportantMessages() {
        return new GetImportantMessages(accessTokenSupplier.get());
    }

    public GetInviteLink getInviteLink() {
        return new GetInviteLink(accessTokenSupplier.get());
    }

    public IsMessagesFromGroupAllowed isMessagesFromGroupAllowed() {
        return new IsMessagesFromGroupAllowed(accessTokenSupplier.get());
    }

    public MarkAsAnsweredConversation markAsAnsweredConversation() {
        return new MarkAsAnsweredConversation(accessTokenSupplier.get());
    }

    public MarkAsImportantConversation markAsImportantConversation() {
        return new MarkAsImportantConversation(accessTokenSupplier.get());
    }

    public MarkAsRead markAsRead() {
        return new MarkAsRead(accessTokenSupplier.get());
    }

    public Pin pin() {
        return new Pin(accessTokenSupplier.get());
    }

    public RemoveChatUser removeChatUser() {
        return new RemoveChatUser(accessTokenSupplier.get());
    }

    public Restore restore() {
        return new Restore(accessTokenSupplier.get());
    }

    public SearchConversations searchConversations() {
        return new SearchConversations(accessTokenSupplier.get());
    }

    public Send send() {
        return new Send(accessTokenSupplier.get());
    }

    public SendEventAnswer sendEventAnswer() {
        return new SendEventAnswer(accessTokenSupplier.get());
    }

    public SetActivity setActivity() {
        return new SetActivity(accessTokenSupplier.get());
    }

    public SetChatPhoto setChatPhoto() {
        return new SetChatPhoto(accessTokenSupplier.get());
    }

    public Unpin unpin() {
        return new Unpin(accessTokenSupplier.get());
    }
}
