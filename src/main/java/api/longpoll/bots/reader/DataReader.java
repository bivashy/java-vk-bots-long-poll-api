package api.longpoll.bots.reader;

/**
 * Reads data by path.
 *
 * @param <T> data type.
 */
@FunctionalInterface
public interface DataReader<T> {
    /**
     * Reads data by path.
     *
     * @param path data path.
     * @return read data.
     */
    T read(String path);
}
