package api.longpoll.bots.helpers.attachments;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Supplies {@link List<UploadableFile>}.
 */
public class UploadableFilesSupplier implements Supplier<List<UploadableFile>> {
    /**
     * List of {@code peer_id}.
     */
    private final List<Integer> peerIds = new ArrayList<>();

    /**
     * List of {@link UploadableFile} factories.
     */
    private final List<Function<Integer, UploadableFile>> uploadableFileFactories = new ArrayList<>();

    /**
     * Adds {@code peer_id} to the list.
     *
     * @param peerId message {@code peer_id}.
     */
    public void addPeerId(Integer peerId) {
        this.peerIds.add(peerId);
    }

    /**
     * Adds list of {@code peer_id} to the list.
     *
     * @param peerIds list of message {@code peer_id}.
     */
    public void addPeerIds(List<Integer> peerIds) {
        this.peerIds.addAll(peerIds);
    }

    /**
     * Adds {@link UploadableFile} factory to the list.
     *
     * @param uploadableFileFactory {@link UploadableFile} factory.
     */
    public void addUploadableFileFactory(Function<Integer, UploadableFile> uploadableFileFactory) {
        this.uploadableFileFactories.add(uploadableFileFactory);
    }

    /**
     * Gets {@link Stream<UploadableFile>}.
     *
     * @param peerId message {@code peer_id}.
     * @return {@link Stream<UploadableFile>}.
     */
    private Stream<UploadableFile> getUploadableFiles(Integer peerId) {
        return uploadableFileFactories.stream()
                .map(uploadableFileFactory -> uploadableFileFactory.apply(peerId));
    }

    @Override
    public List<UploadableFile> get() {
        return peerIds.stream()
                .flatMap(this::getUploadableFiles)
                .collect(Collectors.toList());
    }
}
