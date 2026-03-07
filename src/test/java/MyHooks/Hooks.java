package MyHooks;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import BasePage.TestBase;
import DriverFactory.DriverFactory;
import PageObjects.LoginPage;
import TestUtility.TestUtil;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;

public class Hooks {
	
	public static Properties prop;
	public LoginPage loginPage;
	
	@BeforeAll()
	public static void setUpProperties() throws IOException
	{
		System.out.println("Setting up properties file");
		prop = new Properties();
		FileInputStream fs = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\Config\\config.properties");
		prop.load(fs);
	}
	
	@Before("@OrderSubmit")
	public void setupBrowser(Scenario sc)
	{
		System.out.println("Launching Browser "+sc.getName());
		
        String browserName = System.getProperty("browser")!=null? System.getProperty("browser"):prop.getProperty("browser");
		
		String headless = System.getProperty("headless")!=null? System.getProperty("headless"):"false";
		
		DriverFactory.setDriver(browserName, headless);
		
		DriverFactory.getDriver().get(prop.getProperty("url"));
		
	}
	
	@After("@OrderSubmit")
	public void tearDownBrowser(Scenario sc) throws IOException
	{
		System.out.println("closing browser "+sc.getName());
		String scenarioName= sc.getName().replace(" ", "_");
		if(sc.isFailed())
		{
			byte screenshot[]= ((TakesScreenshot)DriverFactory.getDriver()).getScreenshotAs(OutputType.BYTES);
			sc.attach(screenshot, "image/png", scenarioName);
		}
		DriverFactory.quitDriver();
	}
	

	
	

}
