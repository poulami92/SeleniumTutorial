package PageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import BasePage.TestBase;

public class OrdersPage extends TestBase{
	
	public OrdersPage(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	
	By orderIds = By.xpath("//tbody//th");
	
	public List<WebElement> getAllOrderIds()
	{
		return findElements(orderIds);
	}
	
	
	public boolean verifyOrderId(String orderId)
	{
		  return getAllOrderIds().stream().map(order->order.getText()).anyMatch(order->order.equals(orderId));
		
	}
	
	
	
}
