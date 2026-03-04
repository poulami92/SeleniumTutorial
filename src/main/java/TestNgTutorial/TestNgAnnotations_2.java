package TestNgTutorial;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNgAnnotations_2 {
	
	
	
	@Test(priority=1,groups="Title")
	public void googleTitleTest()
	{
		Assert.assertTrue(false);
		System.out.println("Google Title Test");
	}
	
	@Test(priority=2,groups="Search")
	public void googleSearchTest() 
	{
		System.out.println("Google Search Test");
	}
	
	
	@Test(groups="Title",dependsOnMethods="googleTitleTest")
	public void googleLogoTest()
	{
		System.out.println("Google Search Test");
	}
	
	@Test(invocationCount=5)
	public void invocationCountTest()
	{
		System.out.println("5 times execute");
	}
	
	@Test(timeOut=2000)
	public void timeOutTest() throws InterruptedException
	{
		Thread.sleep(5000);
		System.out.println("Timeout test");
	}
	
	@Test(expectedExceptions=NumberFormatException.class)
	public void expectedExceptionTest()
	{
		String str= "10A";
		int i =Integer.parseInt(str);
		System.out.println("Number Format wrong");
	}
	
	@Test(enabled=false)
	public void skipTest()
	{
		System.out.println("skipped test");
	}
	
	
	
	
	
	

}
