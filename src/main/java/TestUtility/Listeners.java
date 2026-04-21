package TestUtility;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import TestUtility.TestUtil;

public class Listeners extends TestUtil implements ITestListener{
	
	ExtentReports extentReport;
	ExtentTest test;
	
	public void onStart(ITestContext context)
	{
		extentReport = getExtentReporter();
		//System.out.println("Test Tag Start "+context.getName());
	}

	public void onTestStart(ITestResult result)
	{
		System.out.println("Test Start "+result.getName());
		
		test= extentReport.createTest(result.getName());
	}
	
	public void onTestSuccess(ITestResult result)
	{
		System.out.println("Test Success "+result.getName());
		test.log(Status.PASS, "Test Passed");
	}
	
	public void onTestFailure(ITestResult result)
	{
		String filePath="";
		System.out.println("Test Fail "+result.getName());
		//test.log(Status.FAIL, "Test Failed");
		test.fail(result.getThrowable());
		try {
			filePath = getSecreenShot(result.getName());
		} catch (IOException e) {
			e.printStackTrace();
		}
		test.addScreenCaptureFromPath(filePath,result.getName());
	}
	
	public void onTestSkipped(ITestResult result)
	{
		System.out.println("Test Skipped "+result.getName());
		test.log(Status.SKIP, "Test Skipped");
	}
	
	public void onFinish(ITestContext context)
	{
		//System.out.println("Test Tag Finish "+context.getName());
		
		extentReport.flush();
	}




}
