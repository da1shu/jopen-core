package io.jopen.core.common.proxology.proxies;


import io.jopen.core.common.proxology.handlers.MethodCallInterceptor;
import io.jopen.core.common.proxology.handlers.MethodInterpreters;
import io.jopen.core.common.proxology.handlers.PropertyValueStore;
import io.jopen.core.common.proxology.utils.EqualisableByState;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.Map;
import java.util.stream.Stream;

import static io.jopen.core.common.proxology.handlers.MethodInterpreters.caching;
import static io.jopen.core.common.proxology.handlers.MethodInterpreters.handlingDefaultMethods;
import static io.jopen.core.common.proxology.handlers.MethodInterpreters.intercepting;


public final class Proxies {

    @SuppressWarnings("unchecked")
    public static <T> T simpleProxy(Class<? extends T> iface, InvocationHandler handler, Class<?>...otherIfaces) {
        Class<?>[] allInterfaces = Stream.concat(
                Stream.of(iface),
                Stream.of(otherIfaces))
                .distinct()
                .toArray(Class<?>[]::new);

        return (T) Proxy.newProxyInstance(iface.getClassLoader(),
                allInterfaces,
                handler);
    }

    public static <T> T interceptingProxy(T target, Class<T> iface, MethodCallInterceptor interceptor) {
        return simpleProxy(iface,
                caching(intercepting(
                        handlingDefaultMethods(MethodInterpreters.binding(target)),
                        interceptor)));
    }

    public static <T> T propertyMapping(Class<? extends T> iface, Map<String, Object> propertyValues) {
        PropertyValueStore store = new PropertyValueStore(iface, propertyValues);
        return simpleProxy(iface, store.createMethodInterpreter(), EqualisableByState.class);
    }

}
