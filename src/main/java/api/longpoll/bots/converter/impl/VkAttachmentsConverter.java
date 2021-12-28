package api.longpoll.bots.converter.impl;

import api.longpoll.bots.converter.Converter;
import api.longpoll.bots.model.objects.additional.VkAttachment;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Converts {@link VkAttachment} object to {@link String} value to pass to VK API method parameters.
 */
public class VkAttachmentsConverter implements Converter<List<VkAttachment>, List<String>> {
    /**
     * Converts {@link VkAttachment} object to {@link String} to pass to VK method parameters.
     */
    private final Converter<VkAttachment, String> vkAttachmentConverter = new VkAttachmentConverter();

    @Override
    public List<String> convert(List<VkAttachment> vkAttachments) {
        return vkAttachments.stream()
                .map(vkAttachmentConverter::convert)
                .collect(Collectors.toList());
    }
}
