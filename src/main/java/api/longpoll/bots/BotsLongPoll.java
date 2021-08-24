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
     * Listens to VK Long Poll events.
     */
    private LongPollClient longPollClient;

    /**
     * Handles VK events.
     */
    private VkEventHandler vkEventHandler;

    public BotsLongPoll(LongPollBot bot) {
        this.bot = bot;
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
            getVkEventHandler().handle(getLongPollClient().getEvents());
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

    public LongPollClient getLongPollClient() {
        if (longPollClient == null) {
            longPollClient = new LongPollClientImpl(bot);
        }
        return longPollClient;
    }

    public void setLongPollClient(LongPollClient longPollClient) {
        this.longPollClient = longPollClient;
    }

    public VkEventHandler getVkEventHandler() {
        if (vkEventHandler == null) {
            vkEventHandler = new LongPollBotEventHandler(bot);
        }
        return vkEventHandler;
    }

    public void setVkEventHandler(VkEventHandler vkEventHandler) {
        this.vkEventHandler = vkEventHandler;
    }
}
