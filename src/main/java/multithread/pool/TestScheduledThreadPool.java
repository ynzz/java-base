package multithread.pool;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author sunzl
 * @date 2018��12��9��
 * 
 */
public class TestScheduledThreadPool {

	public static void main(String[] args) {
		System.out.println("main start: " + new Date());
		
		ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(10);
		
		for (int i = 0; i < 10; i++) {
			// �ӳ�10��ִ��
			scheduledThreadPool.schedule(new Handler(String.valueOf(i)), 10, TimeUnit.SECONDS);
		}
		
		scheduledThreadPool.shutdown();
		
		System.out.println("main end: " + new Date());
	}
}
