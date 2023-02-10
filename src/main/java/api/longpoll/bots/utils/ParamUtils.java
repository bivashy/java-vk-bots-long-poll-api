package api.longpoll.bots.utils;

import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * Param utils.
 */
public class ParamUtils {
    /**
     * Converts values into CSV-formatted string.
     *
     * @param values values to convert.
     * @return CSV-formatted string.
     */
    public static String csv(Iterable<?> values) {
        return StreamSupport.stream(values.spliterator(), false)
                .map(String::valueOf)
                .collect(Collectors.joining(","));
    }
}
