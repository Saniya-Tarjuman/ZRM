package com.CRM.objectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeadPage {
WebDriver driver;
public LeadPage(WebDriver driver) {
	this.driver = driver;
	PageFactory.initElements(driver, this);
}
@FindBy(name = "lastname")
private WebElement lstname;
@FindBy(name = "company")
private WebElement company;
@FindBy(xpath = "(//input[@title='Save [Alt+S]'])[1]")
private WebElement savebtn;
public WebElement getLstname() {
	return lstname;
}
public WebElement getCompany() {
	return company;
}
public WebElement getSavebtn() {
	return savebtn;
}
public void addNameCompany(String lastName, String Company) {
	lstname.sendKeys(lastName);
	company.sendKeys(Company);
	savebtn.click();
}
}
