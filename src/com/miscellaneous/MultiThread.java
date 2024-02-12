package com.miscellaneous;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class MultiThread {

	public static void main(String[] args) {
		MultiThread mt = new MultiThread();
		mt.executeMultiThreads(10);
		
	}
	
	public void executeMultiThreads(int poolSize) {
		ThreadPoolExecutor parentExecutor = (ThreadPoolExecutor)Executors.newCachedThreadPool();
		parentExecutor.setCorePoolSize(poolSize);
		
		parentExecutor.submit(() ->
		{
			executeAction(Thread.currentThread());
		});
	}

	private void executeAction(Thread t) {
		// TODO Auto-generated method stub
		System.out.println(t.getName());
	}

}
