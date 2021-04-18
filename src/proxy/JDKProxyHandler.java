package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 *
 * @author kaiz
 * @date 下午2:00 2021/4/17.
 */
public class JDKProxyHandler implements InvocationHandler {
	private Object object;

	public JDKProxyHandler(final Object o) {
		this.object = o;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("jdk proxy before");
		Object result = method.invoke(object,args);
		System.out.println("jdk proxy after");
		return result;
	}
}
