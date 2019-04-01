package io.jopen.core.common.proxology.beans;


import io.jopen.core.common.proxology.proxies.Proxies;
import io.jopen.core.common.proxology.utils.EqualisableByState;

public final class BeanProxy {

    private BeanProxy() {
    }

    public static <T> T proxying(Class<T> proxyClass) {
        BeanProxySchema schema = BeanProxySchema.forClass(proxyClass);
        BeanProxyStorage storage = schema.createStorage();

        return Proxies.simpleProxy(proxyClass, storage.getMethodInterpreter(), EqualisableByState.class);
    }

}
