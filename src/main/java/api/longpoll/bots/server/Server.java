package api.longpoll.bots.server;

import api.longpoll.bots.exceptions.BotsLongPollException;
import api.longpoll.bots.exceptions.BotsLongPollHttpException;
import api.longpoll.bots.model.events.Event;

import java.util.List;

public interface Server {
    List<Event> getUpdates() throws BotsLongPollHttpException, BotsLongPollException;
}
