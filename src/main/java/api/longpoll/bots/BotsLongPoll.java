package api.longpoll.bots;

import api.longpoll.bots.exceptions.BotsLongPollException;
import api.longpoll.bots.exceptions.BotsLongPollAPIException;
import api.longpoll.bots.server.LongPollServer;
import api.longpoll.bots.server.Server;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BotsLongPoll {
    private static final Logger log = LoggerFactory.getLogger(BotsLongPoll.class);
    private LongPollBot bot;
    private Server server;
    private UpdateHandler updateHandler;

    public BotsLongPoll(LongPollBot bot) {
        this.bot = bot;
        this.server = new LongPollServer(bot);
        this.updateHandler = new LongPollBotUpdateHandler(bot);
    }

    public void run() throws BotsLongPollAPIException, BotsLongPollException {
        log.debug("Starting bot with group_id = {}", bot.getGroupId());
        while (true) {
            updateHandler.handleUpdates(server.getUpdates());
        }
    }
}
