package api.longpoll.bots;

import api.longpoll.bots.exceptions.BotsLongPollException;
import api.longpoll.bots.handlers.update.LongPollBotEventHandler;
import api.longpoll.bots.handlers.update.VkEventHandler;
import api.longpoll.bots.server.LongPollClient;
import api.longpoll.bots.server.LongPollClientImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Bots Long Poll entry point. Takes {@link LongPollBot} and listens to VK server.
 */
public class BotsLongPoll {
    /**
     * Logger object.
     */
    private static final Logger log = LoggerFactory.getLogger(BotsLongPoll.class);

    /**
     * Infinite loop exit condition.
     */
    private boolean running = true;

    /**
     * Running bot.
     */
    private LongPollBot bot;

    /**
     *
     */
    private LongPollClient client;

    /**
     * Handles VK events.
     */
    private VkEventHandler vkEventHandler;

    public BotsLongPoll(LongPollBot bot) {
        this(bot, new LongPollClientImpl(bot), new LongPollBotEventHandler(bot));
    }

    public BotsLongPoll(LongPollBot bot, LongPollClient client, VkEventHandler vkEventHandler) {
        this.bot = bot;
        this.client = client;
        this.vkEventHandler = vkEventHandler;
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
        log.debug("Starting bot [group_id = {}]...", bot.getGroupId());
        while (running && sleep(delay)) {
            vkEventHandler.handle(client.getEvents());
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
