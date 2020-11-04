package com.flipkart.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitTypes {

	private static WebDriver driver;
	private static int maxTimeOut=20;
	
	public WaitTypes(WebDriver driver) {
		
		this.driver=driver;
	}
	
	public WebElement clickWhenReady(WebElement element) {
		
		try {
			WebDriverWait wait= new WebDriverWait(driver, maxTimeOut);
			return wait.until(ExpectedConditions.elementToBeClickable(element));
		} catch (Exception e) {

			e.printStackTrace();
		}
		return null;
	}
	
	public boolean isElementDisplayed(WebElement element) {
		
		 
		if(element.isDisplayed())
			return true;
		 
		 else 
			 return false;
	}

}

