package TestNgTutorial;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParametersTest {
	
	@Test
	@Parameters({"url","username","password"})
	public void loginTest(String url,String username,String password)
	{
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		
		driver.findElement(By.id("signInBtn")).click();
		
	}

}
