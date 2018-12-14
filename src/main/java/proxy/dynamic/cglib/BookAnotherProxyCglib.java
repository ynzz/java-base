package proxy.dynamic.cglib;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * @author sunzl
 * @date 2018年12月13日
 *
 */
public class BookAnotherProxyCglib implements MethodInterceptor{

	@Override
	public Object intercept(Object obj, Method method, Object[] args,
			MethodProxy proxy) throws Throwable {
		System.out.println("cglig实现前的另一操作");
		proxy.invokeSuper(obj, args);
		System.out.println("cglig实现后的另一操作");
		return obj;
	}

}
