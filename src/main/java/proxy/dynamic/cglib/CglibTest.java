package proxy.dynamic.cglib;

import net.sf.cglib.proxy.Enhancer;

/**
 * @author sunzl
 * @date 2018年12月13日
 *
 */
public class CglibTest {
	
	public static void main(String[] args) {
		
		
		BookProxyCglib bookProxyCglib = new BookProxyCglib();
		// 创建加强器，用来创建动态代理类
		Enhancer enhancer = new Enhancer();
		// 为加强器指定要代理的业务类（即：为下面生成的代理类指定父类）
		enhancer.setSuperclass(BookCglib.class);
		//设置回调：对于代理类上所有方法的调用，都会调用CallBack，而Callback则需要实现intercept()方法进行拦
		enhancer.setCallback(bookProxyCglib);
		// 创建动态代理类对象并返回  
		BookCglib bookCglib = (BookCglib)enhancer.create();
		bookCglib.addBook();
	}

}
