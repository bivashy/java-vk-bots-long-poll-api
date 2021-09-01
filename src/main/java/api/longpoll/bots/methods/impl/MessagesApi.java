package api.longpoll.bots.methods.impl;

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
public class MessagesApi extends AbstractVkApi {
    public MessagesApi(String accessToken) {
        super(accessToken);
    }

    public CreateChat createChat() {
        return new CreateChat(getAccessToken());
    }

    public Delete delete() {
        return new Delete(getAccessToken());
    }

    public DeleteConversation deleteConversation() {
        return new DeleteConversation(getAccessToken());
    }

    public DeleteChatPhoto deleteChatPhoto() {
        return new DeleteChatPhoto(getAccessToken());
    }

    public Edit edit() {
        return new Edit(getAccessToken());
    }

    public EditChat editChat() {
        return new EditChat(getAccessToken());
    }

    public GetByConversationMessageId getByConversationMessageId() {
        return new GetByConversationMessageId(getAccessToken());
    }

    public GetById getById() {
        return new GetById(getAccessToken());
    }

    public GetConversationMembers getConversationMembers() {
        return new GetConversationMembers(getAccessToken());
    }

    public GetConversations getConversations() {
        return new GetConversations(getAccessToken());
    }

    public GetConversationsById getConversationsById() {
        return new GetConversationsById(getAccessToken());
    }

    public GetHistory getHistory() {
        return new GetHistory(getAccessToken());
    }

    public GetHistoryAttachments getHistoryAttachments() {
        return new GetHistoryAttachments(getAccessToken());
    }

    public GetImportantMessages getImportantMessages() {
        return new GetImportantMessages(getAccessToken());
    }

    public GetInviteLink getInviteLink() {
        return new GetInviteLink(getAccessToken());
    }

    public IsMessagesFromGroupAllowed isMessagesFromGroupAllowed() {
        return new IsMessagesFromGroupAllowed(getAccessToken());
    }

    public MarkAsAnsweredConversation markAsAnsweredConversation() {
        return new MarkAsAnsweredConversation(getAccessToken());
    }

    public MarkAsImportantConversation markAsImportantConversation() {
        return new MarkAsImportantConversation(getAccessToken());
    }

    public MarkAsRead markAsRead() {
        return new MarkAsRead(getAccessToken());
    }

    public Pin pin() {
        return new Pin(getAccessToken());
    }

    public RemoveChatUser removeChatUser() {
        return new RemoveChatUser(getAccessToken());
    }

    public Restore restore() {
        return new Restore(getAccessToken());
    }

    public SearchConversations searchConversations() {
        return new SearchConversations(getAccessToken());
    }

    public Send send() {
        return new Send(getAccessToken());
    }

    public SendEventAnswer sendEventAnswer() {
        return new SendEventAnswer(getAccessToken());
    }

    public SetActivity setActivity() {
        return new SetActivity(getAccessToken());
    }

    public SetChatPhoto setChatPhoto() {
        return new SetChatPhoto(getAccessToken());
    }

    public Unpin unpin() {
        return new Unpin(getAccessToken());
    }
}
