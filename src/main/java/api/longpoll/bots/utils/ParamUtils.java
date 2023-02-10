package api.longpoll.bots.utils;

import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class ParamUtils {
    public static String csv(Iterable<?> values) {
        return StreamSupport.stream(values.spliterator(), false)
                .map(String::valueOf)
                .collect(Collectors.joining(","));
    }
}
