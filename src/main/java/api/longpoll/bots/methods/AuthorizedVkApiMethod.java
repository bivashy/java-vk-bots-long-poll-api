package api.longpoll.bots.methods;

/**
 * Executes generic GET HTTP request to VK API.
 *
 * @param <Response> VK API response type.
 * @see VkApiMethod
 */
public abstract class AuthorizedVkApiMethod<Response> extends VkApiMethod<Response> {
    public AuthorizedVkApiMethod(String accessToken) {
        addParam("access_token", accessToken);
        addParam("v", VkApiProperties.get("api.version"));
    }
}
