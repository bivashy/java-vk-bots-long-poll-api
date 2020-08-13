package api.longpoll.bots.methods;

public class VkApi {
	private static final String URL = "https://api.vk.com/method/";

	public static class Groups {
		private static final String METHOD = URL.concat("groups.");
		public static final String GET_LONG_POLL_SERVER = METHOD.concat("getLongPollServer");
		public static final String ADD_ADDRESS = METHOD.concat("addAddress");
		public static final String DELETE_ADDRESS = METHOD.concat("deleteAddress");
		public static final String ADD_CALLBACK_SERVER = METHOD.concat("addCallbackServer");
	}

	public static class Messages {
		private static final String METHOD = URL.concat("messages.");
		public static final String SEND = METHOD.concat("send");
	}

	public static class Photos {
		private static final String METHOD = URL.concat("photos.");
		public static final String GET_MESSAGE_UPLOAD_SERVER = METHOD.concat("getMessagesUploadServer");
		public static final String SAVE_MESSAGES_PHOTO = METHOD.concat("saveMessagesPhoto");
	}

	public static class Docs {
		private static final String METHOD = URL.concat("docs.");
		public static final String GET_MESSAGES_UPLOAD_SERVER = METHOD.concat("getMessagesUploadServer");
		public static final String SAVE = METHOD.concat("save");
		public static final String GET_WALL_UPLOAD_SERVER = METHOD.concat("getWallUploadServer");
		public static final String SEARCH = METHOD.concat("search");
	}

	public static class Board {
		private static final String METHOD = URL.concat("board.");
		public static final String DELETE_COMMENT = METHOD.concat("deleteComment");
		public static final String RESTORE_COMMENT = METHOD.concat("restoreComment");
	}
}
