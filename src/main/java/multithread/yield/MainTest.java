package multithread.yield;

/**
 * @author sunzl
 * @date 2018年12月7日
 *
 */
public class MainTest {
	
	public static void main(String[] args) {
		YieldTest t1 = new YieldTest("A");
		YieldTest t2 = new YieldTest("B");
		
		t1.start();
		t2.start();
	}
}
