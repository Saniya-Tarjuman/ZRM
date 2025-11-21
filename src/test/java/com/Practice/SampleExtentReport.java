package com.Practice;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class SampleExtentReport {
	public ExtentReports report;
	@BeforeSuite
	public void cofigBs() {
		
		//spark report config
		ExtentSparkReporter spark = new ExtentSparkReporter("./AdvanceReport/report.html");
		spark.config().setDocumentTitle("CRM Test Suite Results");
		spark.config().setReportName("CRM Report");
		spark.config().setTheme(Theme.STANDARD);
		
		//add env information 
		 report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "Window-10");
		report.setSystemInfo("Browser", "Chrome-100");
	}
	@AfterSuite
	public void configAS() {
		report.flush();
	}
@Test
public void sampleTest() {
	WebDriver driver = new ChromeDriver();
	driver.get("http://localhost:8888/");
	TakesScreenshot ss = (TakesScreenshot)driver;
	String file = ss.getScreenshotAs(OutputType.BASE64);
	
	ExtentTest test = report.createTest("sampleTest");
	test.log(Status.INFO,"Login to the applicaton");
	test.log(Status.INFO,"Navigate to the Contact page");
	test.log(Status.INFO,"Create Contact");
	if("HDFC".equals("HDC")) {
		test.log(Status.PASS, "Contact is created");
	}else {
		test.addScreenCaptureFromBase64String(file, "ErrorFile");
	}
	driver.close();
}

}
