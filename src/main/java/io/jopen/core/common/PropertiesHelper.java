package io.jopen.core.common;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author maxuefeng
 * @see java.util.Properties
 */
public class PropertiesHelper {


    private PropertiesHelper() {
    }

    public static Properties of(InputStream inputStream) throws IOException {
        Properties properties = new Properties();
        properties.load(inputStream);
        return properties;
    }

    public static Properties of(Properties properties) {
        return new Properties(properties);
    }
}
