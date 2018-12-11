package proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author sunzl
 * @date 2018年11月15日
 *
 */
public class Client {
	
	public static void main(String[] args) {
		Subject realSubject = new RealSubject();
		InvocationHandler handler = new DynamicProxy(realSubject);
		Subject subject = (Subject)Proxy.newProxyInstance(handler.getClass().getClassLoader(), realSubject.getClass().getInterfaces(), handler);
		
		System.out.println(subject.getClass().getName());
		subject.rent();
		subject.hello("hello");

	}

}
