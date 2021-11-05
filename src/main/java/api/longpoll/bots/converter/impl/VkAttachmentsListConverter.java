package api.longpoll.bots.converter.impl;

import api.longpoll.bots.config.VkBotsConfig;
import api.longpoll.bots.converter.Converter;
import api.longpoll.bots.model.objects.additional.VkAttachment;

import java.util.List;
import java.util.stream.Collectors;

public class VkAttachmentsListConverter implements Converter<List<VkAttachment>, List<String>> {
    private final Converter<VkAttachment, String> vkAttachmentConverter = VkBotsConfig.getInstance().getVkAttachmentConverter();

    @Override
    public List<String> convert(List<VkAttachment> vkAttachments) {
        return vkAttachments.stream()
                .map(vkAttachmentConverter::convert)
                .collect(Collectors.toList());
    }
}
