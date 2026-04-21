package TestNgTutorial;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReport {
	
	ExtentReports extentReport;
	WebDriver driver;
	
	@BeforeTest
	public void config()
	{
		String path = System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter extentSpark = new ExtentSparkReporter(path);
		
		extentSpark.config().setReportName("Web Automation Results");
		extentSpark.config().setDocumentTitle("Test Results");
		
		extentReport = new ExtentReports();
		extentReport.attachReporter(extentSpark);
		
		extentReport.setSystemInfo("Tester","Poulami");
		
	}
	
	@Test
    public void extentReportGeneration()
    {
	  ExtentTest test= extentReport.createTest("extentReportGeneration");
	  
	  driver = new ChromeDriver();
	
	  driver.get("https://rahulshettyacademy.com");
	  
	  String actualTitle = driver.getTitle();
	  
	  String expectedTitle="Rahul Shetty Academy";
	  
	  //test.fail("Tc failed");
	  
	  //Assert.assertEquals(actualTitle, expectedTitle);
	 
    }
	
	
	@AfterTest
	public void tearDown()
	{
		 driver.close();
		 extentReport.flush();
	}

}
