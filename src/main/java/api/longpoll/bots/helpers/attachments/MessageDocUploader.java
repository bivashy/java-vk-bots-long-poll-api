package api.longpoll.bots.helpers.attachments;

import api.longpoll.bots.exceptions.VkApiException;
import api.longpoll.bots.methods.impl.docs.GetMessagesUploadServer;
import api.longpoll.bots.methods.impl.docs.Save;
import api.longpoll.bots.methods.impl.upload.UploadDoc;
import api.longpoll.bots.model.objects.additional.UploadedFile;
import api.longpoll.bots.model.objects.media.Doc;

import java.util.concurrent.CompletableFuture;
import java.util.function.Function;

public class MessageDocUploader implements MessageFileUploader {
    private final GetMessagesUploadServer getMessagesUploadServer;
    private final Save save;
    private final Function<String, UploadDoc> uploadDocFactory;

    public MessageDocUploader(String accessToken, int peerId, Function<String, UploadDoc> uploadDocFactory) {
        this.getMessagesUploadServer = new GetMessagesUploadServer(accessToken).setType("doc").setPeerId(peerId);
        this.save = new Save(accessToken);
        this.uploadDocFactory = uploadDocFactory;
    }

    @Override
    public UploadedFile upload() throws VkApiException {
        String uploadUrl = getMessagesUploadServer.execute()
                .getResponse()
                .getUploadUrl();
        UploadDoc.ResponseBody upload = uploadDocFactory.apply(uploadUrl).execute();
        Doc doc = save.setFile(upload.getFile())
                .execute()
                .getResponse()
                .getDoc();
        return new UploadedFile("doc", doc.getOwnerId(), doc.getId(), doc.getAccessKey());
    }

    @Override
    public CompletableFuture<UploadedFile> uploadAsync() {
        return getMessagesUploadServer.executeAsync()
                .thenApply(uploadServer -> uploadServer.getResponse().getUploadUrl())
                .thenCompose(uploadUrl -> uploadDocFactory.apply(uploadUrl).executeAsync())
                .thenCompose(upload -> save.setFile(upload.getFile()).executeAsync())
                .thenApply(savedDoc -> savedDoc.getResponse().getDoc())
                .thenApply(doc -> new UploadedFile("doc", doc.getOwnerId(), doc.getId(), doc.getAccessKey()));
    }
}
