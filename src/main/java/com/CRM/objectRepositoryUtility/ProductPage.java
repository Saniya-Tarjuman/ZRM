package com.CRM.objectRepositoryUtility;

import java.util.List;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
	WebDriver driver;
public ProductPage(WebDriver driver) {
	this.driver = driver;
	PageFactory.initElements(driver, this);
}
@FindBy(xpath = "//a[@title='Products']")
private List<WebElement> allpro;
public List<WebElement> getAllpro() {
	return allpro;
}
String data;
public void allProduct() {
	
	for(WebElement ele : allpro) {
		
		data=ele.getText();
		System.out.println(data);
		 
	}
}

}
