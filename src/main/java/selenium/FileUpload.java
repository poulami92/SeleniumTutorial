package selenium;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUpload {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\MSUSERSL123\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/upload");
		
		driver.findElement(By.id("file-upload")).sendKeys("C:\\Users\\MSUSERSL123\\eclipse-workspace\\SeleniumTutorial\\src\\main\\java\\selenium\\Screenshot 2024-02-21 135401.png");
		
		driver.findElement(By.id("file-submit")).click();

	}

}
