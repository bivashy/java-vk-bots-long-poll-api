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
        run(0);
    }

    /**
     * Starts listening to VK server with delay.
     *
     * @param delay listening delay.
     * @throws BotsLongPollException if error occurs.
     */
    public void run(long delay) throws BotsLongPollException {
        log.debug("Starting bot with group_id = {}", bot.getGroupId());
        while (running && sleep(delay)) {
            updateHandler.handleUpdates(client.getUpdates());
        }
    }

    private boolean sleep(long delay) throws BotsLongPollException {
        try {
            Thread.sleep(delay);
            return true;
        } catch (InterruptedException e) {
            throw new BotsLongPollException(e);
        }
    }

    public void stop() {
        running = false;
    }
}
