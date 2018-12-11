package proxy.dynamic;

/**
 * @author sunzl
 * @date 2018年11月15日
 *
 */
public class RealSubject2 implements Subject {

	@Override
	public void rent() {

		System.out.println("我也要租房");
	}

	@Override
	public void hello(String str) {

		System.out.println("我也说hello");
	}

}
