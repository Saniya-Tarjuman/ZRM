package com.CRM.ORGTest;

import java.io.IOException;
import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.CRM.generic.FileUtility.ExcelUtility;
import com.CRM.generic.FileUtility.PropertyUtility;

public class ContactTest {

	public static void main(String[] args) throws IOException {
		
		PropertyUtility putil = new PropertyUtility();
		ExcelUtility eutil = new ExcelUtility();
		String BROWSER = putil.getDataFromPropertyFile("Browser");
		String URL = putil.getDataFromPropertyFile("Url");
		String UNAME = putil.getDataFromPropertyFile("Username");
		String PWD = putil.getDataFromPropertyFile("Password");

    String lstname =eutil.getDataFromExcel("Contact", 1, 1);
         WebDriver driver = null;
         if(BROWSER.equals("Chrome")) {
        	 driver = new ChromeDriver();
         }else if(BROWSER.equals("Firefox")) {
        	 driver = new FirefoxDriver();
         }else if(BROWSER.equals("Edge")) {
        	 driver = new EdgeDriver();
         }
         driver.manage().window().maximize();
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
         driver.get(URL);
         driver.findElement(By.name("user_name")).sendKeys(UNAME);
         driver.findElement(By.name("user_password")).sendKeys(PWD);
         driver.findElement(By.id("submitButton")).click();
         driver.findElement(By.linkText("Contacts")).click();
         driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
         driver.findElement(By.name("lastname")).sendKeys(lstname);
         driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();  
         String header = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
         if(header.contains(lstname)) {
         	  System.out.println(lstname+" last name is added==Pass");
         }else {
         	  System.out.println(lstname+" Failed to add the last name==Fail");
         }      
      driver.quit();  	 

	}

}
