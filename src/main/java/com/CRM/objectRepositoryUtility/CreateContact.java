package com.CRM.objectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateContact {
	WebDriver driver;
    public CreateContact(WebDriver driver) {
   	 this.driver = driver;
   PageFactory.initElements(driver, this);	 
    }
    @FindBy(xpath = "//img[@alt='Create Contact...']")
    private WebElement createbtn;
	public WebElement getCreatebtn() {
		return createbtn;
	}
    public void createConatct() {
   	 createbtn.click();
    }
}
