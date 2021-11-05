package api.longpoll.bots.config;

import api.longpoll.bots.converter.Converter;
import api.longpoll.bots.converter.impl.BoolIntConverter;

public class VkBotsConfig {
    private static final VkBotsConfig INSTANCE = new VkBotsConfig();
    private Converter<Boolean, Integer> boolIntConverter;

    private VkBotsConfig() {
    }

    public static VkBotsConfig getInstance() {
        return INSTANCE;
    }

    public Converter<Boolean, Integer> getBoolIntConverter() {
        if (boolIntConverter == null) {
            boolIntConverter = new BoolIntConverter();
        }
        return boolIntConverter;
    }

    public void setBoolIntConverter(Converter<Boolean, Integer> boolIntConverter) {
        this.boolIntConverter = boolIntConverter;
    }
}
