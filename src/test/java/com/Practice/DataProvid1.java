package com.Practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvid1 {
@Test(dataProvider = "getData")
public void createContact(String FN, String LN) {
	System.out.println("FirstName:"+FN+", LastName:"+LN);
	
}
@DataProvider
public Object[][] getData() {
	Object[][] objarr = new Object[3][2];
	objarr[0][0] = "deepak";
	objarr[0][1] = "hr";
	objarr[1][0] = "1";
	objarr[1][1] = "a";
	objarr[2][0] = "2";
	objarr[2][1] = "b";
	return objarr;
}
}
