package proxy.dynamic.cglib;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.CallbackFilter;

/**
 * @author sunzl
 * @date 2018年12月13日
 *
 */
public class BookFilter implements CallbackFilter{

	@Override
	public int accept(Method method) {
		if ("addBook".equals(method.getName())) {
			return 0;
		}
		return 1;
	}

}
