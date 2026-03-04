package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorsConcept {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\MSUSERSL123\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		//driver.findElement(By.id("name")).sendKeys("poulami");
		
		//driver.findElement(By.name("enter-name")).sendKeys("poulami");
		
		//driver.findElement(By.xpath("//input[@id='name']")).sendKeys("poulami");
		
		//driver.findElement(By.cssSelector("input#name")).sendKeys("poulami");
		
		driver.findElement(By.className("ui-autocomplete-input")).sendKeys("poulami");
		
		//driver.findElement(By.linkText("Free Access to InterviewQues/ResumeAssistance/Material")).click();
		
		//driver.findElement(By.partialLinkText("Free Access to InterviewQues")).click();
		
		driver.findElement(By.tagName("select")).click();
		
		

	}

}
