package selenium;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class Selenium_4_WebElementDimension {

	public static void main(String[] args) throws IOException {

		WebDriver driver = new ChromeDriver();
		
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		WebElement searchBox = driver.findElement(By.id("search-field"));
		
		searchBox.sendKeys("Mango");
		
//		System.out.println(searchBox.getRect().getDimension().getHeight());
		
		System.out.println(searchBox.getRect().getHeight());
		
//		System.out.println(searchBox.getRect().getDimension().getWidth());
		
		System.out.println(searchBox.getRect().getWidth());

	}

}
