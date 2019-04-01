package io.jopen.core.common.proxology.handlers;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author maxuefeng
 */
@FunctionalInterface
public interface MethodInterpreter extends InvocationHandler {

    @Override
    default Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        MethodCallHandler handler = interpret(method);
        return handler.invoke(proxy, args);
    }

    MethodCallHandler interpret(Method method);
}