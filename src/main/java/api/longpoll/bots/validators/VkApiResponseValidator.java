package api.longpoll.bots.validators;

/**
 * VK API response validator.
 */
@FunctionalInterface
public interface VkApiResponseValidator {
    /**
     * Checks whether VK API response represented by JSON is valid
     *
     * @param json JSON to be validated.
     * @return <b>true</b> if response is valid, and <b>false</b> otherwise.
     */
    boolean isValid(String json);
}
