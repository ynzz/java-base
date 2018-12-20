package multithread.pool;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author sunzl
 * @date 2018��12��9��
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
		
		// ������һ���̶���С���̳߳أ���СΪ5.Ҳ��˵ͬһʱ�����ֻ��5���߳������С�
		// �����߳�ִ����ɺ�ʹ��̳߳����Ƴ�����Ҳ���ܱ�֤������߳��ܰ�˳��ִ�С���Ҫ���ڵȴ����е��̵߳ľ���״̬��
	}
}
