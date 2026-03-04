package BasePage;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestBase {
	
	public static WebDriver driver;
	
	public TestBase(WebDriver driver)
	{
		this.driver= driver;
	}
	
	public static WebElement findElement(By by)
	{
		return new WebDriverWait(driver,Duration.ofSeconds(5)).
        until(ExpectedConditions.visibilityOfElementLocated(by));
	}
	
	public static void waitTillElementInvisible(By by)
	{
		new WebDriverWait(driver,Duration.ofSeconds(5)).
        until(ExpectedConditions.invisibilityOfElementLocated(by));
	}
	
	public void clickElementByJs(WebElement element)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();",element);
	}
	
	public static List<WebElement> findElements(By by)
	{
		return new WebDriverWait(driver,Duration.ofSeconds(5)).
        until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
	}
	
	

}
