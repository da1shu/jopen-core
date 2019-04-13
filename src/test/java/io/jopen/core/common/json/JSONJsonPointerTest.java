package io.jopen.core.common.json;

import org.json.JSONObject;
import org.junit.Test;

/**
 * 基于Json的查询语言 语法类似Xpath
 *
 * @author maxuefeng
 * @see Json
 */
public class JSONJsonPointerTest {

    @Test
    public void testSimpleAPI() {

        JSONObject var = Json.of("code0", Json.of("code1", Json.of("code2", "Hello world")));

        Object rs = var.optQuery("/code0");

        // result hello world
        System.err.println(rs);
    }
}
