package api.longpoll.bots.converters.json;

/**
 * Json converter.
 */
public interface JsonConverter {
    /**
     * Converts JSON string to a POJO.
     *
     * @param json  JSON string.
     * @param clazz POJO class.
     * @param <T>   POJO type.
     * @return POJO converted from JSON.
     */
    <T> T convert(String json, Class<T> clazz);
}
