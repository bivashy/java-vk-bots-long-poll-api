package api.longpoll.bots.converter;

public interface Converter<From, To> {
    To convert(From from);
}
