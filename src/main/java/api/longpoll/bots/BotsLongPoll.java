package api.longpoll.bots;

import api.longpoll.bots.exceptions.BotsLongPollAPIException;
import api.longpoll.bots.exceptions.BotsLongPollException;
import api.longpoll.bots.server.Client;
import api.longpoll.bots.server.InitializedLongPollClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BotsLongPoll {
    private static final Logger log = LoggerFactory.getLogger(BotsLongPoll.class);
    private boolean running = true;
    private LongPollBot bot;
    private Client client;
    private UpdateHandler updateHandler;

    public BotsLongPoll(LongPollBot bot) {
        this.bot = bot;
        this.client = new InitializedLongPollClient(bot);
        this.updateHandler = new LongPollBotUpdateHandler(bot);
    }

    public void run() throws BotsLongPollAPIException, BotsLongPollException {
        log.debug("Starting bot with group_id = {}", bot.getGroupId());
        while (running) {
            updateHandler.handleUpdates(client.getUpdates());
        }
    }

    public void stop() {
        running = false;
    }
}
