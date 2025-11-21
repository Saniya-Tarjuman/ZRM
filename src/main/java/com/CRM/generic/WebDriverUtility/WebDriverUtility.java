package com.CRM.generic.WebDriverUtility;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {
	//implicit wait
public void waitForPageToLoad(WebDriver driver) {
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
}
//explicit wait
public void waitForElementPresent(WebDriver driver, WebElement element) {
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	wait.until(ExpectedConditions.visibilityOf(element));
}
//switch to window
public void switchToWindowUrl(WebDriver driver, String partialUrl) {
	Set<String> set = driver.getWindowHandles();
	Iterator<String> it = set.iterator();
	while(it.hasNext()) {
	     String windowID = it.next();
	     driver.switchTo().window(windowID);
	     String acturl = driver.getCurrentUrl();
	     if(acturl.contains(partialUrl)) {
	    	 break;
	     }
	}
}
//switch to window
public void switchToWindowTitle(WebDriver driver, String partialUrl) {
	Set<String> set = driver.getWindowHandles();
	Iterator<String> it = set.iterator();
	while(it.hasNext()) {
	String windowID = it.next();
	driver.switchTo().window(windowID);
	String actTitle = driver.getTitle();
	if(actTitle.contains(partialUrl)) {
		break;
	}
}
}
//switch to window
public void toSwitchToWindow(WebDriver driver, String partialTitle) {
	Set<String> allId = driver.getWindowHandles();
	for(String win : allId) {
		String actTitle = driver.switchTo().window(win).getTitle();
		if(actTitle.contains(partialTitle)) {
			break;
		}
	}
}
//switch to frame
public void switchtoFrame(WebDriver driver, int index){
	driver.switchTo().frame(index);
	}
public void switchToFrame(WebDriver driver, String nameID) {
	driver.switchTo().frame(nameID);
}
public void switchToFrame(WebDriver driver, WebElement element) {
	driver.switchTo().frame(element);
}
//switch to alert
public void switchToAlertAccept(WebDriver driver) {
	driver.switchTo().alert().accept();
}
public void switchToAlertDismiss(WebDriver driver) {
	driver.switchTo().alert().dismiss();
}
//Select class
public void select(WebElement element, int index) {
	Select s = new Select(element);
	s.selectByIndex(index);
}
public void select(WebElement element, String text) {
	Select s = new Select(element);
	s.selectByVisibleText(text);
}
public void select(String value, WebElement element) {
	Select s = new Select(element);
	s.selectByValue(value);
}
//Actions class
public void moveAction(WebDriver driver, WebElement element) {
	Actions act = new Actions(driver);
	act.moveToElement(element).perform();
}
public void doubleClickAction(WebDriver driver, WebElement element) {
	Actions act = new Actions(driver);
	act.doubleClick(element).perform();
}
public void RightClick(WebDriver driver, WebElement element) {
	Actions act = new Actions(driver);
	act.contextClick(element).perform();
}
public void clickHoldAction(WebDriver driver, WebElement element) {
	Actions act = new Actions(driver);
	act.clickAndHold(element).perform();
}
public void dragDropAction(WebDriver driver, WebElement source, WebElement dest) {
	Actions act = new Actions(driver);
	act.dragAndDrop(source, dest).perform();
	
}
public void scrollByAmountAction(WebDriver driver, int x, int y) {
	Actions act = new Actions(driver);
	act.scrollByAmount(x, y).perform();
}
public void scrollByelement(WebDriver driver, WebElement element) {
	Actions act = new Actions(driver);
	act.scrollToElement(element).perform();
}
//shadow root element


}
