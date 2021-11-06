package api.longpoll.bots.methods;

/**
 * Executes generic GET HTTP request to VK API.
 *
 * @param <Response> VK API response type.
 * @see VkMethod
 */
public abstract class AuthorizedVkMethod<Response> extends VkMethod<Response> {
    public AuthorizedVkMethod(String accessToken) {
        addParam("access_token", accessToken);
        addParam("v", VkApiProperties.get("api.version"));
    }
}
