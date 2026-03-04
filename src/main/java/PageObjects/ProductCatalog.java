package PageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import BasePage.TestBase;
import TestUtility.TestUtil;

public class ProductCatalog extends TestBase{
	
	public ProductCatalog(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	private String before_xpath="//b[contains(text(),'";
    
    private String after_xpath="')]//parent::h5//following-sibling::button[contains(text(),'Add To Cart')]";
    
    By productAddedMsg = By.id("toast-container");
    
    @FindBy(xpath="//ul//button[contains(text(),'Cart')]")
	private WebElement cart;
    
    @FindBy(xpath="//button[@routerlink='/dashboard/myorders']")
	private WebElement ordersBtn;
	

	public void addProductToCart(String product)
	{
		findElement(By.xpath(before_xpath+product+after_xpath)).click();
	}
	
	public By getProductAddedMessageLocator()
	{
		return productAddedMsg;
	}
	
	public String getProductAddedMessage()
	{
		WebElement productAddedMessage= findElement(getProductAddedMessageLocator());
		return productAddedMessage.getText();
	}
	
	public void waitTillProductAddedSuccessMessageDisappear()
	{
		waitTillElementInvisible(getProductAddedMessageLocator());
	}
	
	public CartPage clickOnCart()
	{
		cart.click();
		return new CartPage(driver);
	}
	
	public OrdersPage clickOnOrders()
	{
		ordersBtn.click();
		return new OrdersPage(driver);
	}
	
}
