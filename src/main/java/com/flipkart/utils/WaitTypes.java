package com.flipkart.utils;

import org.openqa.selenium.By;
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
	
	public WebElement clickWhenReady(By locator) {
		
		try {
			WebDriverWait wait= new WebDriverWait(driver, maxTimeOut);
			return wait.until(ExpectedConditions.elementToBeClickable(locator));
		} catch (Exception e) {

			e.printStackTrace();
		}
		return null;
	}
	
	public boolean isElementDisplayed(By locator) {
		
		 
		if(driver.findElement(locator).isDisplayed())
			return true;
		 
		 else 
			 return false;
	}

	public WebElement elementVisible(By locator) {
		
		try {
			WebDriverWait wait= new WebDriverWait(driver, maxTimeOut);
			return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		} catch (Exception e) {

			e.printStackTrace();
		}
		
		return null;
	}

}

