package multithread.pool;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author sunzl
 * @date 2018年12月9日
 * 
 */
public class TestScheduledThreadPool {

	public static void main(String[] args) {
		System.out.println("main start: " + new Date());
		
		ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(10);
		
		for (int i = 0; i < 10; i++) {
			// 延迟10秒执行
			scheduledThreadPool.schedule(new Handler(String.valueOf(i)), 10, TimeUnit.SECONDS);
		}
		
		scheduledThreadPool.shutdown();
		
		System.out.println("main end: " + new Date());
	}
}
