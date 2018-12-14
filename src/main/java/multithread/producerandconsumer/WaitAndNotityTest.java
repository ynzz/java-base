package multithread.producerandconsumer;

import java.util.LinkedList;
import java.util.List;

/**
 * wait/notity 实现生产者和消费者
 * 
 * @author sunzl
 * @date 2018年12月12日
 *
 */
class StoreHouse {

	// 仓库的容量
	private int capacity;
	
	// object当成是生产的商品
	private List<Object> list = new LinkedList<Object>();
	
	public StoreHouse(int capacity){
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
	 * 生产方法
	 * @param num
	 * @throws InterruptedException 
	 */
	public void produrce(int num) throws InterruptedException{
		// 同步方法
		synchronized (list) {
			// 仓库还未满，且再生产num个产品不会超过仓库容量时可以生产产品
			while (list.size() + num > this.capacity) {
				// 仓库已满，或者放不下
				System.out.println("【仓库已无法再生产：" + "个产品】" + " 当前仓库产品数量：" + list.size());
				list.wait();
			}
			
			System.out.println("【仓库还未满，生产：" + num + "个产品没有问题】" + "当前仓库产品数量：" + list.size());
			for (int i = 0; i < num; i++) {
				list.add(new Object());
			}
			
			list.notifyAll();
		}
	}
	
	/**
	 * 消费
	 * @param num
	 * @throws InterruptedException
	 */
	public void consumer(int num) throws InterruptedException{
		// 同步方法
		synchronized (list) {
			// 仓库有没有num个产品可消费
			while (list.size() < num) {
				System.out.println("【仓库没有：" + num + "个产品可消费】" + "当前仓库产品数量：" + list.size());
				list.wait();
			}
			System.out.println("【仓库有：" + num + "个产品可消费】" + "当前仓库产品数量：" + list.size());
			for (int i = 0; i < num; i++) {
				list.remove(0);
			}
			list.notifyAll();
		}
	}
	
}

class ConsumerThread extends Thread{

	// 每次生产的产品数量
	private int num;

	// 所在放置的仓库
	private StoreHouse storehouse;

	// 构造函数，设置仓库
	public ConsumerThread(StoreHouse storehouse, int num) {
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

class ProducerThread extends Thread{

	// 每次生产的产品数量
		private int num;
	 
		// 所在放置的仓库
		private StoreHouse storehouse;
	 
		// 构造函数，设置仓库
		public ProducerThread(StoreHouse storehouse, int num) {
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

public class WaitAndNotityTest{
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
