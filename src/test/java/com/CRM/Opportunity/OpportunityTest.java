package com.CRM.Opportunity;

import java.io.IOException;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;

import org.testng.annotations.Test;

import com.CRM.BaseClass.BaseClass;

import com.CRM.objectRepositoryUtility.CreateOpportunity;
import com.CRM.objectRepositoryUtility.CreateOrganizationPage;
import com.CRM.objectRepositoryUtility.HomePage;
import com.CRM.objectRepositoryUtility.OpportuInfoPage;
import com.CRM.objectRepositoryUtility.OpportunityPage;
import com.CRM.objectRepositoryUtility.OrgInfoPage;
import com.CRM.objectRepositoryUtility.Organizaion;

public class OpportunityTest extends BaseClass {
	@Test
	public void opportunityTest() throws IOException {

		String org = eutil.getDataFromExcel("Opportunity", 1, 2) + jutil.getRandomNum(1000);
		String name = eutil.getDataFromExcel("Opportunity", 1, 1) + jutil.getRandomNum(1000);
		HomePage hp = new HomePage(driver);
		hp.orgCreate();
		CreateOrganizationPage cop = new CreateOrganizationPage(driver);
		cop.createOrg();
		Organizaion orgpage = new Organizaion(driver);
		orgpage.addOrg(org);
		OrgInfoPage oip = new OrgInfoPage(driver);
		String msg_org = oip.headerOrg();
		if (msg_org.contains(org)) {
			System.out.println(org + " is created successfully");
		} else {
			System.out.println("Fails to create the Organization");
		}

		hp.createOpportunity();
		CreateOpportunity co = new CreateOpportunity(driver);
		co.createOppor();
		OpportunityPage op = new OpportunityPage(driver);
		op.addOpp(name, org);
		OpportuInfoPage oi = new OpportuInfoPage(driver);
		String header_opp = oi.oppHeader();
		if (header_opp.contains(name)) {
			System.out.println(name + " Last Name is added to the opportunity==Pass");
		} else {
			System.out.println(name + " Last Name is not added to the opportunity==Fail");
		}
		WebElement msgorg = driver.findElement(By.xpath("//a[text()='" + org + "']"));
		String org_header = msgorg.getText();
		if (org.contains(org_header)) {
			System.out.println(org + " Organization is added to the opportunity==Pass");
		} else {
			System.out.println(org + " Organization is not added to the opportunity==Fail");
		}

	}
}