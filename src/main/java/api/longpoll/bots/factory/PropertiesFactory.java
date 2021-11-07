package api.longpoll.bots.factory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Builds {@link Properties} object filled with values.
 */
public class PropertiesFactory {
    /**
     * {@link Logger} object.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(PropertiesFactory.class);

    /**
     * Gets {@link Properties} object filled with values.
     *
     * @param path path to <i>.properties</i> file
     * @return {@link Properties} object filled with values.
     */
    public Properties get(String path) {
        Properties properties = new Properties();

        try (InputStream inputStream = PropertiesFactory.class.getResourceAsStream(path)) {
            properties.load(inputStream);
        } catch (IOException e) {
            LOGGER.error("Failed to read {}.", path, e);
        }

        return properties;
    }
}
