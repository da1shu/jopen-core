package io.jopen.core.common.reflect;

import io.jopen.core.common.design.delegate.Listener;
import org.junit.Test;

import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author maxuefeng
 */
public class MethodReflectTest {


    /**
     * TODO  带有数组反射的方法会存在问题 需要按照以下方式进行,
     * r的类型必须得是Object才不会出现异常
     *
     * @throws NoSuchMethodException
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     * @see Array#newInstance(Class, int) return a Object
     */
    @Test
    public void testInvokeMethodOfArrayParam() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        //
        Listener listener = new Listener();

        // 暂时不要强转r 转化会出现反射报出异常问题
        Object r = Array.newInstance(String.class, 1);
        Array.set(r, 0, "Hello world");

        //
        Method m = listener.getClass().getMethod("doSomethings", String[].class);
        m.invoke(listener, r);
    }
}
