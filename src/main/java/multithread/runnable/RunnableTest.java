package multithread.runnable;

/**
 * @author sunzl
 * @date 2018年12月7日
 *
 */
public class RunnableTest implements Runnable{
	
	private String name;
	
	public RunnableTest(String name) {
		this.name = name;
	} 

	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println(name + "运行：  " + i);
			try {
				Thread.sleep((int) Math.random() * 10);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
