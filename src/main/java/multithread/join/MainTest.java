package multithread.join;

/**
 * @author sunzl
 * @date 2018年12月7日
 *
 */
public class MainTest {

	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getName() + "主线程运行开始！");
		JoinTest t1 = new JoinTest("A");
		JoinTest t2 = new JoinTest("B");
		t1.start();
		t2.start();
		
		// 不加jion，主线程在A，B之前执行完
		try {
			t1.join();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			t2.join();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println(Thread.currentThread().getName() + "主线程运行结束！");
	}
}
