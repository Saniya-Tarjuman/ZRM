package demo;

import org.testng.annotations.Test;

import com.CRM.generic.WebDriverUtility.JavaUtility;

public class DemoTest {
	@Test
	public void checkUtility()
	{
		JavaUtility jlib= new JavaUtility();
	String sdate = jlib.getSystemDate();
	System.out.println(sdate);
	System.out.println(jlib.getRequiredDateyyyyMMdd(20));
	}

}
