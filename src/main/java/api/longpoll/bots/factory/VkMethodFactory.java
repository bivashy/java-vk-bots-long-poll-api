package api.longpoll.bots.factory;

import api.longpoll.bots.methods.impl.VkMethod;

/**
 * Builds {@link VkMethod} implementation.
 *
 * @param <Method> {@link VkMethod} implementation type.
 */
@FunctionalInterface
public interface VkMethodFactory<Method extends VkMethod<?>> {
    /**
     * Gets {@link VkMethod} implementation.
     *
     * @param accessToken bot <i>access_token</i>.
     * @return {@link VkMethod} implementation.
     */
    Method get(String accessToken);
}
