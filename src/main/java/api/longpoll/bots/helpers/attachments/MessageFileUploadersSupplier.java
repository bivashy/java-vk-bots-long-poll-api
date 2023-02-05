package api.longpoll.bots.helpers.attachments;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MessageFileUploadersSupplier implements Supplier<List<MessageFileUploader>> {
    private final List<Integer> peerIds = new ArrayList<>();
    private final List<Function<Integer, MessageFileUploader>> messageFileUploaderFactories = new ArrayList<>();

    public void addPeerId(int peerId) {
        peerIds.add(peerId);
    }

    public void addPeerIds(List<Integer> peerIds) {
        this.peerIds.addAll(peerIds);
    }

    public void addMessageFileUploaderFactory(Function<Integer, MessageFileUploader> messageFileUploaderFactory) {
        messageFileUploaderFactories.add(messageFileUploaderFactory);
    }

    @Override
    public List<MessageFileUploader> get() {
        return peerIds.stream()
                .flatMap(this::getMessageFileUploaders)
                .collect(Collectors.toList());
    }

    private Stream<MessageFileUploader> getMessageFileUploaders(int peerId) {
        return messageFileUploaderFactories.stream()
                .map(messageFileUploaderFactory -> messageFileUploaderFactory.apply(peerId));
    }
}
