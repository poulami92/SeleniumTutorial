package TestNgTutorial;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class Selenium_Grid {
	
	WebDriver driver;
	
	@BeforeClass
	@Parameters({"browserName"})
	public void setUpBrowser(String browser) throws MalformedURLException, URISyntaxException
	{
		  String hubAddress = "http://192.168.1.10:4444";
		  
		  URL hubUrl= new URI(hubAddress).toURL();
		  
		  DesiredCapabilities cap = new DesiredCapabilities();
		  
		  cap.setBrowserName(browser);
		  cap.setPlatform(Platform.WINDOWS);
			
		  driver = new RemoteWebDriver(hubUrl,cap);
	}
	
	
	@Test
	public void gridTest()
	
	{  
	
	  driver.get("https://rahulshettyacademy.com/");
	
	  System.out.println(driver.getTitle());
	
	  System.out.println(driver.getCurrentUrl());
	
	  
	
 }
	
	@AfterClass
	public void TearDown()
	{
		driver.quit();
	}

}
