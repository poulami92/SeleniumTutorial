package selenium;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HeadLessBrowser {

	public static void main(String[] args) throws InterruptedException {
		
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\MSUSERSL123\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		
        ChromeOptions options = new ChromeOptions();
        
        options.addArguments("window-sizw=1400,800");
        
        options.addArguments("--headless");

        WebDriver driver = new ChromeDriver(options);
        
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		driver.findElement(By.id("alertbtn")).click();
		
		Alert alert1 = driver.switchTo().alert();
		
		System.out.println(alert1.getText());
		
		alert1.accept();
		
		Thread.sleep(3000);
		
		driver.findElement(By.id("confirmbtn")).click();
		
        Alert alert2 = driver.switchTo().alert();
		
		System.out.println(alert2.getText());
		
		alert2.dismiss();

	}

}
