package api.longpoll.bots.utils.converters;

import api.longpoll.bots.converters.JsonToPojoConverter;
import api.longpoll.bots.converters.media.AttachmentConverter;
import api.longpoll.bots.model.objects.media.Attachment;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class AttachmentConverterUtil {
    private static final JsonToPojoConverter<Attachment> ATTACHMENT_CONVERTER = new AttachmentConverter();

    public static List<Attachment> extractAttachments(JsonObject jsonObject) {
        return !jsonObject.has("attachments")
                ? null
                : toStream(extractJsonArray(jsonObject))
                    .map(JsonElement::getAsJsonObject)
                    .map(ATTACHMENT_CONVERTER::convert)
                    .collect(Collectors.toList());
    }

    private static JsonArray extractJsonArray(JsonObject jsonObject) {
        return jsonObject.getAsJsonArray("attachments");
    }

    private static Stream<JsonElement> toStream(JsonArray jsonArray) {
        return StreamSupport.stream(jsonArray.spliterator(), false);
    }
}
