package multithread.thread;

/**
 * @author sunzl
 * @date 2018年12月7日
 *
 */
public class ThreadTest extends Thread{
	
	private String name;
	
	public ThreadTest(String name){
		this.name = name;
	}

	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println(name + "运行    ： " + i);
			try {
				sleep((int) Math.random() * 100);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
