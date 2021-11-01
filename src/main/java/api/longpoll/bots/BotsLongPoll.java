package api.longpoll.bots;

import api.longpoll.bots.client.DefaultLongPollClient;
import api.longpoll.bots.client.LongPollClient;
import api.longpoll.bots.exceptions.VkApiException;
import api.longpoll.bots.handlers.update.LongPollBotEventHandler;
import api.longpoll.bots.handlers.update.VkEventHandler;
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
    private final LongPollBot bot;

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
     * @throws VkApiException if errors occur.
     */
    public void run() throws VkApiException {
        run(0);
    }

    /**
     * Starts listening to VK server with delay.
     *
     * @param delay listening delay.
     * @throws VkApiException if errors occur.
     */
    public void run(long delay) throws VkApiException {
        log.debug("Starting bot [group_id = {}]...", bot.getGroupId());
        while (running && sleep(delay)) {
            getVkEventHandler().handle(getLongPollClient().getEvents());
        }
    }

    private boolean sleep(long delay) throws VkApiException {
        try {
            Thread.sleep(delay);
            return true;
        } catch (InterruptedException e) {
            throw new VkApiException(e);
        }
    }

    public void stop() {
        running = false;
    }

    public LongPollClient getLongPollClient() {
        if (longPollClient == null) {
            longPollClient = new DefaultLongPollClient(bot);
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
