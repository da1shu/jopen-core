package io.jopen.core.common.util;

import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Set;

/**
 * 反射工具类
 *
 * @author maxuefeng
 */
public class Reflects {

    @Deprecated
    private final static Set<String> primitive = new HashSet<>();

    private final Class<?> type;

    private final Object object;

    private Reflects(final Class<?> type, Object object) {
        this.type = type;
        this.object = object;
    }


    private Class<?>[] getArgsType(final Object... args) {
        if (args == null) return new Class[0];
        Class<?>[] result = new Class[args.length];
        for (int i = 0; i < args.length; i++) {
            Object value = args[i];

            // TODO Null.class
            result[i] = value == null ? Void.class : value.getClass();
        }
        return result;
    }


    /**
     * 判断一个变量是否属于基本类型或者属于基本类型的变量
     *
     * @param T
     * @return
     */
    public static boolean isPrimitiveOrPrimitiveOfPackage(Class<?> T) {

        if (T.isPrimitive())
            return true;

        try {
            Field f = T.getField("TYPE");

            if (f == null) return false;

        } catch (NoSuchFieldException e) {
            return false;
        }

        return false;
    }

    public Object get() {
        return this.object;
    }

    private Object unwrap(Object object) {
        if (object instanceof Reflects) {
            return ((Reflects) object).get();
        }
        return object;
    }

    /*private Field getAccessibleField(String name) {
        Class<?> type = type();
        try {
            return accessible(type.getField(name));
        } catch (NoSuchFieldException e) {
            do {
                try {
                    return accessible(type.getDeclaredField(name));
                } catch (NoSuchFieldException ignore) {
                }
                type = type.getSuperclass();
            } while (type != null);
            throw new RuntimeException(e);
        }
    }*/

    /**
     * 获取字段名称
     *
     * @param name
     * @return
     * @throws IllegalAccessException
     */
   /* private Field getField(String name) throws IllegalAccessException {

        Field field = getAccessibleField(name);

        if ((field.getModifiers() & Modifier.FINAL) == Modifier.FINAL) {

            try {

                Field modifiersField = Field.class.getDeclaredField("modifiers");
                modifiersField.setAccessible(true);
                modifiersField.setInt(field, field.getModifiers() & ~Modifier.FINAL);

            } catch (NoSuchFieldException ignore) {
                // runs in android will happen
            }
        }
        return field;
    }*/

    /**
     * 设置反射的字段
     *
     * @param name  字段名
     * @param value 字段值
     * @return {@link Reflects}
     */
/*    public Reflects field(String name, Object value) {
        try {
            Field field = getField(name);
//            field.set(object, unwrap(value));

            // TODO ??
            field.set("", unwrap(value));
            return this;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    *//**
     * 设置反射的字段
     *
     * @param name 字段名
     * @return {@link Reflects}
     *//*
    public Reflects field(final String name) {
        try {
            Field field = getField(name);
            return new Reflects(field.getType(), field.get(object));
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }*/

}
