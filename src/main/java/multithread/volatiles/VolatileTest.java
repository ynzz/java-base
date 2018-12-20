package multithread.volatiles;

import java.util.Scanner;

/**
 * 主线程在修改了标志位使得线程 A 立即停止，如果没有用 volatile 修饰，就有可能出现延迟
 * 
 * 但这里有个误区，这样的使用方式容易给人的感觉是：
 *
 * 对 volatile 修饰的变量进行并发操作是线程安全的。
 *
 * 这里要重点强调，volatile 并不能保证线程安全性！
 * 
 * @author sunzl
 * @date 2018年12月18日
 *
 */
public class VolatileTest implements Runnable{
	
	private static volatile boolean flag = true;

	@Override
	public void run() {
		while (flag) {
			
		}
		System.out.println(Thread.currentThread().getName() + "执行完毕");
	}

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		VolatileTest vt = new VolatileTest();
		new Thread(vt, "thread A").start();
		
		System.out.println("main 线程正在运行");
		
		Scanner scanner = new Scanner(System.in);
		
		while (scanner.hasNext()) {
			String value = scanner.next();
			if ("1".equals(value)) {
				new Thread(new Runnable() {
					
					@Override
					public void run() {
						vt.stopThread();
					}
				}).start();
				break;
			}
		}
		System.out.println("主线程退出了！");
	}

	protected void stopThread() {
		flag = false;
	}
}
