package api.longpoll.bots.converters.params;

import api.longpoll.bots.exceptions.VkApiException;

import java.util.Map;

/**
 * Converts Object params to string values.
 */
public interface VkApiParamsConverter {
    /**
     * Converts Object params to string values.
     *
     * @param originalParams input params.
     * @return string params.
     * @throws VkApiException if errors occur.
     */
    Map<String, String> toStringParams(Map<String, Object> originalParams) throws VkApiException;
}
