package api.longpoll.bots.suppliers;

import java.util.function.Supplier;

/**
 * Supplies {@code peer_id} value.
 */
public class PeerIdSupplier implements Supplier<Integer> {
    /**
     * {@code peer_id} value.
     */
    private int peerId;

    /**
     * Supplies {@code peer_id} value.
     *
     * @return {@code peer_id} value.
     */
    @Override
    public Integer get() {
        return peerId;
    }

    /**
     * Sets {@code peer_id} value.
     *
     * @param peerId {@code peer_id} value.
     */
    public void setPeerId(int peerId) {
        this.peerId = peerId;
    }
}
