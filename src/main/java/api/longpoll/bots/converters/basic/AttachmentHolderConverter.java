package api.longpoll.bots.converters.basic;

import api.longpoll.bots.converters.JsonToPojoConverter;
import api.longpoll.bots.model.objects.basic.AttachmentHolder;
import api.longpoll.bots.utils.converters.AttachmentConverterUtil;
import com.google.gson.FieldAttributes;
import com.google.gson.JsonObject;

import java.util.List;

public class AttachmentHolderConverter<T extends AttachmentHolder> extends JsonToPojoConverter<T> {
    private Class<T> clazz;

    private AttachmentHolderConverter(Class<T> clazz) {
        this.clazz = clazz;
    }

    public static <T extends AttachmentHolder> AttachmentHolderConverter<T> of(Class<T> clazz) {
        return new AttachmentHolderConverter<>(clazz);
    }

    @Override
    public T convert(JsonObject jsonObject) {
        T t = gson.fromJson(jsonObject, clazz);
        t.setAttachments(AttachmentConverterUtil.extractAttachments(jsonObject));
        return t;
    }

    @Override
    protected boolean shouldSkipField(FieldAttributes fieldAttributes) {
        return List.class.equals(fieldAttributes.getDeclaredClass())
                && "attachments".equals(fieldAttributes.getName());
    }
}
