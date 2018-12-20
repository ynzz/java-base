package multithread.pool;

import java.util.Date;

/**
 * @author sunzl
 * @date 2018Äê12ÔÂ9ÈÕ
 * 
 */
public class Handler implements Runnable{
	
	private String name;
	
	public Handler(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		System.out.println(name + " start time = " + new Date());
		processCommand();
		System.out.println(name + " end time = " + new Date());
	}
	
	private void processCommand() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
