package multithread.yield;

/**
 * @author sunzl
 * @date 2018年12月7日
 *
 */
public class YieldTest extends Thread{

	private String name;
	
	public YieldTest(String name) {
		this.name = name;
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 50; i++) {
			System.out.println("-----" + this.getName() + "-----" + i);
			if (i == 30) {
				Thread.yield();
			}
		}
	}
}
