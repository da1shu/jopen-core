package io.jopen.core.common.proxology;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author maxuefeng
 */
public class PassthroughInvocationHandler implements InvocationHandler {

	@SuppressWarnings("unchecked")
	public static <T> T proxying(T target, Class<T> iface) {
		return (T) Proxy.newProxyInstance(
				iface.getClassLoader(),
				new Class<?>[]{iface},
				new PassthroughInvocationHandler(target));
	}

	private final Object target;

	/**
	 * @param target
	 */
	public PassthroughInvocationHandler(Object target) {
		this.target = target;
	}

	/**
	 * @param proxy
	 * @param method
	 * @param args
	 * @return
	 * @throws Throwable
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		return method.invoke(target, args);
	}
}
