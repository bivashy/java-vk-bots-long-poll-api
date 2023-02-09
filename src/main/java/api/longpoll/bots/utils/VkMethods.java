package api.longpoll.bots.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Gets VK method URLs.
 */
public class VkMethods {
    /**
     * Path to VK methods list.
     */
    private static final String VK_METHODS_PATH = "/vk/vk_methods.properties";

    /**
     * {@link Properties} object.
     */
    private static final Properties PROPERTIES = new Properties();

    /**
     * Gets VK method URL by key.
     *
     * @param key method key.
     * @return VK method URL.
     */
    public static String get(String key) {
        if (PROPERTIES.isEmpty()) {
            try (InputStream inputStream = VkMethods.class.getResourceAsStream(VK_METHODS_PATH)) {
                PROPERTIES.load(inputStream);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return PROPERTIES.getProperty(key);
    }
}
