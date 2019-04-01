package io.jopen.core.common.proxology.handlers.early;


import io.jopen.core.common.proxology.memoization.Memoizer;
import io.jopen.core.common.proxology.reflection.MethodInfo;
import io.jopen.core.common.proxology.reflection.TypeInfo;

import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author maxuefeng
 */
@FunctionalInterface
public interface ClassInterpreter<T> {

    static <T> ClassInterpreter<T> cached(ClassInterpreter<T> interpreter) {
        return Memoizer.memoize(interpreter::interpret)::apply;
    }

    static <T> ClassInterpreter<T> mappingWith(UnboundMethodInterpreter<T> interpreter) {
        return iface -> TypeInfo.forType(iface)
                .streamNonDefaultPublicInstanceMethods()
                .map(MethodInfo::getMethod)
                .collect(Collectors.toMap(
                        Function.identity(),
                        interpreter::interpret
                ))::get;
    }

    UnboundMethodInterpreter<T> interpret(Class<?> iface);

}