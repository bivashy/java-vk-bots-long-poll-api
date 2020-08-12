package api.longpoll.bots.converters;

public interface Converter<From, To> {
	To convert(From from);
}
