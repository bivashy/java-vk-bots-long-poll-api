package api.longpoll.bots.model.response.groups;

import api.longpoll.bots.model.objects.basic.Community;
import api.longpoll.bots.model.response.GenericResult;

import java.util.List;

/**
 * Response to <b>groups.getById</b> request.
 */
public class GroupsGetByIdResult extends GenericResult<List<Community>> {
}
