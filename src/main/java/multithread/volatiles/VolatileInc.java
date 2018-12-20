package multithread.volatiles;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author sunzl
 * @date 2018年12月18日
 *
 */
public class VolatileInc implements Runnable{
	
//	private static volatile int count = 0; // 使用volatile修饰基本数据内存不能保证原子性

	private static AtomicInteger countAc = new AtomicInteger();
	
	@Override
	public synchronized void run() {
		for (int i = 0; i < 10000; i++) {
//			count++;
			countAc.incrementAndGet();
		}
	}
	
	public static void main(String[] args) {
		VolatileInc volatileInc = new VolatileInc();
		Thread t1 = new Thread(volatileInc, "t1");
		Thread t2 = new Thread(volatileInc, "t2");
		t1.start();
		t2.start();
		
//		for (int i = 0; i < 10000; i++) {
////			count++;
//			countAc.incrementAndGet();
//		}
		
//		System.out.println("最终Count=" + count);
		System.out.println("最终Count=" + countAc.intValue());
	}
}
