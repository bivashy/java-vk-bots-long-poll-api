package api.longpoll.bots;

import api.longpoll.bots.exceptions.BotsLongPollException;
import api.longpoll.bots.handlers.update.LongPollBotUpdateHandler;
import api.longpoll.bots.handlers.update.UpdateHandler;
import api.longpoll.bots.server.Client;
import api.longpoll.bots.server.InitializedLongPollClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Bots Long Poll entry point. Takes {@link LongPollBot} and listens to VK server.
 */
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

    /**
     * Starts listening to VK server.
     *
     * @throws BotsLongPollException if error occurs.
     */
    public void run() throws BotsLongPollException {
        log.debug("Starting bot with group_id = {}", bot.getGroupId());
        while (running) {
            updateHandler.handleUpdates(client.getUpdates());
        }
    }

    public void stop() {
        running = false;
    }
}
