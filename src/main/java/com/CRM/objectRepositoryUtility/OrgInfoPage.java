package com.CRM.objectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrgInfoPage {
	WebDriver driver;
    public OrgInfoPage(WebDriver driver) {
   	 this.driver = driver;
   PageFactory.initElements(driver, this);	 
    }
    @FindBy(xpath = "//span[@class='dvHeaderText']")
    private WebElement header;
    @FindBy(id = "dtlview_Industry")
    private WebElement indus;
    @FindBy(id = "dtlview_Type")
    private WebElement typ;
    @FindBy(id = "mouseArea_Phone")
    private WebElement phone;
	public WebElement getIndus() {
		return indus;
	}
	public WebElement getTyp() {
		return typ;
	}
	public WebElement getPhone() {
		return phone;
	}
	public WebElement getCreatebtn() {
		return header;
	}
    public String headerOrg() {
    	String orgmsg = header.getText();
    	return orgmsg;
    }
    public String industOrg() {
    	String inmsg = indus.getText();
    	return inmsg;
    }
    public String typeOrg() {
    	return typ.getText();
    }
    public String phoneOrg() {
    	return phone.getText();
    }
}
