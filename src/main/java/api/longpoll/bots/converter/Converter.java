package api.longpoll.bots.converter;

/**
 * Convert value from one type to another.
 *
 * @param <From> original type.
 * @param <To>   destination type.
 */
@FunctionalInterface
public interface Converter<From, To> {
    /**
     * Converts specified object to another type.
     *
     * @param from original object.
     * @return converted object.
     */
    To convert(From from);
}
