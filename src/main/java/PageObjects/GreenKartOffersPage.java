package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import BasePage.GrenKartTestBase;
import BasePage.TestBase;
import TestUtility.TestContext;

public class GreenKartOffersPage extends GrenKartTestBase {
	
	
	By searchTextBox= By.xpath("//input[@type='search']");
	
	By searchItem = By.xpath("//tbody//td[1]");
	
	public void enterProduct(String pdtName)
	{
		findElement(searchTextBox).sendKeys(pdtName);
	}
	
	public String getTextOfSearchedItem()
	{
		return findElement(searchItem).getText();
	}

}
