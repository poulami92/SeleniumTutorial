package selenium;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class E2ECartSite {

	public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
		
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
        
        //h4[contains(text(),'Cucumber')]//following-sibling::div[@class='product-action']//button
        
        //String item= "Cucumber";
        
        String items[]= {"Carrot","Brinjal","Cucumber"};
        
        List<String> itemList= Arrays.asList(items);
        
        for(String item:itemList)
        {
        	addItem(driver, item);
        }
        
        driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
        
        waitForElement(driver,By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
        
        driver.findElement(By.cssSelector("button.promoBtn")).click();
        
        String promoInfo= waitForElement(driver,By.cssSelector("span.promoInfo")).getText();
        
        System.out.println(promoInfo);
        
        String discount = driver.findElement(By.cssSelector("span.discountAmt")).getText();
        
        System.out.println(discount);
        
  
	}
	
	
	public static void addItem(WebDriver driver, String item)
	{
        String before_xpath = "//h4[contains(text(),'";
        
        String after_xpath = "')]//following-sibling::div[@class='product-action']//button";
        
        driver.findElement(By.xpath(before_xpath+item+after_xpath)).click();
	}
	
	public static WebElement waitForElement(WebDriver driver, By locator)
	{
		return new WebDriverWait(driver,Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

}
