package com.CRM.ModuleTest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.CRM.BaseClass.BaseClass;

import com.CRM.generic.WebDriverUtility.UtilityClassObject;
import com.CRM.objectRepositoryUtility.CreateOrganizationPage;
import com.CRM.objectRepositoryUtility.HomePage;
import com.CRM.objectRepositoryUtility.OrgInfoPage;
import com.CRM.objectRepositoryUtility.Organizaion;
import com.aventstack.extentreports.Status;

public class OrganizationModuleTest extends BaseClass {
@Test(groups = {"Smoke Testing"})
  public void createOrgTest() throws EncryptedDocumentException, IOException {
	UtilityClassObject.getTest().log(Status.INFO, "Read the data from excel");
	
	String org = eutil.getDataFromExcel("OrgName", 1, 1) +jutil.getRandomNum(1000);
	UtilityClassObject.getTest().log(Status.INFO, "Navigate to the Org page");
HomePage hp = new HomePage(driver);
	hp.orgCreate();
	UtilityClassObject.getTest().log(Status.INFO, "Navigate to the create org page");
	CreateOrganizationPage cop = new CreateOrganizationPage(driver);
	cop.createOrg();
	
	UtilityClassObject.getTest().log(Status.INFO, "create a new org");
	Organizaion orgpage = new Organizaion(driver);
	orgpage.addOrg(org);
	UtilityClassObject.getTest().log(Status.INFO, org+"create a new org");
	
	OrgInfoPage oip = new OrgInfoPage(driver);
	String msg = oip.headerOrg();
	Assert.assertEquals(true, msg.contains(org));
	
		
	
		
	
}
//create organization with industry and type
	@Test(groups = {"Regression Testing"})
	public void createIndTypeTest() throws EncryptedDocumentException, IOException {
		int r = jutil.getRandomNum(1000);

		String org = eutil.getDataFromExcel("OrgName", 1, 1) + r;
		String induss = eutil.getDataFromExcel("OrgName", 1, 2);
		String typee = eutil.getDataFromExcel("OrgName", 1, 3);
		HomePage hp = new HomePage(driver);
		hp.orgCreate();
		CreateOrganizationPage cop = new CreateOrganizationPage(driver);
		cop.createOrg();
		Organizaion orgpage = new Organizaion(driver);
		orgpage.addOrgIndTyp(org, induss, typee);
		OrgInfoPage oip = new OrgInfoPage(driver);
		String msg_org = oip.headerOrg();
		String msg_ind = oip.industOrg();
		String msg_typ = oip.typeOrg();
		boolean status = msg_org.contains(org);
		Assert.assertEquals(status, true);
			System.out.println(org + " is created successfully==Pass");
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(msg_ind, induss);
			System.out.println(induss + " is selected successfully==Pass");
		soft.assertEquals(msg_typ, typee);
			System.out.println(typee + " is selected successfully==Pass");
			soft.assertAll();
	}
	@Test(groups = {"Regression Testing"})
	public void createOrgPhoneTest() throws EncryptedDocumentException, IOException {
		int r = jutil.getRandomNum(1000);

		String org = eutil.getDataFromExcel("OrgName", 1, 1) + r;
		String induss = eutil.getDataFromExcel("OrgName", 1, 2);
		String typee = eutil.getDataFromExcel("OrgName", 1, 3);
		String phone = eutil.getDataFromExcel("OrgName", 1, 4);
		HomePage hp = new HomePage(driver);
		hp.orgCreate();
		CreateOrganizationPage cop = new CreateOrganizationPage(driver);
		cop.createOrg();
		Organizaion orgpage = new Organizaion(driver);

		orgpage.addPhone(org, induss, typee, phone);
		OrgInfoPage oip = new OrgInfoPage(driver);
		String msg_org = oip.headerOrg();
		String msg_ind = oip.industOrg();
		String msg_typ = oip.typeOrg();
		String msg_phone = oip.phoneOrg().trim();
		boolean status = msg_org.contains(org);
		Assert.assertEquals(status, true);
		System.out.println(org + " is created successfully==Pass");
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(msg_ind, induss);
    	System.out.println(induss + " is selected successfully==Pass");
    soft.assertEquals(msg_typ, typee);
	System.out.println(typee + " is selected successfully==Pass");
	soft.assertEquals(msg_phone, phone);
		System.out.println(phone + " is added successfully==Pass");
       soft.assertAll();	

	}

}
