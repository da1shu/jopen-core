package io.jopen.core.common.proxology.handlers.early;


import io.jopen.core.common.proxology.handlers.MethodCallHandler;

@FunctionalInterface
public interface UnboundMethodCallHandler<S> {
    MethodCallHandler bind(S state);
}
