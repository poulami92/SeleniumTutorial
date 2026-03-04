package E2EFrameworkTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import Factory.DriverFactory;
import PageObjects.LoginPage;

public class BaseSetupTest {
	
	public WebDriver driver;
	public static Properties prop;
	public LoginPage loginPage;
	
	private static ThreadLocal<WebDriver> th = new ThreadLocal<>();

	
	public BaseSetupTest() throws IOException
	{
		prop = new Properties();
		FileInputStream fs = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\Config\\config.properties");
		prop.load(fs);
	}
	
	@BeforeMethod
	public void setUpMethod()
	{	
		LaunchApplication();               
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
        th.remove();
	}
	
	public void LaunchApplication()
	{
		initializeDriver();
		driver.get(prop.getProperty("url"));
		loginPage = new LoginPage(driver);
		
	}
	
	
	
	public WebDriver initializeDriver()
	{
		String browserName = System.getProperty("browser")!=null? System.getProperty("browser"):prop.getProperty("browser");
		
		String headless = System.getProperty("headless")!=null? System.getProperty("headless"):"false";
		
		DriverFactory driverFactory = new DriverFactory();
		
		driver=driverFactory.setDriver(browserName, headless);
		
		return driver;
	}

}
