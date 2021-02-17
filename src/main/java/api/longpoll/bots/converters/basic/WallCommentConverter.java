package api.longpoll.bots.converters.basic;

import api.longpoll.bots.converters.JsonToPojoConverter;
import api.longpoll.bots.model.objects.basic.WallComment;
import api.longpoll.bots.utils.converters.AttachmentConverterUtil;
import com.google.gson.FieldAttributes;
import com.google.gson.JsonObject;

import java.util.List;

public class WallCommentConverter extends JsonToPojoConverter<WallComment> {
    @Override
    public WallComment convert(JsonObject jsonObject) {
        WallComment wallPost = gson.fromJson(jsonObject, WallComment.class);
        wallPost.setAttachments(AttachmentConverterUtil.extractAttachments(jsonObject));
        return wallPost;
    }

    @Override
    protected boolean shouldSkipField(FieldAttributes fieldAttributes) {
        return List.class.equals(fieldAttributes.getDeclaredClass())
                && "attachments".equals(fieldAttributes.getName());
    }
}
