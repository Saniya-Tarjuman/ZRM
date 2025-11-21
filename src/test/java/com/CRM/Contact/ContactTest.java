package com.CRM.Contact;

import java.io.IOException;

import org.testng.annotations.Test;

import com.CRM.BaseClass.BaseClass;

import com.CRM.objectRepositoryUtility.ContactInfoPage;
import com.CRM.objectRepositoryUtility.ContactPage;
import com.CRM.objectRepositoryUtility.CreateContact;
import com.CRM.objectRepositoryUtility.HomePage;

public class ContactTest extends BaseClass {
	@Test
	public void createContactTest() throws IOException {
//random number        	   
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
		if (msg.contains(lstname)) {
			System.out.println(lstname + " last name is added==Pass");
		} else {
			System.out.println(lstname + " Failed to add the last name==Fail");
		}

	}

}
