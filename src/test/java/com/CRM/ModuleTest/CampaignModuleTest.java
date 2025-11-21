package com.CRM.ModuleTest;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;


import com.CRM.BaseClass.BaseClass;
import com.CRM.objectRepositoryUtility.CampaignInfoPage;
import com.CRM.objectRepositoryUtility.CampaignPage;
import com.CRM.objectRepositoryUtility.CreateCampaignPage;
import com.CRM.objectRepositoryUtility.HomePage;



public class CampaignModuleTest extends BaseClass {
@Test(groups = {"Smoke Testing", "Regression Testing"})
public void createCampaignTest() throws IOException {
	int r = jutil.getRandomNum(1000);

	String close = jutil.getRequiredDateyyyyMMdd(5);
	String camp = eutil.getDataFromExcel("Campaign", 1, 1) + r;
	HomePage hp = new HomePage(driver);
	hp.campaignbtn();
	CreateCampaignPage ccp = new CreateCampaignPage(driver);
	ccp.createCampaign();
	CampaignPage cp = new CampaignPage(driver);
	cp.campaignNameDate(camp, close);
	CampaignInfoPage cip = new CampaignInfoPage(driver);
	String header = cip.headerCamp();
	boolean status = header.contains(camp);
	Assert.assertEquals(status, true);

	
	System.out.println(camp + " is created successfully==Pass");
   

}
}
