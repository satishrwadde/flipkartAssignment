package com.flipkart.utils;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class Utils {

	private static WebDriver driver;
	
	public Utils(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public static String FirstLetterCaps(String str) {
		
		String finalStr = str.substring(0, 1).toUpperCase() + str.substring(1);
		return finalStr;
		//System.out.println(output);
		
		
	}
	
}
