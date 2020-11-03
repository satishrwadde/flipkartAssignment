package com.flipkart.utils;

public class Sleep {

	
	public static void sleepMS(int ms) {
		
		System.out.println("Sleeping for >>>: "+ms+"milli seconds");
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
public static void sleepSeconds(int seconds) {
		
	System.out.println("Sleeping for >>>: "+seconds+"seconds");
		try {
			Thread.sleep(seconds*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
