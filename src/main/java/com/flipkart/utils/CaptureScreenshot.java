package com.flipkart.utils;

import java.io.File;
import java.io.IOException;
import java.util.GregorianCalendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class CaptureScreenshot {

	private static WebDriver driver;
	
	public CaptureScreenshot(WebDriver driver) {
		System.out.println("CaptureScreenshot Constructor Before setting driver  ***********");
		this.driver=driver;
		System.out.println("CaptureScreenshot Constructor After setting driver  ***********");
	}
	
	public static void screenshot() {
		
		String localDir = System.getProperty("user.dir");
//		System.out.println("localDir : >"+ localDir);
//		localDir : >C:\Users\SatishWadde\git\flipkart\Flipkart
		String path=localDir+"\\screenshots\\";
		String fileName="";
		System.out.println(path);
		GregorianCalendar calendar=new GregorianCalendar();
		int date=calendar.get(calendar.DATE);
		int minute=calendar.get(calendar.MINUTE);
		int seconds=calendar.get(calendar.SECOND);
		
		
		fileName=Integer.toString(date) + "-" +
						Integer.toString(minute)+ "-" +
						Integer.toString(seconds)+".png";
		
		TakesScreenshot takesScreenshot=(TakesScreenshot) driver;
		
		System.out.println("takesScreenshot =>"+takesScreenshot);
		File file=takesScreenshot.getScreenshotAs(OutputType.FILE); //this gives raw file.
		System.out.println("file =>"+file);
		//now we have to copy this raw file into secondary storage using commons-io
		
		try {

			FileUtils.copyFile(file, new File(path+fileName));
			System.out.println("Inside copyFile from raw to secondary storage*********");

		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}

	public static void screenshot(String fileName) {
		
		String localDir = System.getProperty("user.dir");
		String path=localDir+"\\screenshots\\";

		TakesScreenshot takesScreenshot=(TakesScreenshot) driver;
		
		File file=takesScreenshot.getScreenshotAs(OutputType.FILE); //this gives raw file.
		
		//now we have to copy this raw file into secondary storage using commons-io
		
		try {
			FileUtils.copyFile(file, new File(path + fileName + ".png"));
		} catch (IOException e) {

			e.printStackTrace();
		}
		
		
	}
	
	public static void main(String[] args) {
		
		CaptureScreenshot captureScreenshot = new CaptureScreenshot(driver);
		
		captureScreenshot.screenshot();
	}
}
