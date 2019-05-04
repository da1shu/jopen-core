package io.jopen.core.common.json;


import java.util.AbstractMap;

/**
 * @author maxuefeng
 * @see java.util.Map.Entry
 * @see java.util.AbstractMap.SimpleEntry
 */
public class REnTry {

    private REnTry() {
    }

    public static <K, V> AbstractMap.SimpleEntry<K, V> of(K k, V v) {
        return new AbstractMap.SimpleEntry<>(k, v);
    }
}
