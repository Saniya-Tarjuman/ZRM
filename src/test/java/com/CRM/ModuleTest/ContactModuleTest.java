package com.CRM.ModuleTest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.CRM.BaseClass.BaseClass;
import com.CRM.objectRepositoryUtility.ContactInfoPage;
import com.CRM.objectRepositoryUtility.ContactPage;
import com.CRM.objectRepositoryUtility.CreateContact;
import com.CRM.objectRepositoryUtility.CreateOrganizationPage;
import com.CRM.objectRepositoryUtility.HomePage;
import com.CRM.objectRepositoryUtility.OrgInfoPage;
import com.CRM.objectRepositoryUtility.Organizaion;

import junit.framework.Assert;

public class ContactModuleTest extends BaseClass {
@Test(groups = {"Smoke Testing"})
public void createContactTest() throws EncryptedDocumentException, IOException {
	int r = jutil.getRandomNum(100);
	// Excel
	String lstname = eutil.getDataFromExcel("Contact", 1, 1) + r;

	// Actual test script
	HomePage hp = new HomePage(driver);
	hp.createContact();
	CreateContact cc = new CreateContact(driver);
	cc.createConatct();
	ContactPage cp = new ContactPage(driver);
	cp.lastNameContact(lstname);
	ContactInfoPage cip = new ContactInfoPage(driver);
	String msg = cip.contactHeaderMsg();
	boolean status = msg.contains(lstname);
	Assert.assertEquals(status, true);
	System.out.println(lstname + " last name is added==Pass");
	
}
@Test(groups = {"Regression Testing"})
public void createContactSupportDateTest() throws EncryptedDocumentException, IOException {
	String lstname = eutil.getDataFromExcel("Contact", 1, 1);

	String end = jutil.getRequiredDateyyyyMMdd(5);
	String start = jutil.getSystemDate();
	HomePage hp = new HomePage(driver);
	hp.createContact();
	CreateContact cc = new CreateContact(driver);
	cc.createConatct();
	ContactPage cp = new ContactPage(driver);
	cp.supportDateInContact(lstname, start, end);
	ContactInfoPage cip = new ContactInfoPage(driver);
	String msg_lstname = cip.contactHeaderMsg();
	SoftAssert soft = new SoftAssert();
	soft.assertEquals(msg_lstname, lstname);
	System.out.println(lstname + " is added in the contact==Pass");
	

	String start_header = cip.startMsg();
	boolean status = start_header.contains(start);
	Assert.assertEquals(status, true);
		System.out.println(start + "Support Start date is added==Pass");
	
	String end_header = cip.endMsg();
	boolean status2 = end_header.contains(end);
	Assert.assertEquals(status2, true);
		System.out.println(end + "Support end date is added==Pass");
	soft.assertAll();
}
@Test(groups = {"Regression Testing"})
public void createContactWithOrgTest() throws EncryptedDocumentException, IOException {
	int r = jutil.getRandomNum(1000);

	String lstname = eutil.getDataFromExcel("Contact", 1, 1);
	String org = eutil.getDataFromExcel("Contact", 1, 2) + r;

	String end = jutil.getRequiredDateyyyyMMdd(5);
	String start = jutil.getSystemDate();
	HomePage hp = new HomePage(driver);
	hp.orgCreate();
	CreateOrganizationPage cop = new CreateOrganizationPage(driver);
	cop.createOrg();
	Organizaion o = new Organizaion(driver);
	o.addOrg(org);
	OrgInfoPage oip = new OrgInfoPage(driver);
	String header = oip.headerOrg();
	boolean status = header.contains(org);
	Assert.assertEquals(status, true);
		System.out.println("Organization is created");
	

	hp.createContact();
	CreateContact cc = new CreateContact(driver);
	cc.createConatct();
	ContactPage cp = new ContactPage(driver);
	cp.supportDateInContact(lstname, start, end);
	ContactInfoPage cip = new ContactInfoPage(driver);
	String msg_lstname = cip.contactHeaderMsg();
	boolean statusname = msg_lstname.contains(lstname);
   Assert.assertEquals(statusname, true);
		System.out.println(lstname + " is added in the contact==Pass");
	

	
	String start_header = cip.startMsg();
	SoftAssert soft = new SoftAssert();
	soft.assertEquals(start, start_header);
		System.out.println(start + "Support Start date is added==Pass");
	
	String end_header = cip.endMsg();
	soft.assertEquals(end, end_header);
	System.out.println(end + "Support end date is added==Pass");
	

	WebElement msg = driver.findElement(By.xpath("//a[text()='" + org + "']"));
	String org_msg = msg.getText();
	boolean statusorg = org.contains(org_msg);
	Assert.assertEquals(statusorg, true);
	System.out.println(org + " Organization is added==Pass");
	soft.assertAll();

}


	
}

