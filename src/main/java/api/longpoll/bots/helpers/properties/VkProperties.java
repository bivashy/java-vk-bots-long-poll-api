package api.longpoll.bots.helpers.properties;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * A properties with autoload functionality.
 */
public class VkProperties {
    private final Properties properties = new Properties();

    public VkProperties(String path) {
        try (InputStream inputStream = VkProperties.class.getResourceAsStream(path)) {
            properties.load(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }
}
