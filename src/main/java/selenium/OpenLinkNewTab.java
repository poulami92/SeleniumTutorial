package selenium;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class OpenLinkNewTab {

	public static void main(String[] args) {
		
        WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		List<WebElement> footerLinks = driver.findElements(By.xpath("//div[@id='gf-BIG']//td[1]//a"));
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		for(WebElement e : footerLinks)
		{
			js.executeScript("arguments[0].setAttribute('target','_blank');", e);
			
			e.click();
		}
			
		
		
        Set<String> handlers = driver.getWindowHandles();
		
	    for(String window : handlers)
	    {
	    	
	       driver.switchTo().window(window);
	       System.out.println(driver.getTitle());
	    }

	}

}
