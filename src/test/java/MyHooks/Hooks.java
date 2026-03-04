package MyHooks;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import BasePage.TestBase;
import Factory.DriverFactory;
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
	private DriverFactory driverFactory;
	private WebDriver driver;
	public LoginPage loginPage;
	
	@BeforeAll
	public static void setUpProperties() throws IOException
	{
		prop = new Properties();
		FileInputStream fs = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\Config\\config.properties");
		prop.load(fs);
	}
	
	@Before()
	public void setupBrowser(Scenario sc)
	{
		System.out.println("Launching Browser "+sc.getName());
		
        String browserName = System.getProperty("browser")!=null? System.getProperty("browser"):prop.getProperty("browser");
		
		String headless = System.getProperty("headless")!=null? System.getProperty("headless"):"false";
		
		driverFactory = new DriverFactory();
		
		driver=driverFactory.setDriver(browserName, headless);
		
		driver.get(prop.getProperty("url"));
		
	}
	
//	@Before(order=2)
//	public void setupUrl(Scenario sc)
//	{
//		System.out.println("Launching Url "+sc.getName());
//	}
	
//	@After(order=2)
//	public void tearDownLogOut(Scenario sc)
//	{
//		System.out.println("Logged out application "+sc.getName());
//	}
	
	@After()
	public void tearDownBrowser(Scenario sc) throws IOException
	{
		System.out.println("closing browser "+sc.getName());
		String scenarioName= sc.getName().replace(" ", "_");
		if(sc.isFailed())
		{
			byte screenshot[]= ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			sc.attach(screenshot, "image/png", scenarioName);
		}
		driver.quit();
	}
	
//	@BeforeStep()
//	public void setupBeforeStep(Scenario sc)
//	{
//		System.out.println("BeforeStep "+sc.getName());
//	}
//	
//	@AfterStep()
//	public void setupAfterStep(Scenario sc)
//	{
//		System.out.println("AfterStep "+sc.getName());
//	}
	
	

}
