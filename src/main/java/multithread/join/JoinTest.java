package multithread.join;

/**
 * @author sunzl
 * @date 2018年12月7日
 *
 */
public class JoinTest extends Thread{

	private String name;
	
	public JoinTest(String name) {
		this.name = name;
	}
	
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + " 线程运行开始！");
		for (int i = 0; i < 5; i++) {
			System.out.println("子线程" + name + "运行：" + i);
			try {
				sleep((int) Math.random() * 10);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println(Thread.currentThread().getName() + " 线程运行结束！");
	}
	
}
