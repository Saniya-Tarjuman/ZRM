package com.CRM.Orgnaization;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.CRM.BaseClass.BaseClass;
import com.CRM.ListenerUtility.ListenerImplementation;


import com.CRM.objectRepositoryUtility.CreateOrganizationPage;
import com.CRM.objectRepositoryUtility.HomePage;
import com.CRM.objectRepositoryUtility.OrgInfoPage;
import com.CRM.objectRepositoryUtility.Organizaion;
import com.aventstack.extentreports.Status;

public class OrganizationTest extends BaseClass {
	@Test(groups = {"Smoke Testing"})
	  public void createOrgTest() throws EncryptedDocumentException, IOException {
		ListenerImplementation.test.log(Status.INFO, "Read the data from excel");
		
		String org = eutil.getDataFromExcel("OrgName", 1, 1) +jutil.getRandomNum(1000);
		ListenerImplementation.test.log(Status.INFO, "Navigate to the Org page");
	HomePage hp = new HomePage(driver);
		hp.orgCreate();
		ListenerImplementation.test.log(Status.INFO, "Navigate to the create org page");
		CreateOrganizationPage cop = new CreateOrganizationPage(driver);
		cop.createOrg();
		
		ListenerImplementation.test.log(Status.INFO, "create a new org");
		Organizaion orgpage = new Organizaion(driver);
		orgpage.addOrg(org);
		ListenerImplementation.test.log(Status.INFO, org+"create a new org");
		
		OrgInfoPage oip = new OrgInfoPage(driver);
		String msg = oip.headerOrg();
		Assert.assertEquals(true, msg.contains(org));
}
}