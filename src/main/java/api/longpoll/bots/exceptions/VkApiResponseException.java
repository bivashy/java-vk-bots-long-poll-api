package api.longpoll.bots.exceptions;

/**
 * A checked exception occurs in <b>Java VK Bots Long Poll API</b> library when VK server returns error JSON.
 *
 * @see <a href="https://vk.com/dev/errors">List of possible errors.</a>
 */
public class VkApiResponseException extends VkApiException {
    public VkApiResponseException(String message) {
        super(message);
    }
}
