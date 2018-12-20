package multithread.pool;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author sunzl
 * @date 2018年12月9日
 * 
 */
public class TestSingleThreadExecutor {

	public static void main(String[] args) {
		System.out.println("main start: " + new Date());
		
		// 等价 ExecutorService exec = Executors.newFixedThreadPool(1);
		ExecutorService executorService = Executors.newSingleThreadExecutor();
		
		for (int i = 0; i < 10; i++) {
			executorService.execute(new Handler(String.valueOf(i)));
		}
		
		executorService.shutdown();
		System.out.println("main end: " + new Date());
	}
	
	// 创建只能运行一条线程的线程池。它能保证线程的先后顺序执行，并且能保证一条线程执行完成后才开启另一条新的线程
}
