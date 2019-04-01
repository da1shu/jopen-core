package io.jopen.core.common.json;

import org.json.JSONObject;
import org.junit.Test;

/**
 * @author maxuefeng
 */
public class MutableJsonTest {


    /**
     * 获取一个JSONObject的最外层的Key
     */
    @Test
    public void testGetKeys() {

        String jsonString = "{\"code\":{\"k\":\"v\"}}";
        JSONObject var = MutableJson.of(jsonString);
        var.keySet().forEach(System.out::println);

    }

    @Test
    public void testSimpleAPI() {
        JSONObject o = MutableJson.of("k1", "v1");
        System.err.println(o);
    }
}
