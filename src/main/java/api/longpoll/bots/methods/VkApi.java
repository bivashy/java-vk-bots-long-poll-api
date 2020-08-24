package api.longpoll.bots.methods;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class VkApi {
	private static final Logger log = LoggerFactory.getLogger(VkApi.class);
	private static final String PROPERTIES_FILE = "api/vk/API.properties";
	private static VkApi instance = new VkApi();
	private Properties properties = new Properties();

	private VkApi() {
		try (InputStream inputStream = new FileInputStream(PROPERTIES_FILE)) {
			properties.load(inputStream);
		} catch (IOException e) {
			log.error("Failed to read {}.", PROPERTIES_FILE, e);
		}
	}

	public static VkApi getInstance() {
		return instance;
	}

	public String boardDeleteComment() {
		return properties.getProperty("board.deleteComment");
	}

	public String boardRestoreComment() {
		return properties.getProperty("board.restoreComment");
	}

	public String docsGetMessagesUploadServer() {
		return properties.getProperty("docs.getMessagesUploadServer");
	}

	public String docsGetWallUploadServer() {
		return properties.getProperty("docs.getWallUploadServer");
	}

	public String docsSave() {
		return properties.getProperty("docs.save");
	}

	public String docsSearch() {
		return properties.getProperty("docs.search");
	}

	public String groupsAddAddress() {
		return properties.getProperty("groups.addAddress");
	}

	public String groupsAddCallbackServer() {
		return properties.getProperty("groups.addCallbackServer");
	}

	public String groupsDeleteAddress() {
		return properties.getProperty("groups.deleteAddress");
	}

	public String groupsDeleteCallbackServer() {
		return properties.getProperty("groups.deleteCallbackServer");
	}

	public String groupsDisableOnline() {
		return properties.getProperty("groups.disableOnline");
	}

	public String groupsEditAddress() {
		return properties.getProperty("groups.editAddress");
	}

	public String groupsEditCallbackServer() {
		return properties.getProperty("groups.editCallbackServer");
	}

	public String groupsEnableOnline() {
		return properties.getProperty("groups.enableOnline");
	}

	public String groupsGetBanned() {
		return properties.getProperty("groups.getBanned");
	}

	public String groupsGetById() {
		return properties.getProperty("groups.getById");
	}

	public String groupsGetCallbackConfirmationCode() {
		return properties.getProperty("groups.getCallbackConfirmationCode");
	}

	public String groupsGetCallbackServers() {
		return properties.getProperty("groups.getCallbackServers");
	}

	public String groupsGetCallbackSettings() {
		return properties.getProperty("groups.getCallbackSettings");
	}

	public String groupsGetLongPollServer() {
		return properties.getProperty("groups.getLongPollServer");
	}

	public String groupsGetLongPollSettings() {
		return properties.getProperty("groups.getLongPollSettings");
	}

	public String groupsGetMembers() {
		return properties.getProperty("groups.getMembers");
	}

	public String groupsGetOnlineStatus() {
		return properties.getProperty("groups.getOnlineStatus");
	}

	public String groupsGetTokenPermissions() {
		return properties.getProperty("groups.getTokenPermissions");
	}

	public String groupsIsMember() {
		return properties.getProperty("groups.isMember");
	}

	public String groupsSetCallbackSettings() {
		return properties.getProperty("groups.setCallbackSettings");
	}

	public String groupsSetLongPollSettings() {
		return properties.getProperty("groups.setLongPollSettings");
	}

	public String groupsSetSettings() {
		return properties.getProperty("groups.setSettings");
	}

	public String marketGetGroupOrders() {
		return properties.getProperty("market.getGroupOrders");
	}

	public String messagesCreateChat() {
		return properties.getProperty("messages.createChat");
	}

	public String messagesDelete() {
		return properties.getProperty("messages.delete");
	}

	public String messagesDeleteChatPhoto() {
		return properties.getProperty("messages.deleteChatPhoto");
	}

	public String messagesDeleteConversation() {
		return properties.getProperty("messages.deleteConversation");
	}

	public String messagesEdit() {
		return properties.getProperty("messages.edit");
	}

	public String messagesEditChat() {
		return properties.getProperty("messages.editChat");
	}

	public String messagesGetByConversationMessageId() {
		return properties.getProperty("messages.getByConversationMessageId");
	}

	public String messagesGetById() {
		return properties.getProperty("messages.getById");
	}

	public String messagesGetConversationMembers() {
		return properties.getProperty("messages.getConversationMembers");
	}

	public String messagesGetConversations() {
		return properties.getProperty("messages.getConversations");
	}

	public String messagesGetConversationsById() {
		return properties.getProperty("messages.getConversationsById");
	}

	public String messagesGetHistory() {
		return properties.getProperty("messages.getHistory");
	}

	public String messagesGetHistoryAttachments() {
		return properties.getProperty("messages.getHistoryAttachments");
	}

	public String messagesGetInviteLink() {
		return properties.getProperty("messages.getInviteLink");
	}

	public String messagesMarkAsAnsweredConversation() {
		return properties.getProperty("messages.markAsAnsweredConversation");
	}

	public String messagesMarkAsImportantConversation() {
		return properties.getProperty("messages.markAsImportantConversation");
	}

	public String messagesMarkAsRead() {
		return properties.getProperty("messages.markAsRead");
	}

	public String messagesPin() {
		return properties.getProperty("messages.pin");
	}

	public String messagesRemoveChatUser() {
		return properties.getProperty("messages.removeChatUser");
	}

	public String messagesRestore() {
		return properties.getProperty("messages.restore");
	}

	public String messagesSearchConversations() {
		return properties.getProperty("messages.searchConversations");
	}

	public String messagesSend() {
		return properties.getProperty("messages.send");
	}

	public String photosGetMessagesUploadServer() {
		return properties.getProperty("photos.getMessagesUploadServer");
	}

	public String photosGetOwnerCoverPhotoUploadServer() {
		return properties.getProperty("photos.getOwnerCoverPhotoUploadServer");
	}

	public String photosSaveMessagesPhoto() {
		return properties.getProperty("photos.saveMessagesPhoto");
	}

	public String photosSaveOwnerCoverPhoto() {
		return properties.getProperty("photos.saveOwnerCoverPhoto");
	}

	public String usersGet() {
		return properties.getProperty("users.get");
	}

	public String utilsCheckLink() {
		return properties.getProperty("utils.checkLink");
	}

	public String utilsGetLinkStats() {
		return properties.getProperty("utils.getLinkStats");
	}

	public String utilsGetServerTime() {
		return properties.getProperty("utils.getServerTime");
	}

	public String utilsGetShortLink() {
		return properties.getProperty("utils.getShortLink");
	}

	public String utilsResolveScreenName() {
		return properties.getProperty("utils.resolveScreenName");
	}

	public String wallCloseComments() {
		return properties.getProperty("wall.closeComments");
	}

	public String wallCreateComment() {
		return properties.getProperty("wall.createComment");
	}

	public String wallOpenComments() {
		return properties.getProperty("wall.openComments");
	}
}
