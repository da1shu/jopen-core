package io.jopen.core.common.proxology;


/**
 * @author maxuefeng
 */
public final class Nonchalantly {

    private Nonchalantly() {
    }

    public static <T, E extends Throwable> T invoke(FallibleSupplier<T> f) throws E {
        try {
            return f.get();
        } catch (Throwable e) {
            throw (E) e;
        }
    }
}
