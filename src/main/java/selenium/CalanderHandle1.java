package selenium;

import java.time.Month;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CalanderHandle1 {

	public static void main(String[] args) {
		
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\MSUSERSL123\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		String date = "05-05-2028";
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		//input[@id='ctl00_mainContent_txt_Fromdate']
		
		WebElement dateField = driver.findElement(By.xpath("//input[@id='ctl00_mainContent_txt_Fromdate']"));
		
		js.executeScript("arguments[0].setAttribute('value','"+date+"');", dateField);
		
		
		
		
		
		
		
		
		

	}

}
