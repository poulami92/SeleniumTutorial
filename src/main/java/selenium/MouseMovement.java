package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseMovement {

	public static void main(String[] args) {
		
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\MSUSERSL123\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		Actions action = new Actions(driver);
		
		//Mouse Hover
		
		WebElement mouseHover = driver.findElement(By.id("mousehover"));
		
		action.moveToElement(mouseHover).build().perform();
		
		driver.findElement(By.linkText("Reload")).click();
		
		//Entering CAPS letter and select text and double click
		
		WebElement txtBox = driver.findElement(By.id("name"));
		
		action.moveToElement(txtBox).click().keyDown(Keys.SHIFT).sendKeys("hello").doubleClick().build().perform();
		
		// Right Click
		
		action.moveToElement(txtBox).contextClick().build().perform();
		
		
		
		
		
		

	}

}
