package com.CRM.objectRepositoryUtility;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage {
	WebDriver driver;
     public ContactPage(WebDriver driver) {
    	 this.driver = driver;
    PageFactory.initElements(driver, this);	 
     }
     @FindBy(name = "lastname")
     private WebElement lastname;
     @FindBy(xpath = "//input[@name='account_name']/following-sibling::img")
     private WebElement orgbtn;
     @FindBy(xpath = "(//input[@title='Save [Alt+S]'])[1]")
     private WebElement savebtn;
     @FindBy(name = "support_start_date")
     private WebElement startdate;
     @FindBy(name = "support_end_date")
     private WebElement endate;
     @FindBy(name = "search_text")
     private WebElement search;
     @FindBy(name = "search")
     private WebElement searchbtn;
     public WebElement getSearch() {
		return search;
	}
	public WebElement getSearchbtn() {
		return searchbtn;
	}
	public WebElement getStartdate() {
		return startdate;
	}
	public WebElement getEndatet() {
		return endate;
	}
	public WebElement getOrgbtn() {
		return orgbtn;
	}
	public WebElement getSavebtn() {
		return savebtn;
	}
	public WebElement getCreatebtn() {
		return lastname;
	}
     public void lastNameContact(String lastnam) {
    	 lastname.sendKeys(lastnam);
    	 savebtn.click();
     }
     public void supportDateInContact(String lastnam, String start, String end) {
    	 lastname.sendKeys(lastnam);
       startdate.clear();
       startdate.sendKeys(start);
       endate.clear();
       endate.sendKeys(end);
    	 savebtn.click();
     }
     public void orgInContact(String start, String end, String lastnam, String org) {
    	 lastname.sendKeys(lastnam);
    	 startdate.sendKeys(start);
    	 endate.sendKeys(end);
    	String parent = driver.getWindowHandle();
    	 orgbtn.click();
    	Set<String> child = driver.getWindowHandles();
    	child.remove(parent);
    	for(String win : child) {
    		driver.switchTo().window(win);
    	search.sendKeys(org);	
    	searchbtn.click();
    	driver.findElement(By.linkText(org)).click();
    	}
    	driver.switchTo().window(parent);
    	savebtn.click();
     }
    
     
     
}
