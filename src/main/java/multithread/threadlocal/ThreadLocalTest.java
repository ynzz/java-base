package multithread.threadlocal;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author sunzl
 * @date 2018年12月12日
 *
 */
public class ThreadLocalTest {

	// 创建一个Integer型的线程本地变量
	static final ThreadLocal<Integer> local = new ThreadLocal<Integer>(){
		@Override
		protected Integer initialValue() {
			return 0;
		}
	};
	
	static class Task implements Runnable{
		
		private int num;
		
		public Task(int num) {
			this.num = num;
		}
		
		@Override
		public void run() {
			Integer i = local.get();
			while (++i < 10) {
				System.out.println("Task " + num + " local num result is " + i);
				
			}
		}
		
		static void test(){
			System.out.println("main thread begin");
			ExecutorService executors = Executors.newCachedThreadPool();
			for (int i = 0; i <=5; i++) {
				executors.execute(new Task(i));
			}
			executors.shutdown();
			System.out.println("main thread end");
		}
		
		public static void main(String[] args) {
			test();
		}
	}
	
}
