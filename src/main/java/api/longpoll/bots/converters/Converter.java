package api.longpoll.bots.converters;

public interface Converter<Source, Target> {
	Target convert(Source source);
}
