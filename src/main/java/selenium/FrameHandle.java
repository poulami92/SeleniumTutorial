package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FrameHandle {

	public static void main(String[] args) {
		
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\MSUSERSL123\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		driver.switchTo().frame("iframe-name");
		
		driver.findElement(By.linkText("Courses")).click();
		
		driver.switchTo().defaultContent();
		
		driver.findElement(By.xpath("//input[@value='radio1']")).click();

	}

}
