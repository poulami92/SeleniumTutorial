package selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class E2EFlightSite {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_0")).click();
		
		driver.findElement(By.xpath("//input[@id='ctl00_mainContent_ddl_originStation1_CTXT']")).click();
		
		driver.findElement(By.xpath("//a[@value='HYD']")).click();
		
		Thread.sleep(1000);
		
		new WebDriverWait(driver, Duration.ofSeconds(2)).until(ExpectedConditions.
				visibilityOfElementLocated(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR']//a[@value='MAA']"))).click();
		
		
		driver.findElement(By.cssSelector(".ui-datepicker-current-day")).click();
		
		WebElement returnDate = driver.findElement(By.cssSelector(".picker-second"));
		
		String styleValue= returnDate.getAttribute("style");
		
//		if(styleValue.contains("1"))
//		{
//			System.out.println("element enabled");
//		}
//		else
//		{
//			System.out.println("element disabled");
//		}
		
		driver.findElement(By.id("divpaxinfo")).click();
		
		new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.
				visibilityOfElementLocated(By.id("hrefIncAdt")));
		
		for(int i =1;i<5;i++)
		{
			driver.findElement(By.id("hrefIncAdt")).click();
			
		}
		
		driver.findElement(By.id("btnclosepaxoption")).click();
		
		
		

	}

}
