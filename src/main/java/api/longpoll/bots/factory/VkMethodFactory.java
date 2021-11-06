package api.longpoll.bots.factory;

import api.longpoll.bots.methods.impl.VkMethod;

public interface VkMethodFactory<Method extends VkMethod<?>> {
    Method get(String accessToken);
}
