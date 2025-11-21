package com.CRM.objectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignPage {
	WebDriver driver;
    public CampaignPage(WebDriver driver) {
    	this.driver = driver;
    	PageFactory.initElements(driver, this);
    }
    @FindBy(name = "campaignname")
    private WebElement camp;
    @FindBy(name = "closingdate")
    private WebElement closedate;
    @FindBy(xpath = "(//input[@title='Save [Alt+S]'])[1]")
    private WebElement savebtn;
	public WebElement getCamp() {
		return camp;
	}
	public WebElement getClosedate() {
		return closedate;
	}
	public WebElement getSavebtn() {
		return savebtn;
	}
    public void campaignNameDate(String campname, String closeDate) {
    	camp.sendKeys(campname);
    	closedate.sendKeys(closeDate);
    	savebtn.click();
    }
}
