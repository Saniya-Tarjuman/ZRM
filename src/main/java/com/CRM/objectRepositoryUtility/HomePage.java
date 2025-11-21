package com.CRM.objectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;
public HomePage(WebDriver driver) {
	this.driver = driver;
	PageFactory.initElements(driver, this);
}
@FindBy(linkText = "Organizations")
private WebElement org;
@FindBy(linkText = "Contacts")
private WebElement cont;
@FindBy(linkText = "More")
private WebElement morbtn;
@FindBy(linkText = "Campaigns")
private WebElement campbtn;
@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
private WebElement admin;
@FindBy(linkText = "Products")
private WebElement produ;
@FindBy(linkText = "Opportunities")
private WebElement opportu;
@FindBy(linkText = "Leads")
private WebElement lead;
public WebElement getOpportu() {
	return opportu;
}
public WebElement getLead() {
	return lead;
}
public WebElement getProdu() {
	return produ;
}
@FindBy(linkText = "Sign Out")
private WebElement sign;
public WebElement getOrg() {
	return org;
}
public WebElement getCont() {
	return cont;
}
public WebElement getMorbtn() {
	return morbtn;
}
public WebElement getCampbtn() {
	return campbtn;
}
public WebElement getAdmin() {
	return admin;
}
public WebElement getSign() {
	return sign;
}
public void campaignbtn() {
	morbtn.click();
	campbtn.click();
}
public void productLink() {
	produ.click();
}
public void logout() {
	admin.click();
	sign.click();
}
public void orgCreate() {
	org.click();
}
public void createContact() {
	cont.click();
}
public void createOpportunity() {
	opportu.click();
}
public void createLead() {
	lead.click();
}
}
