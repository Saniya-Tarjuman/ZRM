package com.CRM.BaseClass;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
//import org.testng.annotations.Optional;
//import org.testng.annotations.Parameters;
import org.testng.annotations.Listeners;

import com.CRM.generic.DataBaseUtility.DataBaseUtility;
import com.CRM.generic.FileUtility.ExcelUtility;
import com.CRM.generic.FileUtility.PropertyUtility;
import com.CRM.generic.WebDriverUtility.JavaUtility;
import com.CRM.generic.WebDriverUtility.UtilityClassObject;
import com.CRM.objectRepositoryUtility.HomePage;
import com.CRM.objectRepositoryUtility.LoginPage;


@Listeners(com.CRM.ListenerUtility.ListenerImplementation.class)
public class BaseClass {
	public DataBaseUtility dutil = new DataBaseUtility();
	public PropertyUtility putil = new PropertyUtility();
	public JavaUtility jutil = new JavaUtility();
	public  ExcelUtility eutil = new ExcelUtility();
	public static WebDriver sdriver;
	public WebDriver driver;
	

       @BeforeSuite(alwaysRun = true)
       public void configBS() {
    	   System.out.println("====Connect to Db, Report Config===");
    	   dutil.getDBConnectionParameterized();
    	
       }
       @BeforeTest(alwaysRun = true)
       public void configBT() {
    	   System.out.println("==before test===");
       }
    //   @Parameters("BROWSER")
       @BeforeClass(alwaysRun = true)
       public void configBC(/*String browser*/) throws IOException {
    	   System.out.println("===Launch the browser===");
    	//   String BROWSER = /*browser;*/putil.getDataFromPropertyFile("Browser");
    	   String BROWSER = System.getProperty("browser", putil.getDataFromPropertyFile("Browser"));
    	   if(BROWSER.equalsIgnoreCase("Chrome")) {
    		   driver = new ChromeDriver();
    	   }else if(BROWSER.equalsIgnoreCase("Firefox")) {
    		   driver = new FirefoxDriver();
    	   }else if(BROWSER.equalsIgnoreCase("Edge")) {
    		   driver = new EdgeDriver();
    	   }else {
    		   driver = new ChromeDriver();
    	   }
    	      sdriver = driver;
    	  UtilityClassObject.setDriver(driver);    
    	 
    	   
       }
       @BeforeMethod(alwaysRun = true)
       public void configBM() throws IOException {
    	   System.out.println("===Login===");
    	   String URL = System.getProperty("Url", putil.getDataFromPropertyFile("Url"));
    	   String UNAME = System.getProperty("Username", putil.getDataFromPropertyFile("Username"));
    	   String PWD = System.getProperty("Password", putil.getDataFromPropertyFile("Password"));
    	   
    	   LoginPage lp = new LoginPage(driver);
             lp.login(URL, UNAME, PWD);
       }
       @AfterMethod(alwaysRun = true)
       public void configAM() {
    	   System.out.println("===Logout===");
    		HomePage hp = new HomePage(driver);   
    	   hp.logout();
    	   
       }
       @AfterClass(alwaysRun = true)
       public void configAC() {
    	   System.out.println("===Close the browser===");
    	   driver.quit();
    	  
       }
       @AfterTest(alwaysRun = true)
       public void configAT() {
    	   System.out.println("===After test===");
       }
       @AfterSuite(alwaysRun = true)
       public void configAS() {
    	   System.out.println("===Close the Db, Report backup===");
    	   dutil.closeDBConnection();
    	   
       }
       
}
