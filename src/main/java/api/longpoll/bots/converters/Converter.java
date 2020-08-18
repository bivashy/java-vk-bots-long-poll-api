package api.longpoll.bots.converters;

@FunctionalInterface
public interface Converter<From, To> {
	To convert(From from);
}
