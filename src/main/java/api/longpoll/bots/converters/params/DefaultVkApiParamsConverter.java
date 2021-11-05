package api.longpoll.bots.converters.params;

import api.longpoll.bots.exceptions.VkApiException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

/**
 * Default implementation of VK API params converter.
 */
public class DefaultVkApiParamsConverter implements VkApiParamsConverter {
    @Override
    public Map<String, String> toStringParams(Map<String, Object> originalParams) throws VkApiException {
        Map<String, String> params = new HashMap<>();
        for (Map.Entry<String, Object> entry : originalParams.entrySet()) {
            params.put(entry.getKey(), mapToString(entry.getValue()));
        }
        return params;
    }

    private String mapToString(Object value) throws VkApiException {
        if (value instanceof List) {
            return mapToString((List<?>) value);
        } else {
            return value.toString();
        }
    }

    private String mapToString(List<?> list) throws VkApiException {
        StringJoiner joiner = new StringJoiner(",");
        for (Object value : list) {
            if (value != null) {
                joiner.add(mapToString(value));
            }
        }
        return joiner.toString();
    }
}
