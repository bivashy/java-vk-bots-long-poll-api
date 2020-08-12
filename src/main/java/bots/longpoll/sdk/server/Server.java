package bots.longpoll.sdk.server;

import bots.longpoll.sdk.exceptions.ApiHttpException;
import bots.longpoll.sdk.model.update.Update;

import java.util.List;

public interface Server {
	List<Update> getUpdates() throws ApiHttpException;
}
