package TestNgTutorial;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionTest {
	
	//Hard assertion
	
	@Test
	public void getTitle()
	{
        WebDriver driver = new ChromeDriver();
		
        driver.get("https://www.selenium.dev/");
        
        String expectedTitle="Selenium";
        
        String actualTitle=driver.getTitle();
        
        Assert.assertEquals(actualTitle, expectedTitle);
        
        boolean flag=driver.findElement(By.xpath("//h4[text()='Selenium WebDriver']")).isDisplayed();
        
        Assert.assertTrue(flag);
        
        //Assert.assertFalse(flag);
        
        
	}
	
	//Soft assertion

	@Test
	public void assertionTest()
	{
		SoftAssert sa = new SoftAssert();
        System.out.println("Open Browser");
        sa.assertTrue(false,"Browser launch fail");
        System.out.println("Click Login button");
        System.out.println("Enter data");
        sa.assertTrue(false,"Data entry fail");
        System.out.println("Validate title");
        
        sa.assertAll();
	}

}
