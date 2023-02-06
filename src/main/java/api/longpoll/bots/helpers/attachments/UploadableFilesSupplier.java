package api.longpoll.bots.helpers.attachments;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class UploadableFilesSupplier implements Supplier<List<UploadableFile>> {
    private final List<Integer> peerIds = new ArrayList<>();
    private final List<Function<Integer, UploadableFile>> uploadableFileFactories = new ArrayList<>();

    public void addPeerId(int peerId) {
        peerIds.add(peerId);
    }

    public void addPeerIds(List<Integer> peerIds) {
        this.peerIds.addAll(peerIds);
    }

    public void addUploadbleFileFactory(Function<Integer, UploadableFile> uploadableFileFactory) {
        uploadableFileFactories.add(uploadableFileFactory);
    }

    @Override
    public List<UploadableFile> get() {
        return peerIds.stream()
                .flatMap(this::getUploadableFiles)
                .collect(Collectors.toList());
    }

    private Stream<UploadableFile> getUploadableFiles(int peerId) {
        return uploadableFileFactories.stream()
                .map(messageFileUploaderFactory -> messageFileUploaderFactory.apply(peerId));
    }
}
