package api.longpoll.bots.reader.impl;

import api.longpoll.bots.reader.DataReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Reads {@link Properties} by path.
 */
public class PropertiesReader implements DataReader<Properties> {
    /**
     * {@link Logger} object.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(PropertiesReader.class);

    @Override
    public Properties read(String path) {
        Properties properties = new Properties();

        try (InputStream inputStream = PropertiesReader.class.getResourceAsStream(path)) {
            properties.load(inputStream);
        } catch (IOException e) {
            LOGGER.error("Failed to read {}.", path, e);
        }

        return properties;
    }
}
