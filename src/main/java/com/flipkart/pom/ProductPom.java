package com.flipkart.pom;

import static org.testng.Assert.assertNotNull;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.flipkart.utils.Sleep;

public class ProductPom {

	private static WebDriver driver;



	public ProductPom(WebDriver driver) {
		this.driver = driver;
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
		
		List<WebElement> checkboxList=null;
		checkboxList = driver.findElements(By.xpath("//*[@class='_4IiNRh _2mtkou']/div/div/label/div[2]"));
			
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
		System.out.println("handlesSet : >"+ handleSet);
		Iterator<String> it  = handleSet.iterator();
		String childWindow=null;
		
		while (it.hasNext()) {
			 childWindow = it.next();
		}
		
		System.out.println("childWindow :>"+ childWindow);
		
		driver.switchTo().window(childWindow);
		
		Sleep.sleepSeconds(5);
		WebElement productHeadElement = driver.findElement(By.xpath("//div[contains(@class,'col-12-12')]/div/div/h1/span"));
		System.out.println("productHeadElement :>"+ productHeadElement);
		String headline = productHeadElement.getText();
		System.out.println("Product Headline :>>"+headline);
		driver.switchTo().window(parentWindow);
		
		return headline;
		
	}
	
}
