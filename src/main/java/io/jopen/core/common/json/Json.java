package io.jopen.core.common.json;

import com.google.common.collect.ImmutableMap;
import com.google.gson.Gson;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.Map;

/**
 * JSON指针是RFC 6901为JSON文档定义的简单查询语言。
 * 简而言之，JSONPointer允许用户使用字符串导航到JSON文档，并检索目标对象，如XPATH的简单形式。
 * 路径段由'/'字符分隔，当字符串显示为字符串的第一个字符时，它表示文档的根。
 * 使用序数导航数组元素，从0开始计数.JSONPointer字符串可以扩展到任意数量的段。
 * 如果导航成功，则返回匹配的项目。匹配的项可以是JSONObject，
 * JSONArray或JSON值。如果JSONPointer字符串构建失败，则抛出相应的异常。
 * 如果导航无法找到匹配项，则抛出JSONPointerException。
 *
 * @author maxuefeng
 */
public final class Json extends JSONObject {

    private Json() {
    }

    public <T> T toJavaObject(String jsonString, Class<?> T) {

        if (StringUtils.isBlank(jsonString) || T == null) {
            throw new NullPointerException("args require not null");
        }

       /* boolean collection = true;

        try {

            T.asSubclass(Collection.class);

        } catch (ClassCastException e) {

            // 类型转换异常
            collection = false;
        }

        // 如果当前Class属于集合类型
        if (collection) {

            // 如果是集合类型 判断当前属于Map List Set  List和Set做位同一种类型进行处理
            // 因为JSONObject是Map  所以直接toMap
            return (T) this.toMap();

        }
        // 如果当前Class输入非集合类型(Java自定义类型)
        else {

            Set<String> ks = this.keySet();
            Field[] fields = T.getFields();

            for (Field f : fields) {

                if (ks.contains(f.getName())) {

                    // 判断当前字段属于基本类型(基本类型包装类型)

                }
            }


        }*/

        return new Gson().fromJson(jsonString, (Type) T);
    }


    /**
     * @return
     */
    public static JSONObject of() {
        return new JSONObject();
    }

    /**
     * @param jsonString
     * @return
     */
    public static JSONObject of(String jsonString) {
        return new JSONObject(jsonString);
    }

    /**
     * @param m
     * @return
     */
    public static JSONObject of(Map<String, Object> m) {
        return new JSONObject(m);
    }

    public static JSONObject of(ImmutableMap<String, Object> m) {
        return new JSONObject(m);
    }

    /**
     * @param bean
     * @return
     */
    public static JSONObject of(Object bean) {
        return new JSONObject(bean);
    }

    public static JSONObject of(String k1, Object v1) {
        return of(
                k1, v1,
                null, null);
    }

    public static JSONObject of(String k1, Object v1,
                                String k2, Object v2) {
        return of(
                k1, v1,
                k2, v2,
                null, null);
    }

    public static JSONObject of(String k1, Object v1,
                                String k2, Object v2,
                                String k3, Object v3) {
        return of(k1, v1,
                k2, v2,
                k3, v3,
                null, null);
    }

    public static JSONObject of(String k1, Object v1,
                                String k2, Object v2,
                                String k3, Object v3,
                                String k4, Object v4) {
        JSONObject var = new JSONObject();
        var.putOpt(k1, v1);
        return of(
                k1, v1,
                k2, v2,
                k3, v3,
                k4, v4,
                null, null);
    }

    public static JSONObject of(String k1, Object v1,
                                String k2, Object v2,
                                String k3, Object v3,
                                String k4, Object v4,
                                String k5, Object v5) {
        return of(
                k1, v1,
                k2, v2,
                k3, v3,
                k4, v4,
                k5, v5,
                null, null);
    }

    public static JSONObject of(String k1, Object v1,
                                String k2, Object v2,
                                String k3, Object v3,
                                String k4, Object v4,
                                String k5, Object v5,
                                String k6, Object v6) {
        return of(
                k1, v1,
                k2, v2,
                k3, v3,
                k4, v4,
                k5, v5,
                k6, v6,
                null, null);
    }

    public static JSONObject of(String k1, Object v1,
                                String k2, Object v2,
                                String k3, Object v3,
                                String k4, Object v4,
                                String k5, Object v5,
                                String k6, Object v6,
                                String k7, Object v7) {
        return of(
                k1, v1,
                k2, v2,
                k3, v3,
                k4, v4,
                k5, v5,
                k6, v6,
                k7, v7,
                null, null);
    }

    public static JSONObject of(String k1, Object v1,
                                String k2, Object v2,
                                String k3, Object v3,
                                String k4, Object v4,
                                String k5, Object v5,
                                String k6, Object v6,
                                String k7, Object v7,
                                String k8, Object v8) {
        return of(k1, v1,
                k2, v2,
                k3, v3,
                k4, v4,
                k5, v5,
                k6, v6,
                k7, v7,
                k8, v8,
                null, null);
    }


