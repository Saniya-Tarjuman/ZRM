package com.CRM.Contact;

import java.io.IOException;

import org.testng.annotations.Test;

import com.CRM.BaseClass.BaseClass;

import com.CRM.objectRepositoryUtility.ContactInfoPage;
import com.CRM.objectRepositoryUtility.ContactPage;
import com.CRM.objectRepositoryUtility.CreateContact;
import com.CRM.objectRepositoryUtility.HomePage;

public class ContactSupportDateTest extends BaseClass {
	@Test
	public void createContactSupportDateTest() throws IOException {

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
		if (msg_lstname.contains(lstname)) {
			System.out.println(lstname + " is added in the contact==Pass");
		} else {
			System.out.println(lstname + " is not added in the contact==Fail");
		}

		ContactInfoPage c = new ContactInfoPage(driver);
		String start_header = c.startMsg();
		if (start_header.contains(start)) {
			System.out.println(start + "Support Start date is added==Pass");
		} else {
			System.out.println(start + "Support Start date is not added==Fail");
		}
		String end_header = c.endMsg();
		if (end_header.contains(end)) {
			System.out.println(end + "Support end date is added==Pass");
		} else {
			System.out.println(end + "Support end date is not added==Fail");
		}

	}
}
