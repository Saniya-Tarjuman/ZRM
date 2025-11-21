package com.CRM.Contact;

import java.io.IOException;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;

import org.testng.annotations.Test;

import com.CRM.BaseClass.BaseClass;

import com.CRM.objectRepositoryUtility.ContactInfoPage;
import com.CRM.objectRepositoryUtility.ContactPage;
import com.CRM.objectRepositoryUtility.CreateContact;
import com.CRM.objectRepositoryUtility.CreateOrganizationPage;
import com.CRM.objectRepositoryUtility.HomePage;
import com.CRM.objectRepositoryUtility.OrgInfoPage;
import com.CRM.objectRepositoryUtility.Organizaion;

public class ContactWithOrgTest extends BaseClass {
	@Test
	public void contactTest() throws IOException {
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
		if (header.contains(org)) {
			System.out.println("Organization is created");
		} else {
			System.out.println("Organization is not created");
		}

		hp.createContact();
		CreateContact cc = new CreateContact(driver);
		cc.createConatct();
		ContactPage cp = new ContactPage(driver);
		cp.supportDateInContact(lstname, start, end);
		ContactInfoPage cip = new ContactInfoPage(driver);
		String msg_lstname = cip.contactHeaderMsg();
		if (msg_lstname.contains(lstname)) {
			System.out.println(lstname + " is added in the contact==Pass");
		} else {
			System.out.println(lstname + " is not added in the contact==Fail");
		}

		ContactInfoPage c = new ContactInfoPage(driver);
		String start_header = c.startMsg();
		if (start.contains(start_header)) {
			System.out.println(start + "Support Start date is added==Pass");
		} else {
			System.out.println(start + "Support Start date is not added==Fail");
		}
		String end_header = c.endMsg();
		if (end.contains(end_header)) {
			System.out.println(end + "Support end date is added==Pass");
		} else {
			System.out.println(end + "Support end date is not added==Fail");
		}

		WebElement msg = driver.findElement(By.xpath("//a[text()='" + org + "']"));
		String org_msg = msg.getText();
		if (org.contains(org_msg)) {
			System.out.println(org + " Organization is added==Pass");
		} else {
			System.out.println(org + "Organization is not added==Fail");
		}

	}
}