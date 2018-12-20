package multithread.yield;

/**
 * @author sunzl
 * @date 2018年12月18日
 *
 */
public class YieldTest2 {

	public static void main(String[] args) {
		MyThreadYield my = new MyThreadYield();
		my.start();
	}
}

class MyThreadYield extends Thread {
	@Override
	public void run() {
		long open = System.currentTimeMillis();
		int count = 0;
		for (int i = 0; i < 1000000; i++) {
			count = count + (i + 1);
//			Thread.yield();
		}
		long end = System.currentTimeMillis();
		System.out.println("用时：" + (end - open) + "毫秒");
	}
}
