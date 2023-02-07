package api.longpoll.bots.utils;

import java.util.List;
import java.util.stream.Collectors;

public class ParamUtils {
    public static String csv(List<?> values) {
        return values.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(","));
    }
}
