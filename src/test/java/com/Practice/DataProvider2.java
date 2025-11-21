package com.Practice;

import org.testng.annotations.Test;

public class DataProvider2 extends DataProvid1 {
@Test(dataProvider = "getData")
public void m1(String f, String s) {
	System.out.println("First:"+f+"Second"+s);
}
@Test
public void m2() {
	System.out.println("nothing");
}
}
