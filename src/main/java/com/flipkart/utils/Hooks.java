package com.flipkart.utils;

import cucumber.api.java.After;
import cucumber.api.java.Before;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import com.flipkart.pom.ProductPom;



public class Hooks {

	private WebDriver driver=null;
	private String url="https://www.flipkart.com";
	private ProductPom prodPom = null;
	private Utils utils=null;
	private CaptureScreenshot captureScreenshot = null;
	public Hooks() {
		
	}
		
  @Before
   public void setUp() {
	 
	  driver=DriverFactory.getMyDriver(DriverNames.FIREFOX);
	  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	  System.out.println("Driver : "+driver);
	  driver.get(url);
	  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	  prodPom=new ProductPom(driver);
	  utils = new Utils(driver);
	  captureScreenshot = new CaptureScreenshot(driver);
  }

  
  @After
  public void tearDown() {
	  
	  System.out.println("Before quitting browser : ");
	  Sleep.sleepSeconds(1);
	  driver.quit();
  }

}
