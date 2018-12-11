package multithread.runnable;

/**
 * @author sunzl
 * @date 2018年12月7日
 *
 */
public class MainTest {
	public static void main(String[] args) {
		new Thread(new RunnableTest("A")).start();
		new Thread(new RunnableTest("B")).start();
	}
}