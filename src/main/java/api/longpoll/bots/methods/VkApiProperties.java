package api.longpoll.bots.methods;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Stores VK API properties.
 */
public class VkApiProperties {
    /**
     * Logger object.
     */
    private static final Logger log = LoggerFactory.getLogger(VkApiProperties.class);

    /**
     * Path to <b>.properties</b> file which contains VK API properties.
     */
    private static final String PROPERTIES_FILE = "/vk/api.properties";

    /**
     * Stores VK API properties. It is loaded during first call of {@link VkApiProperties#get(String)}.
     */
    private static final Properties PROPERTIES = new Properties();

    /**
     * Get VK API property by a key.
     *
     * @param key VK API property key
     * @return VK API property
     */
    public static String get(String key) {
        if (PROPERTIES.isEmpty()) {
            loadProperties();
        }
        return PROPERTIES.getProperty(key);
    }

    /**
     * Loads VK API URLs to {@link VkApiProperties#PROPERTIES}.
     */
    private static void loadProperties() {
        try (InputStream inputStream = VkApiProperties.class.getResourceAsStream(PROPERTIES_FILE)) {
            PROPERTIES.load(inputStream);
        } catch (IOException e) {
            log.error("Failed to read {}.", PROPERTIES_FILE, e);
        }
    }
}
