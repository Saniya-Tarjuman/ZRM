package com.CRM.ModuleTest;

import java.io.IOException;

import org.testng.annotations.Test;

import com.CRM.BaseClass.BaseClass;
import com.CRM.objectRepositoryUtility.HomePage;
import com.CRM.objectRepositoryUtility.ProductPage;

public class ProductModuleTest extends BaseClass {
@Test(groups = "Smoke Testing")
public void productTest() throws IOException {
	HomePage hp = new HomePage(driver);
	hp.productLink();
	ProductPage pp = new ProductPage(driver);
	pp.allProduct();

	// ExcelUtility eutil = new ExcelUtility();

	// eutil.setDataIntoExcel("Sheet3", 0, 0);
}
}
