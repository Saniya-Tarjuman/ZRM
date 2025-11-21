package com.CRM.objectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.CRM.generic.WebDriverUtility.WebDriverUtility;

public class Organizaion {
     WebDriver driver;
    
	public Organizaion(WebDriver driver) {
	this.driver = driver;
	PageFactory.initElements(driver, this);
	}
    @FindBy(name = "accountname")
    private WebElement orgname;
    @FindBy(name = "industry")
    private WebElement industryName;
 	@FindBy(name = "accounttype")
 	private WebElement typeName;
    @FindBy(id = "phone")
    private WebElement phon;
    @FindBy(xpath = "(//input[@title='Save [Alt+S]'])[1]")
    private WebElement savebtn;
	public WebElement getOrgname() {
		return orgname;
	}
	
	public WebElement getIndustryName() {
		return industryName;
	}

	public WebElement getTypeName() {
		return typeName;
	}

	public WebElement getPhon() {
		return phon;
	}
	public WebElement getSavebtn() {
		return savebtn;
	}
	WebDriverUtility wutil = null;
    public void addOrgIndTyp(String org, String indust, String type) {
    	orgname.sendKeys(org);
    	 wutil = new WebDriverUtility();
    	wutil.select(industryName, indust);
      wutil.select(typeName, type);
    	savebtn.click();
 }
    public void addOrg(String org) {
    	orgname.sendKeys(org);
    	savebtn.click();
    }
    public void addPhone(String org, String indust, String type, String phone) {
    	orgname.sendKeys(org);
   	 wutil = new WebDriverUtility();
   	wutil.select(industryName, indust);
     wutil.select(typeName, type);
    	phon.sendKeys(phone);
    	savebtn.click();
    	
}
}