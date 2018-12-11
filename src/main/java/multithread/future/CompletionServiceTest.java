package multithread.future;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author sunzl
 * @date 2018年12月11日
 *
 */
public class CompletionServiceTest {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		System.out.println("main Thread begin");
		ExecutorService executor = Executors.newCachedThreadPool();
		ArrayList<Future<Integer>> result = new ArrayList<Future<Integer>>();
		for (int i = 0; i < 10; i++) {
			Future<Integer> submit = executor.submit(new HandleFuture<Object>(i));
			result.add(submit);
		}
		executor.shutdown();
		for (int i = 0; i < 10; i++) { // 一个一个等待返回结果
			System.out.println("返回结果：" + result.get(i).get());
		}
		System.out.println("main Thread end");
	}
}

class HandleFuture<Inteter> implements Callable<Integer>{
	
	private Integer num;
	
	public HandleFuture(Integer num) {
		this.num = num;
	}

	@Override
	public Integer call() throws Exception {
		Thread.sleep(300);
		System.out.println(Thread.currentThread().getName());
		return num;
	}
	
}
