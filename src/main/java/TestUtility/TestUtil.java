package TestUtility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import BasePage.TestBase;
import DriverFactory.DriverFactory;

public class TestUtil {
	
	public String getSecreenShot(String testCaseName ) throws IOException
	{
        TakesScreenshot ts = (TakesScreenshot)DriverFactory.getDriver();
		
		File src = ts.getScreenshotAs(OutputType.FILE);
		
		String destLoc= System.getProperty("user.dir")+"\\ExtentReports\\"+testCaseName+".png";
		
		File dest = new File(destLoc);
		
		FileHandler.copy(src, dest);
		
		return destLoc;
	}
	
	public ExtentReports getExtentReporter(String testName)
	{
		String path = System.getProperty("user.dir")+"\\ExtentReports\\index.html";
		ExtentSparkReporter extentSpark = new ExtentSparkReporter(path);
		
		extentSpark.config().setReportName("Web Automation Results");
		extentSpark.config().setDocumentTitle("Test Results");
		
		ExtentReports extentReport = new ExtentReports();
		extentReport.attachReporter(extentSpark);
		
		extentReport.setSystemInfo("Tester","Poulami");
		
		return extentReport;
	}

}
