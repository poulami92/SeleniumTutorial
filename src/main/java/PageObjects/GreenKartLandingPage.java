package PageObjects;

import java.time.Duration;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import BasePage.GrenKartTestBase;
import BasePage.TestBase;
import TestUtility.TestContext;

public class GreenKartLandingPage extends GrenKartTestBase{
	
	
	By searchBox = By.xpath("//input[@type='search']");
	By DealsLink = By.linkText("Top Deals");
	
	String prefix_xpath="//h4[contains(text(),'";
	String suffix_xpath="')]";
	
	By increament = By.cssSelector("a.increment");
	By AddToCart = By.xpath("//button[text()='ADD TO CART']");
	By Added = By.xpath("//button[(contains(text(),'ADDED'))]");
			
	public void searchProduct(String pdtName)
	{
		findElement(searchBox).sendKeys(pdtName);
	}
	
	public String getTextOfSearchedProduct(String searchPdtShortName)
	{
		WebElement searchPdt= findElement(By.xpath(prefix_xpath+searchPdtShortName+suffix_xpath));	
		
		return searchPdt.getText().split("-")[0].trim();
	}
	
	public void clickOnTopDeals()
	{
		findElement(DealsLink).click();
		switchToWindow();
		
	}
	
	public String getPageTitele()
	{
		return driver.getTitle();
	}
	
	public void addItemQuantity(int quantity) throws InterruptedException
	{
		Thread.sleep(2000);
		for(int i=1;i<quantity;i++)
		{
			findElement(increament).click();
		}
	}
	
	public void clickOnAddToCart()
	{
		findElement(AddToCart).click();
	}
	
	public void waitForItemsToBeAdded()
	{
		findElement(Added);
	}

}
