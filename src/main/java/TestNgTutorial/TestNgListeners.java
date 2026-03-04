package TestNgTutorial;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import TestUtility.TestUtil;

public class TestNgListeners extends TestUtil implements ITestListener{
	
	public void onStart(ITestContext context)
	{
		System.out.println("Test Tag Start "+context.getName());
	}

	public void onTestStart(ITestResult result)
	{
		System.out.println("Test Start "+result.getName());
		
	}
	
	public void onTestSuccess(ITestResult result)
	{
		System.out.println("Test Success "+result.getName());
	
	}
	
	public void onTestFailure(ITestResult result)
	{
		System.out.println("Test Fail "+result.getName());
		//take screenshot
	}
	
	public void onTestSkipped(ITestResult result)
	{
		System.out.println("Test Skipped "+result.getName());
	}
	
	public void onFinish(ITestContext context)
	{
		System.out.println("Test Tag Finish "+context.getName());
		
		
	}




}
