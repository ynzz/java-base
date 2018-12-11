package multithread.future;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * futureTask test， 用线程池启动
 * 
 * @author sunzl
 * @date 2018年12月11日
 *
 */
public class FutureTaskTest2 {

	public static void main(String[] args) {
		System.out.println("main Thread begin at: " + System.nanoTime());
		ExecutorService executorService = Executors.newCachedThreadPool();
		MyTask2 task1 = new MyTask2("1");
		MyTask2 task2 = new MyTask2("2");
		Future<Integer> result1 = executorService.submit(task1);
		Future<Integer> result2 = executorService.submit(task2);
		executorService.shutdown();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		try {
			System.out.println("task1返回的结果：" + result1.get());
			System.out.println("task2返回的结果：" + result2.get());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		System.out.println("main Thread finish at：" + System.nanoTime());
	}
}

class MyTask2 implements Callable<Integer>{
	
	private String name;
	
	MyTask2(String name){
		this.name = name;
	}

	@Override
	public Integer call() throws Exception {
		System.out.println("task " + name + "开始进行计算");
		Thread.sleep(3000);
		int sum = new Random().nextInt(300);
		int result = 0;
		for (int i = 0; i < sum; i++) {
			result += i;
		}
		return result;
	}
	
}