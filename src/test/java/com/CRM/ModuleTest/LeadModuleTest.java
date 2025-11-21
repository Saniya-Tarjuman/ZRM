package com.CRM.ModuleTest;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.CRM.BaseClass.BaseClass;
import com.CRM.objectRepositoryUtility.CreateLead;
import com.CRM.objectRepositoryUtility.HomePage;
import com.CRM.objectRepositoryUtility.LeadInfoPage;
import com.CRM.objectRepositoryUtility.LeadPage;
@Listeners(com.CRM.ListenerUtility.ListenerImplementation.class)
public class LeadModuleTest extends BaseClass {
@Test(groups = "Smoke Testing")
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
      boolean status = header_msg.contains(lastname);
	Assert.assertEquals(status, true);
		System.out.println(lastname + " Last name have added and displayed==Pass");
	
	String com_msg = lip.getCom_msg().getText();
	boolean status2 = com_msg.contains(company);
	Assert.assertEquals(status2, true);
		System.out.println(company + " have added and displayed==Pass ");
	

}
}
