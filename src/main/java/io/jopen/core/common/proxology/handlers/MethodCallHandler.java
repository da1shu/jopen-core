package io.jopen.core.common.proxology.handlers;


/**
 * @author maxuefeng
 */
@FunctionalInterface
public interface MethodCallHandler {
    Object invoke(Object proxy, Object[] args) throws Throwable;
}
