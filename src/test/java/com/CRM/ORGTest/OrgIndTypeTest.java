package com.CRM.ORGTest;

import java.io.IOException;
import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.CRM.generic.FileUtility.ExcelUtility;
import com.CRM.generic.FileUtility.PropertyUtility;

public class OrgIndTypeTest {

	public static void main(String[] args) throws IOException {
		PropertyUtility putil = new PropertyUtility();
		ExcelUtility eutil = new ExcelUtility();
		String BROWSER = putil.getDataFromPropertyFile("Browser");
        String URL = putil.getDataFromPropertyFile("Url");
        String UNAME = putil.getDataFromPropertyFile("Username");
        String PWD = putil.getDataFromPropertyFile("Password");
        Random ran = new Random();
        int r=  ran.nextInt(100);
        String org = eutil.getDataFromExcel("OrgName", 1, 1)+r;
        String ind = eutil.getDataFromExcel("OrgName", 1, 2);
        String type = eutil.getDataFromExcel("OrgName", 1, 3);
       WebDriver driver = null;
       if(BROWSER.equals("Chrome")) {
    	   driver = new ChromeDriver();
       }else if(BROWSER.equals("Firefox")) {
    	   driver = new FirefoxDriver();
       }else if(BROWSER.equals("Edge")) {
    	   driver = new EdgeDriver();
       }else {
    	   driver = new ChromeDriver();
       }
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
       driver.get(URL);
       driver.findElement(By.name("user_name")).sendKeys(UNAME);
       driver.findElement(By.name("user_password")).sendKeys(PWD);
       driver.findElement(By.id("submitButton")).click();
       driver.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click();
       driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
       driver.findElement(By.name("accountname")).sendKeys(org);
       WebElement indus = driver.findElement(By.name("industry"));
       Select s = new Select(indus); 
       s.selectByVisibleText(ind);
       WebElement typ = driver.findElement(By.name("accounttype"));
       Select s1 = new Select(typ);
        s1.selectByVisibleText(type);
        driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
        String header_org = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
        String msg = driver.findElement(By.xpath("//span[@class='small']")).getText();
        if(header_org.contains(org)) {
       	 System.out.println(org+" is created successfully");
        }else {
       	 System.out.println("Organization is not created");
        }
          System.out.println(msg);
          
          String msg_ind = driver.findElement(By.xpath("//td[@id='mouseArea_Industry']")).getText();
          String msg_typ = driver.findElement(By.xpath("//td[@id='mouseArea_Type']")).getText();
          if(msg_ind.contains(ind)) {
       	   System.out.println(ind+"Information is verified===Pass ");
          }else {
       	   System.out.println(ind+" Information is not verified===Fail");
          }
          if(msg_typ.contains(type)) {
       	   System.out.println(type+" Information is verified===Pass");
          }else {
       	   System.out.println(type+" Information is not verified===Fail");
          }
          WebElement logout =  driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
          Actions act = new Actions(driver);
          act.moveToElement(logout).click().perform();
         driver.findElement(By.linkText("Sign Out")).click();
        driver.quit();
       
	}

}
