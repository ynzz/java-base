package multithread.submit;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 缓冲线程池实例-submit运行
 * 
 * @author sunzl
 * @date 2018年12月10日
 *
 */

class TaskWithResult implements Callable<String>{
	
	private int id;
	
	public TaskWithResult(int id) {
		this.id = id;
	}
	
	/**
	 * 任务的具体过程，一旦任务传给ExecutorService的submit方法，则该方法自动在一个线程上执行。
	 */
	@Override
	public String call() throws Exception {
		System.out.println("call() 方法被调用： " + Thread.currentThread().getName());
		for (int i = 0; i < 99999; i++);
		return "call() 方法执行完毕，任务结果是：" + id + " " + Thread.currentThread().getName();
	}
	
}

public class TestSubmit {
	
	public static void main(String[] args) {
		ExecutorService executorService = Executors.newCachedThreadPool();
		List<Future<String>> resultList = new ArrayList<Future<String>>();
		
		// 创建10个任务
		for (int i = 0; i < 10; i++) {
			// 使用ExecutorService执行Callable类型的任务，并将结果保存在future变量中
			Future<String> future = executorService.submit(new TaskWithResult(i));
			// 将任务的执行结果保存到List中
			resultList.add(future);
		}
		// 启动一次顺序关闭，执行以前提交的任务，但不接受新任务。如果已经关闭，则调用没有其他作用
		executorService.shutdown();
		
		// 遍历任务的结果
		for (Future<String> future : resultList) {
			try {
				// 打印各个程序(任务)执行的结果
				System.out.println(future.get());
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
		}
	}
}


