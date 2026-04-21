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

public class TestNgAnnotations_1 {
	
	@BeforeSuite
	public void setUp()
	{
		System.out.println("setup chrome properties");
	}
	
	@BeforeTest
	public void login()
	{
		System.out.println("login to app");
	}
	
	@BeforeClass
	public void launchBrowser()
	{
		System.out.println("launch chrome browser");
	}
	
	@BeforeMethod
	public void enterUrl()
	{
		System.out.println("enter url");
	}
	
	@Test(retryAnalyzer=RetryAnalyzer.class)
	public void googleTitleTest()
	{
		System.out.println("Google Title Test");
		Assert.assertTrue(false);
	}
	
	@Test()
	public void googleSearchTest()
	{
		System.out.println("Google Search Test");
	}
	
	@Test()
	public void googleLogoTest()
	{
		System.out.println("Google Logo Test");
	}
	
	@AfterMethod
	public void logOut()
	{
		System.out.println("logout from App");
	}
	
	@AfterClass
	public void closeBrowser()
	{
		System.out.println("Close Browser");
	}
	
	@AfterTest
	public void deleteCookies()
	{
		System.out.println("deleted all cookies");
	}
	
	@AfterSuite
	public void generateReport()
	{
		System.out.println("Report generated");
	}
	
	
	
	

}
