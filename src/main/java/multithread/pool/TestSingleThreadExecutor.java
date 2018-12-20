package multithread.pool;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author sunzl
 * @date 2018��12��9��
 * 
 */
public class TestSingleThreadExecutor {

	public static void main(String[] args) {
		System.out.println("main start: " + new Date());
		
		// �ȼ� ExecutorService exec = Executors.newFixedThreadPool(1);
		ExecutorService executorService = Executors.newSingleThreadExecutor();
		
		for (int i = 0; i < 10; i++) {
			executorService.execute(new Handler(String.valueOf(i)));
		}
		
		executorService.shutdown();
		System.out.println("main end: " + new Date());
	}
	
	// ����ֻ������һ���̵߳��̳߳ء����ܱ�֤�̵߳��Ⱥ�˳��ִ�У������ܱ�֤һ���߳�ִ����ɺ�ſ�����һ���µ��߳�
}
