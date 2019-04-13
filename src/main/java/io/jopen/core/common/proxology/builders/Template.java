package io.jopen.core.common.proxology.builders;

import java.util.function.Supplier;

/**
 * @author maxuefeng
 */
public interface Template<T, B extends Supplier<T>> extends Supplier<T> {


    /**
     * @param templateClass
     * @param <V>
     * @param <B>
     * @param <T>
     * @return
     */
    static <V, B extends Supplier<V>, T extends Template<V, B>> B builderFor(Class<T> templateClass) {
        return TemplateValueStore.createBuilder(templateClass);
    }
}
