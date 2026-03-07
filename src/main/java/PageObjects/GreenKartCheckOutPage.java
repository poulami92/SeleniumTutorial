package PageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import BasePage.GrenKartTestBase;
import BasePage.TestBase;
import TestUtility.TestContext;

public class GreenKartCheckOutPage extends GrenKartTestBase{
	
	
	By cartBag = By.cssSelector("a.cart-icon");
	By checkOut = By.xpath("//button[contains(text(),'PROCEED')]");
	
	By applyButton = By.cssSelector(".promoBtn");
    By placeOrder = By.xpath("//button[text()='Place Order']");
    By productElem = By.xpath("//tbody//td[2]//p");
    By productNo = By.xpath("//tbody//td[3]//p");

	
	public void clickOnCartBag()
	{
		findElement(cartBag).click();
	}
	
	public void clickOnCheckOut()
	{
		findElement(checkOut).click();
		
	}
	
	public boolean verifyApplyButtonDisplayed()
	{
		return findElement(applyButton).isDisplayed();
	}
	
	public boolean verifyPlaceOrderButtonDisplayed()
	{
		return findElement(placeOrder).isDisplayed();
	}
	
	public String getProductName()
	{
		return findElement(productElem).getText().split("-")[0].trim();
	}
	
	public String getProductQuantity()
	{
		return findElement(productNo).getText();
	}

}
