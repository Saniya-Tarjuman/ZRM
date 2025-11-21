package com.CRM.ModuleTest;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.CRM.BaseClass.BaseClass;
import com.CRM.objectRepositoryUtility.CreateOpportunity;
import com.CRM.objectRepositoryUtility.CreateOrganizationPage;
import com.CRM.objectRepositoryUtility.HomePage;
import com.CRM.objectRepositoryUtility.OpportuInfoPage;
import com.CRM.objectRepositoryUtility.OpportunityPage;
import com.CRM.objectRepositoryUtility.OrgInfoPage;
import com.CRM.objectRepositoryUtility.Organizaion;

public class OpportinityModuleTest extends BaseClass{
@Test(groups = {"Smoke Testing", "Regression Testing"})
public void opportunityTest() throws IOException {

	int r = jutil.getRandomNum(1000);

	String org = eutil.getDataFromExcel("Opportunity", 1, 2) + r;
	String name = eutil.getDataFromExcel("Opportunity", 1, 1) + r;
	HomePage hp = new HomePage(driver);
	hp.orgCreate();
	CreateOrganizationPage cop = new CreateOrganizationPage(driver);
	cop.createOrg();
	Organizaion orgpage = new Organizaion(driver);
	orgpage.addOrg(org);
	OrgInfoPage oip = new OrgInfoPage(driver);
	String msg_org = oip.headerOrg();
	boolean statusorg = msg_org.contains(org);
	Assert.assertEquals(statusorg, true);
		System.out.println(org + " is created successfully");
	

	hp.createOpportunity();
	CreateOpportunity co = new CreateOpportunity(driver);
	co.createOppor();
	OpportunityPage op = new OpportunityPage(driver);
	op.addOpp(name, org);
	OpportuInfoPage oi = new OpportuInfoPage(driver);
	String header_opp = oi.oppHeader();
	boolean status1 = header_opp.contains(name);
	Assert.assertEquals(status1, true);
		System.out.println(name + " Last Name is added to the opportunity==Pass");
	
	WebElement msgorg = driver.findElement(By.xpath("//a[text()='" + org + "']"));
	String org_header = msgorg.getText();
	boolean status2 = org.contains(org_header);
   Assert.assertEquals(status2, true);
		System.out.println(org + " Organization is added to the opportunity==Pass");
	

}
}
