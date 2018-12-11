package proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author sunzl
 * @date 2018年11月15日
 *
 */
public class DynamicProxy implements InvocationHandler{
	
	private Object subject;
	
	public DynamicProxy(Object subject) {
		this.subject = subject;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		
		System.out.println("before rent house");
		System.out.println("Method:" + method);
		Object result = method.invoke(subject, args);
		System.out.println("after rent house");
		return result;
	}

}
