package selenium;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class Selenium_4_WebElementScreenshot {

	public static void main(String[] args) throws IOException {

		WebDriver driver = new ChromeDriver();
		
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		WebElement searchBox = driver.findElement(By.id("search-field"));
		
		searchBox.sendKeys("Mango");
		
		File src= searchBox.getScreenshotAs(OutputType.FILE);
		
        File dest = new File("C:\\Users\\MSUSERSL123\\eclipse-workspace\\SeleniumTutorial\\src\\main\\java\\selenium\\elementImage.png");
		
		FileHandler.copy(src, dest);

	}

}
