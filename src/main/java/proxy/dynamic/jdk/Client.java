package proxy.dynamic.jdk;

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
		
		// 通过反射机制，创建一个代理类对象实例并返回。用户进行方法调用时使用
	    // 创建代理对象时，需要传递该业务类的类加载器（用来获取业务实现类的元数据，在包装方法是调用真正的业务方法）、接口、handler实现类
		Subject subject = (Subject)Proxy.newProxyInstance(handler.getClass().getClassLoader(), realSubject.getClass().getInterfaces(), handler);
		
		System.out.println(subject.getClass().getName());
		subject.rent();
		subject.hello("hello");

	}

}
