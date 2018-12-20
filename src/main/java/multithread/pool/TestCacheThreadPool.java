package multithread.pool;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author sunzl
 * @date 2018��12��9��
 * 
 */
public class TestCacheThreadPool {

	public static void main(String[] args) {
		System.out.println("Main start: " + new Date());
		
		// ����һ������أ������������СΪInteger.MAX_VALUE
		ExecutorService executorService = Executors.newCachedThreadPool();
		
		for (int i = 0; i < 10; i++) {
			executorService.execute(new Handler(String.valueOf(i)));
		}
		// ִ�е��˴����������Ϲر��̳߳�,��֮���������̳߳��м��̣߳�����ᱨ��
		executorService.shutdown();
		
		System.out.println("Main end: " + new Date());
		
		//����
		// 1�����̵߳�ִ�����̳߳�����̷ֿ߳����п������߳̽����ˣ������̳߳ػ�������
		// 2�������̳߳ص��̲߳���һ���ᰴ�������Ⱥ��˳��ִ��
	}
}
