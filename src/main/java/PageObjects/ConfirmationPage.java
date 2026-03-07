package PageObjects;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import BasePage.TestBase;

public class ConfirmationPage extends TestBase{
	
	public ConfirmationPage()
	{
		//super(driver);
		PageFactory.initElements(driver, this);
	}
	
	By thankYouLocator =By.cssSelector(".hero-primary");
	
	By orderNosLocator =By.xpath("//td[contains(text(),'You can see all the Orders')]//parent::tr//following-sibling::tr//label");
	
	
	public By getThankYouLocator()
	{
		return thankYouLocator;
	}
	
	public String getThankYouText()
	{
		return findElement(getThankYouLocator()).getText();
	}
	
	public By getOrderNosLocator()
	{
		return orderNosLocator;
	}
		
	public List<String> getOrderNos()
	{
		List<WebElement> orderNoElements= findElements(getOrderNosLocator());
		
		List<String> orderNos= new ArrayList<>();;
	    
	    for(WebElement el:orderNoElements)
	    {
	    	String orderNo = el.getText().split(" ")[1].trim();
	    	orderNos.add(orderNo);
	    }
	    
	    return orderNos;
	}
	
}
