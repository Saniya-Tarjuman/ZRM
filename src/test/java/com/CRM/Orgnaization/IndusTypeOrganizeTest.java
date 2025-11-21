package com.CRM.Orgnaization;

import java.io.IOException;

import org.testng.annotations.Test;

import com.CRM.BaseClass.BaseClass;

import com.CRM.objectRepositoryUtility.CreateOrganizationPage;
import com.CRM.objectRepositoryUtility.HomePage;
import com.CRM.objectRepositoryUtility.OrgInfoPage;
import com.CRM.objectRepositoryUtility.Organizaion;

public class IndusTypeOrganizeTest extends BaseClass {
	@Test
	public void createIndTypInOrgTest() throws IOException {

		String org = eutil.getDataFromExcel("OrgName", 1, 1) + jutil.getRandomNum(100);
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
		if (msg_org.contains(org)) {
			System.out.println(org + " is created successfully==Pass");
		} else {
			System.out.println("Organization is not created==Fail");
		}
		if (msg_ind.contains(induss)) {
			System.out.println(induss + " is selected successfully==Pass");
		} else {
			System.out.println("Industry is not selected==Fail");
		}
		if (msg_typ.contains(typee)) {
			System.out.println(typee + " is selected successfully==Pass");
		} else {
			System.out.println("Type is not selected==Fail");
		}

	}
}
