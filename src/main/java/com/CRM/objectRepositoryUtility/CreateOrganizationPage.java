package com.CRM.objectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateOrganizationPage {
	 WebDriver driver;
		public CreateOrganizationPage(WebDriver driver) {
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}
		@FindBy(xpath = "//img[@alt='Create Organization...']")
		private WebElement createbtn;
		public WebElement getCreatebtn() {
			return createbtn;
		}
	   public void createOrg() {
		   createbtn.click();
	   }
}
