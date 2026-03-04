package selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserMaximize {

	public static void main(String[] args) {
		
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\MSUSERSL123\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().deleteAllCookies();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		

	}

}
