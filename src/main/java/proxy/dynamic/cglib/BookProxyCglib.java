package proxy.dynamic.cglib;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * @author sunzl
 * @date 2018年12月13日
 *
 */
public class BookProxyCglib implements MethodInterceptor{
	
	// 实现回调方法 
	@Override
	public Object intercept(Object arg0, Method arg1, Object[] arg2,
			MethodProxy arg3) throws Throwable {
		System.out.println("cglib实现的前置代理");
		// 通过代理类调用父类中的方法
		Object result = arg3.invokeSuper(arg0, arg2);
		System.out.println("cglib实现的后置代理");
		return result;
	}

}
