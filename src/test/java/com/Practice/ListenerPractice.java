package com.Practice;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.CRM.BaseClass.BaseClass;

public class ListenerPractice extends BaseClass {
@Test(retryAnalyzer = com.CRM.ListenerUtility.RetryListenerImp.class)
public void createInvoiceTest() {
	System.out.println("Execute createinvoicetest");
	String actTitle = driver.getTitle();
	Assert.assertEquals(actTitle, "Login");
	System.out.println("Step-1");
	System.out.println("Step-2");
	System.out.println("Step-3");
	
}
/*@Test
public void createInvoiceWithContactTest() {
	System.out.println("Execute createInvoiceWithContactTest");
	System.out.println("Step-1");
	System.out.println("Step-2");
	System.out.println("Step-3");
	System.out.println("Step-4");
}*/
}
