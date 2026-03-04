package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ElementVisibilityCheck {

	public static void main(String[] args) {
		
        System.setProperty("webdriver.chrome.driver","C:\\Users\\MSUSERSL123\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		driver.findElement(By.id("hide-textbox")).click();
		
		boolean isVisible = driver.findElement(By.id("displayed-text")).isDisplayed();
		
		System.out.println(isVisible);
		
		boolean isEnabled = driver.findElement(By.id("alertbtn")).isEnabled();
		
		System.out.println(isEnabled);
		
		WebElement radio = driver.findElement(By.xpath("//input[@value='radio1']"));
		
		radio.click();
		
		boolean isSelected = radio.isSelected();
		
		System.out.println(isSelected);
		
		

	}

}
