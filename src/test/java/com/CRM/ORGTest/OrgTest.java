package com.CRM.ORGTest;

import java.io.IOException;
import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.CRM.generic.FileUtility.ExcelUtility;
import com.CRM.generic.FileUtility.PropertyUtility;

public class OrgTest {

	public static void main(String[] args) throws IOException {
		PropertyUtility putil = new PropertyUtility();
		ExcelUtility eutil = new ExcelUtility();
		String BROWSER = putil.getDataFromPropertyFile("Browser");
		String URL = putil.getDataFromPropertyFile("Url");
		String UNAME = putil.getDataFromPropertyFile("Username");
		String PWD = putil.getDataFromPropertyFile("Password");
		
		Random ran = new Random();
		int r = ran.nextInt(100);
    String org = eutil.getDataFromExcel("OrgName", 1, 1)+r;
      
    WebDriver driver = null;
    if(BROWSER.equals("Chrome")) {
    	driver = new ChromeDriver();
    }else if(BROWSER.equals("Firefox")) {
    	driver = new FirefoxDriver();
    }else if(BROWSER.equals("Edge")) {
    	driver = new EdgeDriver();
    }
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    driver.get(URL);
  
    driver.findElement(By.name("user_name")).sendKeys(UNAME);
    driver.findElement(By.name("user_password")).sendKeys(PWD);
    driver.findElement(By.id("submitButton")).click();
    driver.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click();
    driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
    driver.findElement(By.name("accountname")).sendKeys(org);
    driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
      String header = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
           if(header.contains(org)) {
        	   System.out.println(org+" is created successfully");
            }else {
            	System.out.println("Organization is not created");
            }
           
     driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();  
     driver.findElement(By.linkText("Sign Out")).click();
     driver.quit();
	
	}

}
