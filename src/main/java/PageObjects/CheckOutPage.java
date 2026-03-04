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

public class CheckOutPage extends TestBase{
	
	public CheckOutPage(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//input[@placeholder='Select Country']")
	private WebElement countryDropDown;
	
	By dropDownOptionsLocator =By.cssSelector("section.list-group button span");
	
	By placeOrderLocator = By.xpath("//a[contains(text(),'Place Order')]");

	public void typeCountryInCountryDropDown(String country)
	{
		countryDropDown.sendKeys("India");
	}
	
	public By getDropDownOptionsLocator()
	{
		return dropDownOptionsLocator;
	}
	
	public By getPlaceOrderLocator()
	{
		return placeOrderLocator;
	}
	
	public void selectCountryFromDropDown(String country)
	{
		List<WebElement> countryList = findElements(getDropDownOptionsLocator());
		
		for(WebElement el:countryList)
	    {
	    	String countryName=el.getText();
	    	if(countryName.equals("India"))
	    	{
	    		el.click();
	    		break;
	    	}
	    }
	}
	
	public ConfirmationPage clickPlaceOrder()
	{
		findElement(getPlaceOrderLocator()).click();
		return new ConfirmationPage(driver);
	}
	
}
