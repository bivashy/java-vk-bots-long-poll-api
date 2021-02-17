package api.longpoll.bots.converters.response.groups;

import api.longpoll.bots.converters.JsonToPojoConverter;
import api.longpoll.bots.model.objects.additional.VkList;
import api.longpoll.bots.model.response.GenericResult;
import api.longpoll.bots.model.response.groups.GroupsGetMembersResponseItem;
import com.google.gson.FieldAttributes;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import java.util.List;

public class GroupsGetMembersResultConverter extends JsonToPojoConverter<GenericResult<VkList<GroupsGetMembersResponseItem>>> {
    @Override
    public GenericResult<VkList<GroupsGetMembersResponseItem>> convert(JsonObject jsonObject) {
        GenericResult<VkList<GroupsGetMembersResponseItem>> groupsGetMembers = gson.fromJson(jsonObject, new TypeToken<GenericResult<VkList<GroupsGetMembersResponseItem>>>(){}.getType());

        VkList<GroupsGetMembersResponseItem> response = groupsGetMembers.getResponse();
        JsonArray jsonArray = jsonObject.getAsJsonObject("response").getAsJsonArray("items");
        response.setItems(
                jsonArray.size() > 0 && jsonArray.get(0).isJsonObject()
                        ? gson.fromJson(jsonArray, new TypeToken<List<GroupsGetMembersResponseItem>>() {}.getType())
                        : gson.fromJson(jsonArray, new TypeToken<List<Integer>>() {}.getType())
        );

        return groupsGetMembers;
    }

    @Override
    protected boolean shouldSkipField(FieldAttributes fieldAttributes) {
        return List.class.equals(fieldAttributes.getDeclaredClass());
    }
}
