package com.findshen.corejava.thread;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Created by easzz on 2017/11/20 8:49
 */
public class Demo {
	public Integer count = 0;
	public static void main(String[] args) {

		new Thread(()->{
			System.out.println(1);
		}).start();


		final Demo demo = new Demo();
		Executor executor = Executors.newFixedThreadPool(10);

		for(int i=0;i<1000;i++){
			executor.execute(() -> demo.count++);
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("final count value:"+demo.count);
	}

}
