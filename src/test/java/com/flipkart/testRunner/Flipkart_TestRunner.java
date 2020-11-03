package com.flipkart.testRunner;

import java.io.File;

import org.testng.annotations.AfterClass;

import com.cucumber.listener.Reporter;

//import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
		features = {"src/test/resources/features/"},
		glue = {"com.flipkart.steps","com.flipkart.utils"},
		monochrome = true,
		plugin= {"pretty",
				"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/extendedReport.html"
				}
	)

public class Flipkart_TestRunner extends AbstractTestNGCucumberTests {

	 @AfterClass
	    public static void writeExtentReport() {
	        Reporter.loadXMLConfig(new File("config/report.xml"));
	    
	    }


}
