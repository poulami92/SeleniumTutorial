package selenium;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DynamicDropDown {

	public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\MSUSERSL123\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		driver.findElement(By.id("autocomplete")).sendKeys("ind");
		
		List<WebElement> list= new WebDriverWait(driver,Duration.ofSeconds(5))
				.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//li[@class='ui-menu-item']//div")));	
		
		for(WebElement el : list)
		{
			if(el.getText().contains("Indian"))
			{
				el.click();
				break;
			}
		}
		
		
		//li//div[text()='India']
		
		
		
		
		
	}
}
