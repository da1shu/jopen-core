package io.jopen.core.common.collection;

import io.jopen.core.common.OfMap;
import org.junit.Test;

import java.io.Serializable;
import java.util.Map;

/**
 * @author maxuefeng
 */
public class OfMapTest {

    @Test
    public void simpleTestMap(){
        Map map = OfMap.of(1, 2, 3, 4, 5, "7", 7, 8,0);
        System.err.println(map);
    }
}
