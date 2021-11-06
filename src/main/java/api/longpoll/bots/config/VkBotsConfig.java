package api.longpoll.bots.config;

import api.longpoll.bots.async.AsyncCaller;
import api.longpoll.bots.async.DefaultAsyncCaller;
import api.longpoll.bots.converter.Converter;
import api.longpoll.bots.converter.impl.BoolIntConverter;
import api.longpoll.bots.converter.impl.GsonConverter;
import api.longpoll.bots.converter.impl.ListConverter;
import api.longpoll.bots.converter.impl.VkAttachmentConverter;
import api.longpoll.bots.converter.impl.VkAttachmentsListConverter;
import api.longpoll.bots.factory.JsonConverterFactory;
import api.longpoll.bots.factory.VkMethodFactory;
import api.longpoll.bots.http.HttpClient;
import api.longpoll.bots.http.impl.JsoupHttpClient;
import api.longpoll.bots.methods.impl.photos.GetMessagesUploadServer;
import api.longpoll.bots.methods.impl.photos.SaveMessagesPhoto;
import api.longpoll.bots.methods.impl.upload.UploadPhoto;
import api.longpoll.bots.model.objects.additional.VkAttachment;
import api.longpoll.bots.validator.Validator;
import api.longpoll.bots.validator.VkResponseValidator;
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
    private Validator<String> vkResponseValidator;
    private HttpClient httpClient;
    private AsyncCaller asyncCaller;
    private String apiVersion;
    private VkMethodFactory<GetMessagesUploadServer> photosGetMessagesUploadFactory;
    private UploadPhoto uploadPhoto;
    private VkMethodFactory<SaveMessagesPhoto> saveMessagePhotoFactory;

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

    public Validator<String> getVkResponseValidator() {
        if (vkResponseValidator == null) {
            vkResponseValidator = new VkResponseValidator();
        }
        return vkResponseValidator;
    }

    public void setVkResponseValidator(Validator<String> vkResponseValidator) {
        this.vkResponseValidator = vkResponseValidator;
    }

    public HttpClient getHttpClient() {
        if (httpClient == null) {
            httpClient = new JsoupHttpClient();
        }
        return httpClient;
    }

    public void setHttpClient(HttpClient httpClient) {
        this.httpClient = httpClient;
    }

    public AsyncCaller getAsyncCaller() {
        if (asyncCaller == null) {
            asyncCaller = new DefaultAsyncCaller();
        }
        return asyncCaller;
    }

    public void setAsyncCaller(AsyncCaller asyncCaller) {
        this.asyncCaller = asyncCaller;
    }

    public String getApiVersion() {
        if (apiVersion == null) {
            apiVersion = "5.131";
        }
        return apiVersion;
    }

    public void setApiVersion(String apiVersion) {
        this.apiVersion = apiVersion;
    }

    public VkMethodFactory<GetMessagesUploadServer> getPhotosGetMessagesUploadFactory() {
        if (photosGetMessagesUploadFactory == null) {
            photosGetMessagesUploadFactory = GetMessagesUploadServer::new;
        }
        return photosGetMessagesUploadFactory;
    }

    public void setPhotosGetMessagesUploadFactory(VkMethodFactory<GetMessagesUploadServer> photosGetMessagesUploadFactory) {
        this.photosGetMessagesUploadFactory = photosGetMessagesUploadFactory;
    }

    public UploadPhoto getUploadPhoto() {
        if (uploadPhoto == null) {
            uploadPhoto = new UploadPhoto();
        }
        return uploadPhoto;
    }

    public void setUploadPhoto(UploadPhoto uploadPhoto) {
        this.uploadPhoto = uploadPhoto;
    }

    public VkMethodFactory<SaveMessagesPhoto> getSaveMessagePhotoFactory() {
        if (saveMessagePhotoFactory == null) {
            saveMessagePhotoFactory = SaveMessagesPhoto::new;
        }
        return saveMessagePhotoFactory;
    }

    public void setSaveMessagePhotoFactory(VkMethodFactory<SaveMessagesPhoto> saveMessagePhotoFactory) {
        this.saveMessagePhotoFactory = saveMessagePhotoFactory;
    }
}
