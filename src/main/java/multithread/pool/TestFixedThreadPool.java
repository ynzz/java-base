package multithread.pool;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author sunzl
 * @date 2018年12月9日
 * 
 */
public class TestFixedThreadPool {

	public static void main(String[] args) {
		System.out.println("main start: " + new Date());
		
		ExecutorService executorService = Executors.newFixedThreadPool(5);
		
		for (int i = 0; i < 10; i++) {
			executorService.execute(new Handler(String.valueOf(i)));
		}
		
		executorService.shutdown();
		System.out.println("main end: " + new Date());
		
		// 创建了一个固定大小的线程池，大小为5.也就说同一时刻最多只有5个线程能运行。
		// 并且线程执行完成后就从线程池中移出。它也不能保证放入的线程能按顺序执行。这要看在等待运行的线程的竞争状态了
	}
}
