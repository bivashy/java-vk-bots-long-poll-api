package bots.longpoll.sdk.converters;

public interface Converter<Source, Target> {
	Target convert(Source source);
}
