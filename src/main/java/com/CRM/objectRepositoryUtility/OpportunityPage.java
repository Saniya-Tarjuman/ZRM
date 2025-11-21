package com.CRM.objectRepositoryUtility;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpportunityPage {
	 WebDriver driver;
	    
		public OpportunityPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		}
	    @FindBy(name = "potentialname")
	    private WebElement oppname;
	    @FindBy(xpath = "//input[@id='related_to_display']/following-sibling::img")
	    private WebElement relateName;
	    @FindBy(xpath = "(//input[@title='Save [Alt+S]'])[1]")
	    private WebElement savebtn;
	    @FindBy(name = "search_text")
	     private WebElement search;
	     @FindBy(name = "search")
	     private WebElement searchbtn;
		public WebElement getOppname() {
			return oppname;
		}
		public WebElement getRelateName() {
			return relateName;
		}
		public WebElement getSavebtn() {
			return savebtn;
		}
		public void addOpp(String opp, String org) {
			oppname.sendKeys(opp);
			String parent = driver.getWindowHandle();
			relateName.click();
			Set<String> child = driver.getWindowHandles();
			child.remove(parent);
			for(String ele : child) {
				driver.switchTo().window(ele);
				search.sendKeys(org);
				searchbtn.click();
				driver.findElement(By.linkText(org)).click();
			}
			driver.switchTo().window(parent);
			savebtn.click();
		}
}
