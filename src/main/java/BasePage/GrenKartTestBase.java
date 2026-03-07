package BasePage;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import DriverFactory.DriverFactory;
import DriverFactory.WebDriverManager;

public class GrenKartTestBase {
	
	public WebDriver driver;
	
	public GrenKartTestBase()
	{
		driver= WebDriverManager.getDriver();
	}
	
	public WebElement findElement(By by)
	{
		return new WebDriverWait(driver,Duration.ofSeconds(5)).
        until(ExpectedConditions.visibilityOfElementLocated(by));
	}
	
	public void waitTillElementInvisible(By by)
	{
		new WebDriverWait(driver,Duration.ofSeconds(5)).
        until(ExpectedConditions.invisibilityOfElementLocated(by));
	}
	
	public void clickElementByJs(WebElement element)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();",element);
	}
	
	public List<WebElement> findElements(By by)
	{
		return new WebDriverWait(driver,Duration.ofSeconds(5)).
        until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
	}
	
	public void switchToWindow()
	{
        Set<String> windowHandles=driver.getWindowHandles();
		
		String parentHandle= driver.getWindowHandle();
		
		for(String handle : windowHandles)
		{
			if(!handle.equals(parentHandle))
			{
				driver.switchTo().window(handle);
			}
		}
	}
	
	

}
