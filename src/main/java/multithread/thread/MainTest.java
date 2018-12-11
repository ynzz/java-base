package multithread.thread;

/**
 * @author sunzl
 * @date 2018年12月7日
 *
 */
public class MainTest {

	public static void main(String[] args) {
		ThreadTest t1 = new ThreadTest("A");
		ThreadTest t2 = new ThreadTest("B");
		
		t1.start();
		t2.start();
	}
}
