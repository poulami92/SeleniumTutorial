package E2EStandAloneTest;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import PageObjects.LoginPage;

public class E2ESeleniumCode {
	
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

        driver=new ChromeDriver();
        
        driver.manage().window().maximize();
        
        driver.get("https://rahulshettyacademy.com/client");
        
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        
        driver.findElement(By.id("userEmail")).sendKeys("Gpd@gmail.com");
        
        driver.findElement(By.id("userPassword")).sendKeys("Kolkata@1");
        
        driver.findElement(By.id("login")).click();
        
        String loginText=findElement(By.id("toast-container")).getText();
        
    	Assert.assertEquals("Login Successfully", loginText);
        
    	waitTillElementInvisible(By.id("toast-container"));
    	
      //b[contains(text(),'ZARA')]//parent::h5//following-sibling::button[contains(text(),'Add To Cart')]        
        
        
        String products[]={"ZARA","ADIDAS"};
        
        for(String pdt:products)
        {
        	AddProduct(pdt);
        	String alertText=findElement(By.id("toast-container")).getText();
        	Assert.assertEquals("Product Added To Cart", alertText);
        	waitTillElementInvisible(By.id("toast-container"));
        }
        
        driver.findElement(By.xpath("//ul//button[contains(text(),'Cart')]")).click();
        
        List<WebElement> cartItems = findElements(By.cssSelector(".cartSection h3"));
        
        for(String pdt:products) 
        {
          boolean match=cartItems.stream().map(item->item.getText()).anyMatch(item->item.contains(pdt));

          Assert.assertTrue(match);
        }
        
        JavascriptExecutor js = (JavascriptExecutor)driver;
        
		WebElement checkOutBtn= findElement(By.cssSelector(".totalRow button"));
		
		js.executeScript("arguments[0].click();",checkOutBtn);
        
        driver.findElement(By.xpath("//input[@placeholder='Select Country']")).sendKeys("India");
        
        List<WebElement> countryList= findElements(By.cssSelector("section.list-group button span"));	
        
        
        for(WebElement el:countryList)
        {
        	String countryName=el.getText();
        	if(countryName.equals("India"))
        	{
        		el.click();
        		break;
        	}
        }
        
        findElement(By.xpath("//a[contains(text(),'Place Order')]")).click();
        
        String confirmMsg= findElement(By.cssSelector(".hero-primary")).getText();
        
        Assert.assertEquals(confirmMsg, "THANKYOU FOR THE ORDER.");
        
        List<WebElement> orderNoElements= findElements(By.xpath("//td[contains(text(),'You can see all the Orders')]//parent::tr//following-sibling::tr//label"));
        
        List<String> orderNos= new ArrayList<>();;
        
        for(WebElement el:orderNoElements)
        {
        	String orderNo = el.getText().split(" ")[1].trim();
        	orderNos.add(orderNo);
        }
        
        System.out.println(orderNos);
        
    
        driver.quit();
        
	}
	
	public static WebElement findElement(By by)
	{
		return new WebDriverWait(driver,Duration.ofSeconds(5)).
        until(ExpectedConditions.visibilityOfElementLocated(by));
	}
	
	public static List<WebElement> findElements(By by)
	{
		return new WebDriverWait(driver,Duration.ofSeconds(5)).
        until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
	}
	
	public static void AddProduct(String product)
	{
        String before_xpath="//b[contains(text(),'";
        
        String after_xpath="')]//parent::h5//following-sibling::button[contains(text(),'Add To Cart')]";
        
		findElement(By.xpath(before_xpath+product+after_xpath)).click();
	}
	
	public static void waitTillElementInvisible(By by)
	{
		new WebDriverWait(driver,Duration.ofSeconds(5)).
        until(ExpectedConditions.invisibilityOfElementLocated(by));
	}

}
