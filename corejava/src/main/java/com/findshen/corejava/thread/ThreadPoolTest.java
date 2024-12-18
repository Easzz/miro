package com.findshen.corejava.thread;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by easzz on 2017/11/27 10:39
 */
public class ThreadPoolTest {
	public static void main(String[] args) throws IOException, InterruptedException {
		ExecutorService executorService = Executors.newFixedThreadPool(10);
		final CountDownLatch countDownLatch = new CountDownLatch(100000);
		long startTime = System.currentTimeMillis();    //获取开始时间

		for (int j = 0; j < 10; j++) {
			executorService.execute(() -> {
				for (int i = 0; i < 10000; i++) {
					System.out.println(i + "thread:" + Thread.currentThread().getName());
					countDownLatch.countDown();
				}
			});
		}

//
//		executorService.submit(new Runnable() {
//			@Override
//			public void run() {
//				for (int i = 0; i < 1000; i++) {
//					doGet(url);
//					System.out.println(i);
//					countDownLatch.countDown();
//				}
//			}
//		});
		countDownLatch.await();

		executorService.shutdown();

		System.out.println("aa" + (System.currentTimeMillis() - startTime));
	}

	public static void doGet(String url) {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		RequestConfig requestConfig = RequestConfig.custom()
				.setSocketTimeout(2000).setConnectTimeout(2000).build();
		HttpGet httpGet = new HttpGet(url);
		httpGet.setConfig(requestConfig);

		CloseableHttpResponse execute = null;
		try {
			execute = httpClient.execute(httpGet);
		} catch (IOException e) {
			e.printStackTrace();
		}
		int statusCode = execute.getStatusLine().getStatusCode();
	}

}
