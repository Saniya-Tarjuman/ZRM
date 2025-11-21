package com.CRM.objectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeadInfoPage {
WebDriver driver;
public LeadInfoPage(WebDriver driver) {
	this.driver  =driver;
	PageFactory.initElements(driver, this);
}
@FindBy(xpath = "//span[@class='dvHeaderText']")
private WebElement header;
@FindBy(id = "dtlview_Company")
private WebElement com_msg;
public WebElement getHeader() {
	return header;
}
public WebElement getCom_msg() {
	return com_msg;
}
}
