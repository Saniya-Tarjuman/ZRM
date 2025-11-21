package com.Practice;

//import java.io.File;
import java.io.IOException;

//import org.apache.commons.io.FileUtils;
//import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.Test;

public class ScreenShot {
@Test
public void takeScreenShot() throws IOException {
	WebDriver driver = new ChromeDriver();
	driver.get("https://www.flipkart.com/");
	//EventFiringWebDriver e = new EventFiringWebDriver(driver);
	//File src = e.getScreenshotAs(OutputType.FILE);
	
	
	//FileUtils.copyFile(src, new File("./screenshot/test.png"));
}
}
