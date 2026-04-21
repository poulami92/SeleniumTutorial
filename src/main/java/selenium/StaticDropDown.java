package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class StaticDropDown {

	public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\MSUSERSL123\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		Select sel = new Select(driver.findElement(By.id("dropdown-class-example")));
		//Select sel = new Select(driver.findElement(By.tagName("Select")));
		
		sel.selectByVisibleText("Option1");
		
		String selectedValue = sel.getFirstSelectedOption().getText();  
		
		

	}

}
