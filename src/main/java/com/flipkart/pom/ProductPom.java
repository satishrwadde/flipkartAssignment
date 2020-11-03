package com.flipkart.pom;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.flipkart.utils.CaptureScreenshot;
import com.flipkart.utils.Sleep;
import com.flipkart.utils.Utils;
import com.flipkart.utils.WaitTypes;

public class ProductPom {

	private static WebDriver driver;
	private static WaitTypes waitTypes= null;


	public ProductPom(WebDriver driver) {
		this.driver = driver;
		this.waitTypes= new WaitTypes(driver);

		PageFactory.initElements(driver, this);
	}
	
	public static WebElement sendClosePop() {
		
		WebElement X = driver.findElement(By.xpath("//button[@class='_2AkmmA _29YdH8']"));
	
		return X;
	}
	
	public static WebElement sendProductMenu() {
		
		WebElement search = driver.findElement(By.xpath("//input[@class='LM6RPg' and @name='q']"));
		
		return search;
		
	}
	
	public static WebElement filterCheckBoxMethod(String filterValue) {
		
		List<WebElement> checkboxList=driver.findElements(By.xpath("//*[@class='_4IiNRh _2mtkou']/div/div/label/div[2]"));
		
		System.out.println("CheckboxList ::>" + checkboxList);
		
		 // This line is to wait for the anyone element to be available
	    //  waitTypes.elementVisible(By.xpath("//*[@class='_4IiNRh _2mtkou']/div/div/label/div[2]"));
					
		for (int i = 0; i < checkboxList.size(); i++) {
			
			if ((checkboxList.get(i).getText()).equalsIgnoreCase(filterValue)) {
				
				System.out.println("Checkbox Text : >>"+checkboxList.get(i).getText());
				return checkboxList.get(i);
			}
			
		}
		return null;
	}
	
	
	public static void sendDropDownElement(String value) {
		
		System.out.println("Inside sendDropDownElement");
		Select selectElement =new Select(driver.findElement(By.xpath("//select[@class='fPjUPw']")));
//		selectElement.selectByVisibleText(value);
		selectElement.selectByValue(value);
		Sleep.sleepSeconds(2);
	}
	
	public static WebElement sendSortByWebElement(String sortBy) {
		
		System.out.println("Inside sendSortByWebElement");
		WebElement sortByElement=null;
		sortByElement = driver.findElement(By.xpath("//div[@class='_1xHtJz' and contains(text(),'"+sortBy+"')]"));
	
		return sortByElement;
	}
	
	public static List<WebElement> sendProductPrice() {
		
		
//		waitTypes.elementVisible(By.xpath("//a[@class='_2W-UZw']/div/div"));
		
		List<WebElement> priceElement = driver.findElements(By.xpath("//a[@class='_2W-UZw']/div/div"));
		return priceElement;
		
	}
	
	public static String sendProductHeadline() {
		
		WebElement productElement = driver.findElement(By.xpath("//a[@class='_3dqZjq']"));
		String parentWindow = driver.getWindowHandle();
		System.out.println("parentWindow:> "+ parentWindow);
		productElement.click();
		Sleep.sleepMS(2000);
		Set<String> handleSet = driver.getWindowHandles();
		
		Utils.switchControlToChild(handleSet,parentWindow);
		
		Sleep.sleepSeconds(5);
		WebElement productHeadElement = driver.findElement(By.xpath("//div[contains(@class,'col-12-12')]/div/div/h1/span"));
		System.out.println("productHeadElement :>"+ productHeadElement);
		String headline = productHeadElement.getText();
		System.out.println("Product Headline :>>"+headline);
		
		//capture screenshot of product details page
		CaptureScreenshot.screenshot();
		
		driver.switchTo().window(parentWindow);
		
		return headline;
		
	}
	
}
