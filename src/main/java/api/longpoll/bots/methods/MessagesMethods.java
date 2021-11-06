package api.longpoll.bots.methods;

import api.longpoll.bots.methods.impl.messages.AttachPhoto;
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

/**
 * Provides Messages methods.
 */
public class MessagesMethods {
    /**
     * Access token.
     */
    private final String accessToken;

    public MessagesMethods(String accessToken) {
        this.accessToken = accessToken;
    }

    public CreateChat createChat() {
        return new CreateChat(accessToken);
    }

    public Delete delete() {
        return new Delete(accessToken);
    }

    public DeleteConversation deleteConversation() {
        return new DeleteConversation(accessToken);
    }

    public DeleteChatPhoto deleteChatPhoto() {
        return new DeleteChatPhoto(accessToken);
    }

    public Edit edit() {
        return new Edit(accessToken);
    }

    public EditChat editChat() {
        return new EditChat(accessToken);
    }

    public GetByConversationMessageId getByConversationMessageId() {
        return new GetByConversationMessageId(accessToken);
    }

    public GetById getById() {
        return new GetById(accessToken);
    }

    public GetConversationMembers getConversationMembers() {
        return new GetConversationMembers(accessToken);
    }

    public GetConversations getConversations() {
        return new GetConversations(accessToken);
    }

    public GetConversationsById getConversationsById() {
        return new GetConversationsById(accessToken);
    }

    public GetHistory getHistory() {
        return new GetHistory(accessToken);
    }

    public GetHistoryAttachments getHistoryAttachments() {
        return new GetHistoryAttachments(accessToken);
    }

    public GetImportantMessages getImportantMessages() {
        return new GetImportantMessages(accessToken);
    }

    public GetInviteLink getInviteLink() {
        return new GetInviteLink(accessToken);
    }

    public IsMessagesFromGroupAllowed isMessagesFromGroupAllowed() {
        return new IsMessagesFromGroupAllowed(accessToken);
    }

    public MarkAsAnsweredConversation markAsAnsweredConversation() {
        return new MarkAsAnsweredConversation(accessToken);
    }

    public MarkAsImportantConversation markAsImportantConversation() {
        return new MarkAsImportantConversation(accessToken);
    }

    public MarkAsRead markAsRead() {
        return new MarkAsRead(accessToken);
    }

    public Pin pin() {
        return new Pin(accessToken);
    }

    public RemoveChatUser removeChatUser() {
        return new RemoveChatUser(accessToken);
    }

    public Restore restore() {
        return new Restore(accessToken);
    }

    public SearchConversations searchConversations() {
        return new SearchConversations(accessToken);
    }

    public Send send() {
        return new Send(accessToken);
    }

    public SendEventAnswer sendEventAnswer() {
        return new SendEventAnswer(accessToken);
    }

    public SetActivity setActivity() {
        return new SetActivity(accessToken);
    }

    public SetChatPhoto setChatPhoto() {
        return new SetChatPhoto(accessToken);
    }

    public Unpin unpin() {
        return new Unpin(accessToken);
    }

    public AttachPhoto attachPhoto() {
        return new AttachPhoto(accessToken);
    }
}
