package com.CRM.objectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.CRM.generic.WebDriverUtility.WebDriverUtility;

public class LoginPage extends WebDriverUtility{
	WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(name = "user_name")
	private WebElement UName;
        
	@FindBy(name = "user_password")
	private WebElement Password;
	
	@FindBy(id = "submitButton")
	private WebElement loginbtn;

	public WebElement getUName() {
		return UName;
	}

	public WebElement getPWD() {
		return Password;
	}

	public WebElement getLoginbtn() {
		return loginbtn;
	}
	
	public void login(String URL,String UNAME, String PWD) {
		driver.get(URL);
		driver.manage().window().maximize();
		waitForPageToLoad(driver);
		UName.sendKeys(UNAME);
		Password.sendKeys(PWD);
        loginbtn.click();
	}
}
