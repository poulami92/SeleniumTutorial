package MyHooks;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import DriverFactory.WebDriverManager;
import TestUtility.TestContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;

public class GreenKartHooks {
	
	TestContext testContext;
	
	public GreenKartHooks(TestContext testContext)
	{
		this.testContext=testContext;
	}
	
	@Before("@GreenKart")
	public void setUp() throws IOException
	{
		String url=testContext.getConfigReader().getUrl();
	
		String browser = System.getProperty("browser")!=null? System.getProperty("browser"):testContext.getConfigReader().getBrowser();
		String headless = System.getProperty("headless")!=null? System.getProperty("headless"):"false";
		WebDriverManager.setDriver(browser, headless);
		WebDriverManager.getDriver().get(url);
	}
	
	@After("@GreenKart")
	public void afterScenario(Scenario sc)
	{
		
		String scenarioName= sc.getName().replace(" ", "_");
		if(sc.isFailed())
		{
			byte screenshot[]= ((TakesScreenshot)WebDriverManager.getDriver()).getScreenshotAs(OutputType.BYTES);
			sc.attach(screenshot, "image/png", scenarioName);
		}
		
		WebDriverManager.quitDriver();
		
		
	}

}
