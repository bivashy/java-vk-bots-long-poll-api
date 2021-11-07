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
import api.longpoll.bots.factory.PropertiesFactory;
import api.longpoll.bots.factory.VkMethodFactory;
import api.longpoll.bots.http.HttpClient;
import api.longpoll.bots.http.impl.JsoupHttpClient;
import api.longpoll.bots.methods.impl.docs.Save;
import api.longpoll.bots.methods.impl.events.GetUpdates;
import api.longpoll.bots.methods.impl.groups.GetLongPollServer;
import api.longpoll.bots.methods.impl.photos.SaveMessagesPhoto;
import api.longpoll.bots.methods.impl.upload.UploadDoc;
import api.longpoll.bots.methods.impl.upload.UploadPhoto;
import api.longpoll.bots.model.objects.additional.VkAttachment;
import api.longpoll.bots.validator.Validator;
import api.longpoll.bots.validator.VkResponseValidator;
import com.google.gson.Gson;

import java.util.List;
import java.util.Properties;

/**
 * Holds the dependencies that are used in library. Implements singleton pattern.
 */
public class VkBotsConfig {
    /**
     * {@link VkBotsConfig} instance to implement singleton pattern.
     */
    private static final VkBotsConfig INSTANCE = new VkBotsConfig();

    /**
     * Converts <i>boolean</i> value to <i>integer</i> (0 or 1).
     */
    private Converter<Boolean, Integer> boolIntConverter;

    /**
     * Converts {@link List} object to {@link String} value to pass to VK API method parameters.
     */
    private Converter<List<?>, String> listConverter;

    /**
     * Converts {@link VkAttachment} object to {@link String} value to pass to VK API method parameters.
     */
    private Converter<VkAttachment, String> vkAttachmentConverter;

    /**
     * Converts a list of {@link VkAttachment} to list of {@link String}.
     */
    private Converter<List<VkAttachment>, List<String>> vkAttachmentsListConverterConverter;

    /**
     * {@link Gson} object.
     */
    private Gson gson;

    /**
     * A factory to get JSON converter.
     */
    private JsonConverterFactory jsonConverterFactory;

    /**
     * Validates VK API response.
     */
    private Validator<String> vkResponseValidator;

    /**
     * Executes HTTP requests.
     */
    private HttpClient httpClient;

    /**
     * Executes action asynchronously.
     */
    private AsyncCaller asyncCaller;

    /**
     * Current VK API version.
     */
    private String apiVersion;

    /**
     * A factory to get a link to upload photo to conversation.
     */
    private VkMethodFactory<api.longpoll.bots.methods.impl.photos.GetMessagesUploadServer> photosGetMessagesUploadServerFactory;

    /**
     * Uploads photo to VK server.
     */
    private UploadPhoto uploadPhoto;

    /**
     * Saves uploaded to conversation photo.
     */
    private VkMethodFactory<SaveMessagesPhoto> saveMessagePhotoFactory;

    /**
     * A factory to get a link to upload document to conversation.
     */
    private VkMethodFactory<api.longpoll.bots.methods.impl.docs.GetMessagesUploadServer> docsGetMessagesUploadServerFactory;

    /**
     * Uploads document to VK server.
     */
    private UploadDoc uploadDoc;

    /**
     * Saves uploaded to conversation document.
     */
    private VkMethodFactory<Save> docsSaveFactory;

    /**
     * Gets updates from VK server.
     */
    private GetUpdates getUpdates;

    /**
     * A factory to get VK long poll server.
     */
    private VkMethodFactory<GetLongPollServer> getLongPollServerFactory;

    /**
     * A factory to get a list of VK bot methods.
     */
    private PropertiesFactory botMethodsFactory;

    /**
     * List of VK bots methods.
     */
    private Properties botMethods;

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

    public VkMethodFactory<api.longpoll.bots.methods.impl.photos.GetMessagesUploadServer> getPhotosGetMessagesUploadServerFactory() {
        if (photosGetMessagesUploadServerFactory == null) {
            photosGetMessagesUploadServerFactory = api.longpoll.bots.methods.impl.photos.GetMessagesUploadServer::new;
        }
        return photosGetMessagesUploadServerFactory;
    }

    public void setPhotosGetMessagesUploadServerFactory(VkMethodFactory<api.longpoll.bots.methods.impl.photos.GetMessagesUploadServer> photosGetMessagesUploadServerFactory) {
        this.photosGetMessagesUploadServerFactory = photosGetMessagesUploadServerFactory;
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

    public VkMethodFactory<api.longpoll.bots.methods.impl.docs.GetMessagesUploadServer> getDocsGetMessagesUploadServerFactory() {
        if (docsGetMessagesUploadServerFactory == null) {
            docsGetMessagesUploadServerFactory = api.longpoll.bots.methods.impl.docs.GetMessagesUploadServer::new;
        }
        return docsGetMessagesUploadServerFactory;
    }

    public void setDocsGetMessagesUploadServerFactory(VkMethodFactory<api.longpoll.bots.methods.impl.docs.GetMessagesUploadServer> docsGetMessagesUploadServerFactory) {
        this.docsGetMessagesUploadServerFactory = docsGetMessagesUploadServerFactory;
    }

    public UploadDoc getUploadDoc() {
        if (uploadDoc == null) {
            uploadDoc = new UploadDoc();
        }
        return uploadDoc;
    }

    public void setUploadDoc(UploadDoc uploadDoc) {
        this.uploadDoc = uploadDoc;
    }

    public VkMethodFactory<Save> getDocsSaveFactory() {
        if (docsSaveFactory == null) {
            docsSaveFactory = Save::new;
        }
        return docsSaveFactory;
    }

    public void setDocsSaveFactory(VkMethodFactory<Save> docsSaveFactory) {
        this.docsSaveFactory = docsSaveFactory;
    }

    public GetUpdates getGetUpdates() {
        if (getUpdates == null) {
            getUpdates = new GetUpdates();
        }
        return getUpdates;
    }

    public void setGetUpdates(GetUpdates getUpdates) {
        this.getUpdates = getUpdates;
    }

    public VkMethodFactory<GetLongPollServer> getGetLongPollServerFactory() {
        if (getLongPollServerFactory == null) {
            getLongPollServerFactory = GetLongPollServer::new;
        }
        return getLongPollServerFactory;
    }

    public void setGetLongPollServerFactory(VkMethodFactory<GetLongPollServer> getLongPollServerFactory) {
        this.getLongPollServerFactory = getLongPollServerFactory;
    }

    public PropertiesFactory getBotMethodsFactory() {
        if (botMethodsFactory == null) {
            botMethodsFactory = new PropertiesFactory();
        }
        return botMethodsFactory;
    }

    public void setBotMethodsFactory(PropertiesFactory botMethodsFactory) {
        this.botMethodsFactory = botMethodsFactory;
    }

    public Properties getBotMethods() {
        if (botMethods == null) {
            botMethods = getBotMethodsFactory().get("/vk/bot_methods.properties");
        }
        return botMethods;
    }

    public void setBotMethods(Properties botMethods) {
        this.botMethods = botMethods;
    }
}
