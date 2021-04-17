package api.longpoll.bots.server;

import api.longpoll.bots.LongPollBot;
import api.longpoll.bots.exceptions.BotsLongPollAPIException;
import api.longpoll.bots.exceptions.BotsLongPollException;
import api.longpoll.bots.model.events.Event;

import java.util.List;

public class InitializedLongPollClient extends LongPollClient {
    private boolean firstCall = true;

    public InitializedLongPollClient(LongPollBot bot) {
        super(bot);
    }

    @Override
    public List<Event> getUpdates() throws BotsLongPollAPIException, BotsLongPollException {
        if (firstCall) {
            init();
            firstCall = false;
        }
        return super.getUpdates();
    }
}
