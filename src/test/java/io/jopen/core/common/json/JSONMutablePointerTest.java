package io.jopen.core.common.json;

import org.json.JSONObject;
import org.junit.Test;

/**
 * 基于Json的查询语言 语法类似Xpath
 *
 * @author maxuefeng
 * @see MutableJson
 */
public class JSONMutablePointerTest {

    @Test
    public void testSimpleAPI() {

        JSONObject var = MutableJson.of("code0", MutableJson.of("code1", MutableJson.of("code2", "Hello world")));

        Object rs = var.optQuery("/code0");

        // result hello world
        System.err.println(rs);
    }
}
