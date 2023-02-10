package api.longpoll.bots.helpers.attachments;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * Supplies {@link UploadableFile} list.
 */
public class UploadableFilesSupplier implements Supplier<List<UploadableFile>> {
    /**
     * Receivers.
     */
    private final Set<Integer> peerIds = new HashSet<>();

    /**
     * {@link UploadableFile} factories.
     */
    private final List<Function<Integer, UploadableFile>> uploadableFileFactories = new ArrayList<>();

    /**
     * Adds receiver.
     *
     * @param peerId receiver ID.
     */
    public void addPeerId(int peerId) {
        peerIds.add(peerId);
    }

    /**
     * Adds receivers.
     *
     * @param peerIds receiver IDs.
     */
    public void addPeerIds(Iterable<Integer> peerIds) {
        StreamSupport.stream(peerIds.spliterator(), false).forEach(this::addPeerId);
    }

    /**
     * Adds {@link UploadableFile} factory.
     *
     * @param uploadableFileFactory {@link UploadableFile} factory.
     */
    public void addUploadbleFileFactory(Function<Integer, UploadableFile> uploadableFileFactory) {
        uploadableFileFactories.add(uploadableFileFactory);
    }

    @Override
    public List<UploadableFile> get() {
        return peerIds.stream()
                .flatMap(this::getUploadableFiles)
                .collect(Collectors.toList());
    }

    /**
     * Gets {@link Stream} of {@link UploadableFile} by receiver ID.
     *
     * @param peerId receiver ID.
     * @return {@link Stream} of {@link UploadableFile}.
     */
    private Stream<UploadableFile> getUploadableFiles(int peerId) {
        return uploadableFileFactories.stream()
                .map(messageFileUploaderFactory -> messageFileUploaderFactory.apply(peerId));
    }
}
