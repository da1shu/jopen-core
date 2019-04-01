package io.jopen.core.function;

/**
 * @author maxuefeng
 */
@FunctionalInterface
public interface StreamCheckedFunction<T, R> {

    R apply(T t) throws Exception;
}
