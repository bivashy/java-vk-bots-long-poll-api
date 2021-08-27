package api.longpoll.bots.validators;

/**
 * Default implementation of VK API response validator.
 */
public class DefaultVkApiResponseValidator implements VkApiResponseValidator {
    @Override
    public boolean isValid(String json) {
        return !json.matches("\"error\"\\s*\\n*:") && !json.matches("\"failed\"\\s*\\n*:");
    }
}
