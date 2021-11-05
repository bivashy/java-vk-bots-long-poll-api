package api.longpoll.bots.factory;

import api.longpoll.bots.converter.Converter;

@FunctionalInterface
public interface JsonConverterFactory {
    <T> Converter<String, T> get(Class<T> clazz);
}
