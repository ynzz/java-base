package proxy.dynamic.cglib;

import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;

/**
 * 类A的B方法使用一种拦截策略、类A的C方法使用另外一种拦截策略。
 * 
 * @author sunzl
 * @date 2018年12月13日
 *
 */
public class CglibTest2 {

	public static void main(String[] args) {
		
		BookProxyCglib bookProxyCglib = new BookProxyCglib();
		BookAnotherProxyCglib bookAnotherProxyCglib = new BookAnotherProxyCglib();
		
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(BookCglib.class);
		enhancer.setCallbacks(new Callback[]{bookProxyCglib, bookAnotherProxyCglib, NoOp.INSTANCE});
		enhancer.setCallbackFilter(new BookFilter());
		
		BookCglib bookCglib = (BookCglib)enhancer.create();
		bookCglib.addBook();
		bookCglib.rentBook();
	}
}
