package multithread.wait;

/**
 * @author sunzl
 * @date 2018Äê12ÔÂ8ÈÕ
 * 
 */
public class WaitTest implements Runnable{
	
	private String name;
	private Object prev;
	private Object self;

	public WaitTest(String name, Object prev, Object self) {
		this.name = name;
		this.prev = prev;
		this.self = self;
	}

	@Override
	public void run() {
		int count = 10;
		while (count > 0) {
			synchronized (prev) {
				synchronized (self) {
					System.out.println(name);
					count--;
					
					self.notify();
				}
			}
			
			try {
				prev.wait();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	
	public static void main(String[] args) throws Exception {
		Object a = new Object();
		Object b = new Object();
		Object c = new Object();
		
		WaitTest pa = new WaitTest("A", c, a);
		WaitTest pb = new WaitTest("B", a, b);
		WaitTest pc = new WaitTest("C", b, c);
		
		new Thread(pa).start();
		Thread.sleep(1000);
		new Thread(pb).start();
		Thread.sleep(1000);
		new Thread(pc).start();
		Thread.sleep(1000);
	}
	
}
