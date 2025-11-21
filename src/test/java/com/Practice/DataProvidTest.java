package com.Practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class DataProvidTest {
@Test
public void productInfoTest() {
	WebDriver driver = new ChromeDriver();
	 driver.manage().window().maximize();
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	 driver.get("https://www.amazon.in/");
	driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone",Keys.ENTER);
	String x = "(//span[text()='Apple iPhone 15 (128 GB) - Black']/ancestor::div[@class='puisg-row'])[1]/div[2]/div/div/div[3]/div/div/div/div/div/a/span[1]/span[1]";
	String price = driver.findElement(By.xpath(x)).getText();
	System.out.println(price);
	driver.quit();
}
}
