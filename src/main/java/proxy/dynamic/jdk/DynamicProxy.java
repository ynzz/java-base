package proxy.dynamic.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author sunzl
 * @date 2018年11月15日
 *
 */
public class DynamicProxy implements InvocationHandler{
	
	// 这其实业务实现类对象，用来调用具体的业务方法 
	private Object subject;
	
	public DynamicProxy(Object subject) {
		this.subject = subject;
	}

	/**
	 * 包装调用方法：进行预处理、调用后处理 
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		
		System.out.println("before rent house");
		System.out.println("Method:" + method);
		// 调用真正的业务方法
		Object result = method.invoke(subject, args);
		System.out.println("after rent house");
		return result;
	}

}
