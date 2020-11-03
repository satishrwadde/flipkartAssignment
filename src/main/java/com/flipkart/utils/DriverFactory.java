package com.flipkart.utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class DriverFactory {

	private static WebDriver driver=null;
	
	public static WebDriver getMyDriver(DriverNames browserName) {
		
		if (browserName.equals(DriverNames.CHROME)) {
			
			System.setProperty(Driver.CHROME_DRIVER_KEY, Driver.CHROME_DRIVER_PATH);
			driver = new ChromeDriver();
			
			
			
		}else if (browserName.equals(DriverNames.FIREFOX)) {
			
			System.setProperty(Driver.FIREFOX_DRIVER_KEY, Driver.FIREFOX_DRIVER_PATH);
			driver=new FirefoxDriver();
			
		}
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		return driver;
		
	}
}
