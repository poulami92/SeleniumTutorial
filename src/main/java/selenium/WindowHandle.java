package selenium;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandle {

	public static void main(String[] args) {
		
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\MSUSERSL123\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		String parentHandle = driver.getWindowHandle();
		
		//driver.findElement(By.id("opentab")).click();
		
		driver.findElement(By.id("openwindow")).click();
		
		Set<String> handlers = driver.getWindowHandles();
		
	    for(String window : handlers)
	    {
	    	if(!window.equals(parentHandle))
	    	{
	    		driver.switchTo().window(window);
	    		driver.findElement(By.linkText("Access all our Courses")).click();
	    		driver.close();
	    		break;
	    	}
	    }
	    
	    driver.switchTo().window(parentHandle);
	    driver.findElement(By.xpath("//input[@value='radio1']")).click();
	    
	    

	}

}
