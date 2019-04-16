package io.jopen.core.common;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author maxuefeng
 */
public class OfMap {


    /**
     *
     * @param objects
     * @return
     */
    public static Map of(Object... objects) {

        Map<Object, Object> m = new HashMap<>();

        // 不是偶数
        if (objects.length % 2 != 0) {
            return m;
        }

        // 数据长度是偶数
        Iterator<Object> iterator = Arrays.asList(objects).iterator();

        while (iterator.hasNext()) {

            // 获取K
            Object K = iterator.next();
            // 获取V
            Object V = iterator.next();

            m.put(K, V);
        }

        return m;
    }

    /**
     * @param k
     * @param v
     * @param <K>
     * @param <V>
     * @return
     */
    public static <K, V> Map<K, V> of(K k, V v) {
        Map<K, V> map = new HashMap<>();
        map.put(k, v);
        return map;
    }

    public static <K, V> Map<K, V> of(K k1, V v1,
                                      K k2, V v2,
                                      K k3, V v3
    ) {
        Map<K, V> map = new HashMap<>();
        map.put(k1, v1);
        map.put(k2, v2);
        map.put(k3, v3);
        return map;
    }
}
