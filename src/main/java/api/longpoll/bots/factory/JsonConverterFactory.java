package api.longpoll.bots.factory;

import api.longpoll.bots.converter.Converter;

/**
 * A factory to build JSON converter.
 */
@FunctionalInterface
public interface JsonConverterFactory {
    /**
     * Gets JSON converter implementation.
     *
     * @param clazz destination POJO type.
     * @param <T>   destination POJO type.
     * @return JSON converter.
     */
    <T> Converter<String, T> get(Class<T> clazz);
}
