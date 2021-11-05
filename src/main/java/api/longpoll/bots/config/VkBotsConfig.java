package api.longpoll.bots.config;

import api.longpoll.bots.converter.Converter;
import api.longpoll.bots.converter.impl.BoolIntConverter;
import api.longpoll.bots.converter.impl.GsonConverter;
import api.longpoll.bots.converter.impl.ListConverter;
import api.longpoll.bots.converter.impl.VkAttachmentConverter;
import api.longpoll.bots.converter.impl.VkAttachmentsListConverter;
import api.longpoll.bots.factory.JsonConverterFactory;
import api.longpoll.bots.model.objects.additional.VkAttachment;
import com.google.gson.Gson;

import java.util.List;

public class VkBotsConfig {
    private static final VkBotsConfig INSTANCE = new VkBotsConfig();
    private Converter<Boolean, Integer> boolIntConverter;
    private Converter<List<?>, String> listConverter;
    private Converter<VkAttachment, String> vkAttachmentConverter;
    private Converter<List<VkAttachment>, List<String>> vkAttachmentsListConverterConverter;
    private Gson gson;
    private JsonConverterFactory jsonConverterFactory;

    private VkBotsConfig() {
    }

    public static VkBotsConfig getInstance() {
        return INSTANCE;
    }

    public Converter<Boolean, Integer> getBoolIntConverter() {
        if (boolIntConverter == null) {
            boolIntConverter = new BoolIntConverter();
        }
        return boolIntConverter;
    }

    public void setBoolIntConverter(Converter<Boolean, Integer> boolIntConverter) {
        this.boolIntConverter = boolIntConverter;
    }

    public Converter<List<?>, String> getListConverter() {
        if (listConverter == null) {
            listConverter = new ListConverter();
        }
        return listConverter;
    }

    public void setListConverter(Converter<List<?>, String> listConverter) {
        this.listConverter = listConverter;
    }

    public Converter<VkAttachment, String> getVkAttachmentConverter() {
        if (vkAttachmentConverter == null) {
            vkAttachmentConverter = new VkAttachmentConverter();
        }
        return vkAttachmentConverter;
    }

    public void setVkAttachmentConverter(Converter<VkAttachment, String> vkAttachmentConverter) {
        this.vkAttachmentConverter = vkAttachmentConverter;
    }

    public Converter<List<VkAttachment>, List<String>> getVkAttachmentsListConverterConverter() {
        if (vkAttachmentsListConverterConverter == null) {
            vkAttachmentsListConverterConverter = new VkAttachmentsListConverter();
        }
        return vkAttachmentsListConverterConverter;
    }

    public void setVkAttachmentsListConverterConverter(Converter<List<VkAttachment>, List<String>> vkAttachmentsListConverterConverter) {
        this.vkAttachmentsListConverterConverter = vkAttachmentsListConverterConverter;
    }

    public Gson getGson() {
        if (gson == null) {
            gson = new Gson();
        }
        return gson;
    }

    public void setGson(Gson gson) {
        this.gson = gson;
    }

    public JsonConverterFactory getJsonConverterFactory() {
        if (jsonConverterFactory == null) {
            jsonConverterFactory = GsonConverter::new;
        }
        return jsonConverterFactory;
    }

    public void setJsonConverterFactory(JsonConverterFactory jsonConverterFactory) {
        this.jsonConverterFactory = jsonConverterFactory;
    }
}
