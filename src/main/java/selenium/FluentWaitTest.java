package selenium;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class FluentWaitTest {

	public static void main(String[] args) throws InterruptedException {

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
        
        driver.findElement(By.cssSelector("a.cart-icon")).click();
        
        
        
        //Thread.sleep(3000);
        
        //waitForElement(driver,By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
        
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class)
                .ignoring(ElementNotInteractableException.class);
        
        driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
        

//        WebElement promo = wait.until(d ->
//        d.findElement(By.cssSelector("input.promoCode"))
//        );
//        
        WebElement promo = wait.until(d -> {
            WebElement el = d.findElement(By.cssSelector("input.promoCode"));
            return el.isDisplayed() ? el : null;
        });
        
        promo.sendKeys("rahulshettyacademy");

	}
	
	public static void addItem(WebDriver driver, String item)
	{
        String before_xpath = "//h4[contains(text(),'";
        
        String after_xpath = "')]//following-sibling::div[@class='product-action']//button";
        
        driver.findElement(By.xpath(before_xpath+item+after_xpath)).click();
	}

}
