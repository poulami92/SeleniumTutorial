package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.openqa.selenium.support.locators.RelativeLocator.*;

public class Selenium_4_RelativeLocators {

	public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		
		//Above locator
		
        WebElement nameTextBox=driver.findElement(By.id("username"));
		
		String lbleText=driver.findElement(with(By.tagName("label")).above(nameTextBox)).getText();
		
		System.out.println(lbleText);
		
		//Below locator
		
		WebElement labelUserName=driver.findElement(By.xpath("//label[@for='username']"));
		
		WebElement textUserName= driver.findElement(with(By.tagName("input")).below(labelUserName));
		
		textUserName.sendKeys("Poulami");
		
		//Left locator
		
		WebElement labelCheckBox=driver.findElement(By.xpath("//span[contains(text(),'I Agree')]"));
		
		driver.findElement(with(By.tagName("input")).toLeftOf(labelCheckBox)).click();
		
		//Right Locator
		
		WebElement termsCheckBox= driver.findElement(By.id("terms"));
		
		String termsText= driver.findElement(with(By.cssSelector(".termsText.text-white")).toRightOf(termsCheckBox)).getText();
		
		System.out.println(termsText);

	}

}
