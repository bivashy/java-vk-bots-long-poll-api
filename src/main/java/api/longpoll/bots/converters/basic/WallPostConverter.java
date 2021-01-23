package api.longpoll.bots.converters.basic;

import api.longpoll.bots.converters.JsonToPojoConverter;
import api.longpoll.bots.model.objects.basic.WallPost;
import api.longpoll.bots.utils.converters.AttachmentConverterUtil;
import com.google.gson.FieldAttributes;
import com.google.gson.JsonObject;

import java.util.List;

public class WallPostConverter extends JsonToPojoConverter<WallPost> {
    @Override
    public WallPost convert(JsonObject jsonObject) {
        WallPost wallPost = gson.fromJson(jsonObject, WallPost.class);
        wallPost.setAttachments(AttachmentConverterUtil.extractAttachments(jsonObject));
        return wallPost;
    }

    @Override
    protected boolean shouldSkipField(FieldAttributes fieldAttributes) {
        return List.class.equals(fieldAttributes.getDeclaredClass())
                && "attachments".equals(fieldAttributes.getName());
    }
}
