package selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWait {

	public static void main(String[] args) {
		
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\MSUSERSL123\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
        driver.get("https://www.selenium.dev/selenium/web/dynamic.html");
		
	    driver.findElement(By.id("adder")).click();
	    
	    new WebDriverWait(driver,Duration.ofSeconds(5)).ignoring(StaleElementReferenceException.class)
	    .until(ExpectedConditions.visibilityOfElementLocated(By.id("box0")));
	    
	    Boolean added = driver.findElement(By.id("box0")).isDisplayed();
	    
	    System.out.println(added);
	    
	    
	}

}
