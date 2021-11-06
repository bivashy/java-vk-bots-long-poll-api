package api.longpoll.bots.converter.impl;

import api.longpoll.bots.converter.Converter;
import api.longpoll.bots.model.objects.additional.VkAttachment;

/**
 * Converts {@link VkAttachment} object to {@link String} to pass to VK method parameters.
 */
public class VkAttachmentConverter implements Converter<VkAttachment, String> {
    @Override
    public String convert(VkAttachment vkAttachment) {
        return vkAttachment.getType() + vkAttachment.getOwnerId() + "_" + vkAttachment.getMediaId() + (vkAttachment.getAccessKey() != null ? "_" + vkAttachment.getAccessKey() : "");
    }
}
