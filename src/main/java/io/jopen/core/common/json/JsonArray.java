package io.jopen.core.common.json;

import org.json.JSONArray;
import org.json.JSONTokener;

import java.util.Collection;

/**
 * @author maxuefeng
 * @see JSONArray
 */
public final class JsonArray {

    private JsonArray() {

    }
    
    public static JSONArray of() {
        return new JSONArray();
    }

    public static JSONArray of(JSONTokener x) {
        return new JSONArray(x);
    }

    public static JSONArray of(String source) {
        return new JSONArray(source);
    }

    public static JSONArray of(Collection<?> collection) {
        return new JSONArray(collection);
    }

    public static JSONArray of(Object array) {
        return new JSONArray(array);
    }


}
