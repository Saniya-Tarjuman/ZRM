package com.CRM.objectRepositoryUtility;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInfoPage {
	WebDriver driver;
   public ContactInfoPage(WebDriver driver) {
	   this.driver = driver;
	   PageFactory.initElements(driver, this);
   }
   @FindBy(xpath = "//span[@class='dvHeaderText']")
   private WebElement header;
   
   @FindBy(xpath = "//span[@id='dtlview_Support Start Date']")
   private WebElement msgstart;
  @FindBy(xpath = "//span[@id='dtlview_Support End Date']")
  private WebElement msgend;
public WebElement getHeader() {
	return header;
}

public WebElement getMsgstart() {
	return msgstart;
}
public WebElement getMsgend() {
	return msgend;
}
 public String contactHeaderMsg() {
	 return header.getText();
 }

 
 public String startMsg() {
	 return msgstart.getText();
 }
 public String endMsg() {
	 return msgend.getText();
 }
}
