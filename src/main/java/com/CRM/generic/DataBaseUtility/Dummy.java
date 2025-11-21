package com.CRM.generic.DataBaseUtility;

import org.testng.annotations.Test;

import com.CRM.BaseClass.BaseClass;

public class Dummy extends BaseClass {
@Test
public void simpleTest() {
	System.out.println("Execute one test case");
}
@Test(dependsOnMethods = "simpleTest")
public void sampleTest() {
	System.out.println("Execute second test case");
}
}
