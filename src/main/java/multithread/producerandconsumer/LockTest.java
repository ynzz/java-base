package multithread.producerandconsumer;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * lock 实现生产者和消费者
 * 
 * @author sunzl
 * @date 2018年12月12日
 *
 */

class StoreHouse2{
	// 仓库容量
	private int capacity;
	// object当成是生产的商品
	private List<Object> list = new LinkedList<Object>();
	
	// 锁
	private final Lock lock = new ReentrantLock();
	// 仓库满的条件变量
	private final Condition full = lock.newCondition();
	// 仓库空的条件变量
	private final Condition empty = lock.newCondition();
	
	public StoreHouse2(int capacity) {
		this.capacity = capacity;
		System.out.println("当前仓库产品数量：" + list.size());
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	
	/**
	 * 生产
	 * @param num
	 * @throws InterruptedException
	 */
	public void produrce(int num) throws InterruptedException{
		try {
			lock.lock();
			// 仓库还未满，且再生产num个产品不会超过仓库容量时可以生产产品
			while (list.size() + num > this.capacity) {
				// 仓库已满，或者放不下
				System.out.println("【仓库已无法再生产：" + num + "个产品】" + "当前仓库产品数量：" + list.size());
				empty.await();
			}
			System.out.println("【仓库还未满，生产：" + num + "个产品没有问题】" + "当前仓库产品数量：" + list.size());
			for (int i = 0; i < num; i++) {
				list.add(new Object());
			}
			full.signalAll();
			empty.signalAll();
		} finally {
			lock.unlock();
		}
	}
	
	/**
	 * 消费
	 * @param num
	 * @throws InterruptedException
	 */
	public void consumer(int num) throws InterruptedException{
		try {
			lock.lock();

			// 仓库有没有num个产品可消费
			while (list.size() < num) {
				System.out.println("【仓库没有：" + num + "个产品可消费】" + "当前仓库产品数量：" + list.size());
				full.await();
			}
			System.out.println("【仓库有：" + num + "个产品可消费】" + "当前仓库产品数量：" + list.size());
			for (int i = 0; i < num; i++) {
				list.remove(0);
			}
			empty.signalAll();
			full.signalAll();
		} finally {
			lock.unlock();
		}
	}
}


class ProducerThread2 extends Thread{
	// 每次生产的产品数量
	private int num;
 
	// 所在放置的仓库
	private StoreHouse2 storehouse;
 
	// 构造函数，设置仓库
	public ProducerThread2(StoreHouse2 storehouse, int num) {
		this.storehouse = storehouse;
		this.num = num;
	}
 
	public void run() {
		try {
			storehouse.produrce(num);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}


class ConsumerThread2 extends Thread {
	// 每次生产的产品数量
	private int num;

	// 所在放置的仓库
	private StoreHouse2 storehouse;

	// 构造函数，设置仓库
	public ConsumerThread2(StoreHouse2 storehouse, int num) {
		this.storehouse = storehouse;
		this.num = num;
	}

	public void run() {
		try {
			storehouse.consumer(num);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}


public class LockTest {

	public static void main(String[] args) {
		// 仓库对象
		StoreHouse storeHouse = new StoreHouse(1000);
		
		// 生产者对象
		ProducerThread p1 = new ProducerThread(storeHouse, 200);
		ProducerThread p2 = new ProducerThread(storeHouse, 200);
		ProducerThread p3 = new ProducerThread(storeHouse, 100);
		ProducerThread p4 = new ProducerThread(storeHouse, 400);
		ProducerThread p5 = new ProducerThread(storeHouse, 300);
		ProducerThread p6 = new ProducerThread(storeHouse, 200);
		ProducerThread p7 = new ProducerThread(storeHouse, 500);
		
		// 消费者对象
		ConsumerThread c1 = new ConsumerThread(storeHouse, 500);
		ConsumerThread c2 = new ConsumerThread(storeHouse, 200);
		ConsumerThread c3 = new ConsumerThread(storeHouse, 800);
		
		// 线程开始执行
		c1.start();
		c2.start();
		c3.start();
		p1.start();
		p2.start();
		p3.start();
		p4.start();
		p5.start();
		p6.start();
		p7.start();
	}

}
