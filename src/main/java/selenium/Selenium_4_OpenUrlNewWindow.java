package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium_4_OpenUrlNewWindow {

	public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		
		String parenWindow= driver.getWindowHandle();
		
		//driver.switchTo().newWindow(WindowType.TAB);
		
		driver.switchTo().newWindow(WindowType.WINDOW);
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		driver.findElement(By.id("search-field")).sendKeys("Mango");
		
		Thread.sleep(2000);
		
		driver.close();
		
		driver.switchTo().window(parenWindow);
		
		driver.findElement(By.id("username")).sendKeys("poulami");
		
		

	}

}
