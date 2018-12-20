package multithread.pool;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author sunzl
 * @date 2018年12月9日
 * 
 */
public class TestCacheThreadPool {

	public static void main(String[] args) {
		System.out.println("Main start: " + new Date());
		
		// 创建一个缓冲池，缓冲池容量大小为Integer.MAX_VALUE
		ExecutorService executorService = Executors.newCachedThreadPool();
		
		for (int i = 0; i < 10; i++) {
			executorService.execute(new Handler(String.valueOf(i)));
		}
		// 执行到此处并不会马上关闭线程池,但之后不能再往线程池中加线程，否则会报错
		executorService.shutdown();
		
		System.out.println("Main end: " + new Date());
		
		//结论
		// 1、主线程的执行与线程池里的线程分开，有可能主线程结束了，但是线程池还在运行
		// 2、放入线程池的线程并不一定会按其放入的先后而顺序执行
	}
}
