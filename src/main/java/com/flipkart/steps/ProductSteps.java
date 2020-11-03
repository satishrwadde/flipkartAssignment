package com.flipkart.steps;

import org.openqa.selenium.Keys;

import com.flipkart.pom.ProductPom;
import com.flipkart.utils.CaptureScreenshot;
import com.flipkart.utils.Driver;
import com.flipkart.utils.Sleep;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ProductSteps {

	@Given("^Launch webbrowser and then flipkart website$")
	public void launch_webbrowser_and_then_flipkart_website() throws Throwable {
		
		System.out.println("Browser & website launched from Hooks !");
		ProductPom.sendClosePop().click();
	}
	
	
	@When("^User search product in search box$")
	public void user_search_product_in_search_box() throws Throwable {

		System.out.println("Inside user_search_product_in_search_box");
		
		ProductPom.sendProductMenu().sendKeys("watch");
		ProductPom.sendProductMenu().sendKeys(Keys.ENTER);

	}

	@Then("^Filter for \"([^\"]*)\" using ideal for option$")
	public void filter_for_using_ideal_for_option(String filterValue) throws Throwable {
	
		//filterValue = Men,Fossil,Boys,Casio etc
		ProductPom.filterCheckBoxMethod(filterValue).click();
		Sleep.sleepSeconds(1);
	}

	@Then("^Filter using \"([^\"]*)\"$")
	public void filter_using(String filterValue) throws Throwable {
		
		//filterValue = Men,Fossil,Boys,Casio etc
		ProductPom.filterCheckBoxMethod(filterValue).click();
		Sleep.sleepSeconds(1);
	}

	@Then("^Select filter using price filter \"([^\"]*)\"$")
	public void select_filter_using_price_filter(String minPrice) throws Throwable {

		ProductPom.sendDropDownElement(minPrice);
		Sleep.sleepSeconds(1);
	}

	@Then("^Select filter sort by \"([^\"]*)\"$")
	public void select_filter_sort_by(String arg1) throws Throwable {
	    
		ProductPom.sendSortByWebElement(arg1).click();
		Sleep.sleepSeconds(1);
	}

	@Then("^Get the price of first item$")
	public void get_the_price_of_first_item() throws Throwable {

		String price = ProductPom.sendProductPrice().get(0).getText();
		System.out.println("First product Price is : >> "+ price);
		Sleep.sleepSeconds(2);
	}

	@Then("^Capture headline from product page$")
	public void capture_headline_from_product_page() throws Throwable {
		
		ProductPom.sendProductHeadline();
	
	}
	
	@Then("^Capture screenshot of product page$")
	public void capture_screenshot_of_product_page() throws Throwable {

		System.out.println("SCreenshot captured in sendProductHeadline()");
		
	}
}