    public static JSONObject of(String k1, Object v1,
                                String k2, Object v2,
                                String k3, Object v3,
                                String k4, Object v4,
                                String k5, Object v5,
                                String k6, Object v6,
                                String k7, Object v7,
                                String k8, Object v8,
                                String k9, Object v9) {
        return of(
                k1, v1,
                k2, v2,
                k3, v3,
                k4, v4,
                k5, v5,
                k6, v6,
                k7, v7,
                k8, v8,
                k9, v9,
                null, null);
    }

    public static JSONObject of(String k1, Object v1,
                                String k2, Object v2,
                                String k3, Object v3,
                                String k4, Object v4,
                                String k5, Object v5,
                                String k6, Object v6,
                                String k7, Object v7,
                                String k8, Object v8,
                                String k9, Object v9,
                                String k10, Object v10) {
        return of(
                k1, v1,
                k2, v2,
                k3, v3,
                k4, v4,
                k5, v5,
                k6, v6,
                k7, v7,
                k8, v8,
                k9, v9,
                k10, v10,
                null, null);
    }

    public static JSONObject of(String k1, Object v1,
                                String k2, Object v2,
                                String k3, Object v3,
                                String k4, Object v4,
                                String k5, Object v5,
                                String k6, Object v6,
                                String k7, Object v7,
                                String k8, Object v8,
                                String k9, Object v9,
                                String k10, Object v10,
                                String k11, Object v11) {

        return of(k1, v1,
                k2, v2,
                k3, v3,
                k4, v4,
                k5, v5,
                k6, v6,
                k7, v7,
                k8, v8,
                k9, v9,
                k10, v10,
                k11, v11,
                null, null);
    }

    public static JSONObject of(String k1, Object v1,
                                String k2, Object v2,
                                String k3, Object v3,
                                String k4, Object v4,
                                String k5, Object v5,
                                String k6, Object v6,
                                String k7, Object v7,
                                String k8, Object v8,
                                String k9, Object v9,
                                String k10, Object v10,
                                String k11, Object v11,
                                String k12, Object v12) {

        return of(
                k1, v1,
                k2, v2,
                k3, v3,
                k4, v4,
                k5, v5,
                k6, v6,
                k7, v7,
                k8, v8,
                k9, v9,
                k10, v10,
                k11, v11,
                k12, v12,
                null, null);
    }

    public static JSONObject of(String k1, Object v1,
                                String k2, Object v2,
                                String k3, Object v3,
                                String k4, Object v4,
                                String k5, Object v5,
                                String k6, Object v6,
                                String k7, Object v7,
                                String k8, Object v8,
                                String k9, Object v9,
                                String k10, Object v10,
                                String k11, Object v11,
                                String k12, Object v12,
                                String k13, Object v13) {

        return of(
                k1, v1,
                k2, v2,
                k3, v3,
                k4, v4,
                k5, v5,
                k6, v6,
                k7, v7,
                k8, v8,
                k9, v9,
                k10, v10,
                k11, v11,
                k12, v12,
                k13, v13,
                null, null);
    }

    public static JSONObject of(String k1, Object v1,
                                String k2, Object v2,
                                String k3, Object v3,
                                String k4, Object v4,
                                String k5, Object v5,
                                String k6, Object v6,
                                String k7, Object v7,
                                String k8, Object v8,
                                String k9, Object v9,
                                String k10, Object v10,
                                String k11, Object v11,
                                String k12, Object v12,
                                String k13, Object v13,
                                String k14, Object v14) {

        return of(
                k1, v1,
                k2, v2,
                k3, v3,
                k4, v4,
                k5, v5,
                k6, v6,
                k7, v7,
                k8, v8,
                k9, v9,
                k10, v10,
                k11, v11,
                k12, v12,
                k13, v13,
                k14, v14,
                null, null);
    }

    public static JSONObject of(String k1, Object v1,
                                String k2, Object v2,
                                String k3, Object v3,
                                String k4, Object v4,
                                String k5, Object v5,
                                String k6, Object v6,
                                String k7, Object v7,
                                String k8, Object v8,
                                String k9, Object v9,
                                String k10, Object v10,
                                String k11, Object v11,
                                String k12, Object v12,
                                String k13, Object v13,
                                String k14, Object v14,
                                String k15, Object v15) {


        return of().putOpt(k1, v1)
                .putOpt(k2, v2)
                .putOpt(k3, v3)
                .putOpt(k4, v4)
                .putOpt(k5, v5)
                .putOpt(k6, v6)
                .putOpt(k7, v7)
                .putOpt(k8, v8)
                .putOpt(k9, v9)
                .putOpt(k10, v10)
                .putOpt(k11, v11)
                .putOpt(k12, v12)
                .putOpt(k13, v13)
                .putOpt(k14, v14)
                .putOpt(k15, v15);
    }
}






















