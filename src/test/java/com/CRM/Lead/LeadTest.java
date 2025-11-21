package com.CRM.Lead;

import java.io.IOException;

import org.testng.annotations.Test;

import com.CRM.BaseClass.BaseClass;

import com.CRM.objectRepositoryUtility.CreateLead;
import com.CRM.objectRepositoryUtility.HomePage;
import com.CRM.objectRepositoryUtility.LeadInfoPage;
import com.CRM.objectRepositoryUtility.LeadPage;

public class LeadTest extends BaseClass {
	@Test
	public void createLeadTest() throws IOException {

		int r = jutil.getRandomNum(100);

		String lastname = eutil.getDataFromExcel("Lead", 1, 1) + r;
		String company = eutil.getDataFromExcel("Lead", 1, 2) + r;
		HomePage hp = new HomePage(driver);
		hp.createLead();
		CreateLead cl = new CreateLead(driver);
		cl.clickLead();
		LeadPage lp = new LeadPage(driver);
		lp.addNameCompany(lastname, company);
		LeadInfoPage lip = new LeadInfoPage(driver);
		String header_msg = lip.getHeader().getText();

		if (header_msg.contains(lastname)) {
			System.out.println(lastname + " Last name have added and displayed==Pass");
		} else {
			System.out.println(lastname + " Last name is not displayed==Fail");
		}
		String com_msg = lip.getCom_msg().getText();
		if (com_msg.contains(company)) {
			System.out.println(company + " have added and displayed==Pass ");
		} else {
			System.out.println(company + " is not displayed==Fail");
		}

	}
}
