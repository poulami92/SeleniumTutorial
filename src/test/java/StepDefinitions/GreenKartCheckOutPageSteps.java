package StepDefinitions;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import PageObjects.GreenKartCheckOutPage;
import PageObjects.GreenKartOffersPage;
import TestUtility.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GreenKartCheckOutPageSteps {

	TestContext testContext;
	GreenKartCheckOutPage checkOutPage;
	
	public GreenKartCheckOutPageSteps(TestContext testContext) 
	{
		this.testContext=testContext;
		checkOutPage= testContext.getPageObjectFactory().getGreenKartCheckOutPage();
	}

	@Then("User proceeds to Checkout")
	public void checkOutProduct() {
		
		checkOutPage.clickOnCartBag();
		checkOutPage.clickOnCheckOut();
		
	}
	
	@And("User validate {string} in checkout page")
	public void userValidateProductOnCheckOutPage(String searchPdtShortName)
	{
		String actualsProducName= checkOutPage.getProductName();
		Assert.assertTrue(actualsProducName.contains(searchPdtShortName));
	}
	
	@And("User validate item quantity {string} in checkout page")
	public void userValidateItemQuantity(String quantity)
	{
		String actualQuantity= checkOutPage.getProductQuantity();
		Assert.assertEquals(actualQuantity, quantity);;
	}
	
	@And("User has ability to enter promocode and place order")
	public void checkPromoCodeVisible() {
		
		boolean applyBtnVisible= checkOutPage.verifyApplyButtonDisplayed();
		Assert.assertTrue(applyBtnVisible);
		boolean placeOrderVisible = checkOutPage.verifyPlaceOrderButtonDisplayed();
		Assert.assertTrue(placeOrderVisible);
	    
	}

}
