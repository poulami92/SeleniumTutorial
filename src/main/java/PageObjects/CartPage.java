package PageObjects;

import java.time.Duration;
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

public class CartPage extends TestBase{
	
	public CartPage()
	{
		//super(driver);
		PageFactory.initElements(driver, this);
	}
 
	
	By cartItems= By.cssSelector(".cartSection h3");
	
	@FindBy(css=".totalRow button")
	private WebElement checkOutBtn;
	
	public List<WebElement> getAllCartItems()
	{
		return findElements(cartItems);
	}
	
	public boolean matchCartItem(String product)
	{
		return getAllCartItems().stream().map(item->item.getText()).anyMatch(item->item.contains(product));
	}
	
	public CheckOutPage clickOnCheckout()
	{
		clickElementByJs(checkOutBtn);
		return new CheckOutPage();
		
	}
	

	
	
	
	
	
	
	
	
	
}
