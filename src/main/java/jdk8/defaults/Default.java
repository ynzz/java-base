package jdk8.defaults;

/**
 * 在java里面，我们通常都是认为接口里面是只能有抽象方法，不能有任何方法的实现的，那么在jdk1.8里面打破了这个规定，引入了新的关键字default;
 * 其实这么定义一个方法的主要意义是定义一个默认方法，也就是说这个接口的实现类实现了这个接口之后，不用管这个default修饰的方法，也可以直接调用
 * 
 * @author sunzl
 * @date 2018年12月20日
 *
 */
public interface Default {

	public void test1();
	
	public default void test2() {
		System.out.println("我是新特性");
	}
}
