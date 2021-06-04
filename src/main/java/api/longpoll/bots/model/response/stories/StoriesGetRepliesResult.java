package api.longpoll.bots.model.response.stories;

import api.longpoll.bots.model.objects.additional.StoriesFeedBlock;
import api.longpoll.bots.model.response.ExtendedVkList;
import api.longpoll.bots.model.response.GenericResult;

/**
 * Response to <b>stories.getReplies</b>
 */
public class StoriesGetRepliesResult extends GenericResult<ExtendedVkList<StoriesFeedBlock>> {
}
