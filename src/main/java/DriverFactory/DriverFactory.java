package DriverFactory;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import lombok.Synchronized;

public class DriverFactory {
	
	private static ThreadLocal<WebDriver> th = new ThreadLocal<>();
	private WebDriver driver;
	private ChromeOptions options;
	
	public static WebDriver setDriver(String browserName,String headless)
	{
		WebDriver driver = null;
		
		if(browserName.equals("chrome"))
		{
			ChromeOptions options=null;;
			
	        if(headless.equals("true")) 
	        {
	        	 
	        	options = new ChromeOptions();
	             
	        	options.addArguments("--headless");
	        	
	            options.addArguments("window-sizw=1400,800");
	            
	            driver=new ChromeDriver(options);
	                        
	        }
	        
	        else
	        {
			  driver=new ChromeDriver();
	        }
		}
		
		else if(browserName.equals("Firefox"))
		{
			driver=new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		th.set(driver);
		return getDriver();
	}
	
	public static synchronized WebDriver getDriver()
	{
		return th.get();
	}
	
	public static void quitDriver() {
		getDriver().quit();
		th.remove();
    }

}
