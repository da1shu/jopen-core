package io.jopen.core.common;

import java.util.UUID;

/**
 * @author maxuefeng
 */
public class Strings {

    /**
     *
     * @return
     */
    public static String id() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
}
