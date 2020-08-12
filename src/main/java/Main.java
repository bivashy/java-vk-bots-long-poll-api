import bots.longpoll.sdk.BotsLongPoll;
import bots.longpoll.sdk.LongPollBot;
import bots.longpoll.sdk.exceptions.ApiHttpException;
import bots.longpoll.sdk.executors.board.BoardDeleteComment;
import bots.longpoll.sdk.executors.board.BoardRestoreComment;
import bots.longpoll.sdk.executors.docs.DocsSearch;
import bots.longpoll.sdk.executors.groups.GroupsAddAddress;
import bots.longpoll.sdk.executors.groups.GroupsDeleteAddress;
import bots.longpoll.sdk.executors.messages.MessageUploadPhoto;
import bots.longpoll.sdk.executors.messages.MessagesSend;
import bots.longpoll.sdk.executors.photos.PhotosGetMessagesUploadServer;
import bots.longpoll.sdk.model.board.BoardPostDeleteUpdate;
import bots.longpoll.sdk.model.board.BoardPostUpdate;
import bots.longpoll.sdk.model.document.DocsSearchResponse;
import bots.longpoll.sdk.model.groups.GroupsAddAddressResponse;
import bots.longpoll.sdk.model.groups.GroupsDeleteAddressResponse;
import bots.longpoll.sdk.model.messages.Message;
import bots.longpoll.sdk.model.messages.MessageUpdate;
import bots.longpoll.sdk.model.messages.MessageUploadPhotoResponse;
import bots.longpoll.sdk.model.photos.PhotosGetMessagesUploadServerResponse;
import org.slf4j.impl.SimpleLogger;

import java.io.File;

public class Main {
	private static BotsLongPoll botsLongPoll;
	private static class MyBot extends LongPollBot {
		@Override
		public void onMessageNew(MessageUpdate messageUpdate) {
			try {
				File photo = new File("screenshot.png");

				GroupsAddAddressResponse addAddressResponse = new GroupsAddAddress(this)
						.setGroupId(getGroupId())
						.setTitle("test")
						.setAddress("test addr")
						.setCountryId(1)
						.setCityId(1)
						.setLatitude(50)
						.setLongitude(50)
						.execute();

				GroupsDeleteAddressResponse deleteAddressResponse = new GroupsDeleteAddress(this)
						.setGroupId(getGroupId())
						.setAddressId(1)
						.execute();

				new MessagesSend(this)
						.setPeerId(messageUpdate.getMessage().getPeerId())
						.setMessage("answer")
						.execute();

			} catch (ApiHttpException e) {
				e.printStackTrace();
			}
		}

		@Override
		public void onBoardPostNew(BoardPostUpdate boardPostUpdate) {
			try {
				new BoardDeleteComment(this)
						.setCommentId(boardPostUpdate.getId())
						.setGroupId(getGroupId())
						.setTopicId(boardPostUpdate.getTopicId())
						.execute();
			} catch (ApiHttpException e) {
				e.printStackTrace();
			}
		}

		@Override
		public void onBoardPostDelete(BoardPostDeleteUpdate boardPostDeleteUpdate) {
			try {
				new BoardRestoreComment(this)
						.setCommentId(boardPostDeleteUpdate.getId())
						.setGroupId(getGroupId())
						.setTopicId(boardPostDeleteUpdate.getTopicId())
						.execute();
			} catch (ApiHttpException e) {
				e.printStackTrace();
			}
		}

		@Override
		public String getAccessToken() {
			return System.getenv("access_token");
		}

		@Override
		public String getApiVersion() {
			return System.getenv("v");
		}

		@Override
		public int getGroupId() {
			return Integer.parseInt(System.getenv("group_id"));
		}
	}

	public static void main(String[] args) {
		System.setProperty(SimpleLogger.DEFAULT_LOG_LEVEL_KEY, "DEBUG");
		botsLongPoll = new BotsLongPoll(new MyBot());
		botsLongPoll.run();
	}
}
