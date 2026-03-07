package TestUtility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import DriverFactory.WebDriverManager;
import PageObjects.PageObjectFactory;

public class TestContext {
	
	//public WebDriver driver;
	public String LandingPagePdtName;
	public PageObjectFactory pageObjectFactory;
	public TestUtil testUtil;
	public ConfigReader configReader;
	
	public TestContext() throws IOException
	{
		pageObjectFactory = new PageObjectFactory();
		testUtil = new TestUtil();
		configReader = new ConfigReader();
	}
	
	public PageObjectFactory getPageObjectFactory() {
        return pageObjectFactory;
    }
	
	public ConfigReader getConfigReader() {
        return configReader;
    }
	
}
