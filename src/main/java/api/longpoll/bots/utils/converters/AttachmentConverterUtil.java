package api.longpoll.bots.utils.converters;

import api.longpoll.bots.converters.JsonToPojoConverter;
import api.longpoll.bots.converters.media.AttachmentConverter;
import api.longpoll.bots.model.objects.media.Attachment;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.List;

public class AttachmentConverterUtil {
    private static final JsonToPojoConverter<Attachment> ATTACHMENT_CONVERTER = new AttachmentConverter();

    public static List<Attachment> extractAttachments(JsonObject jsonObject) {
        return jsonObject.has("attachments")
                ? BulkConverterUtil.convert(extractJsonArray(jsonObject), ATTACHMENT_CONVERTER)
                : null;
    }

    private static JsonArray extractJsonArray(JsonObject jsonObject) {
        return jsonObject.getAsJsonArray("attachments");
    }
}
