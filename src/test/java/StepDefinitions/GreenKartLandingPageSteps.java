package StepDefinitions;

import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import PageObjects.GreenKartLandingPage;
import PageObjects.GreenKartOffersPage;
import TestUtility.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GreenKartLandingPageSteps {
	
	TestContext testContext;
	GreenKartLandingPage landingPage;
	WebDriver driver;
	
	public GreenKartLandingPageSteps(TestContext testContext)
	{
		this.testContext=testContext;
		landingPage= testContext.getPageObjectFactory().getGreenKartLandingPage();
	}
	
	@Given("User is on Greenkart Landing Page")
	public void user_is_on_greenkart_landing_page() throws IOException {
		
		String actualTitle = landingPage.getPageTitele();
		String expectedTitle = "GreenKart";
		
		Assert.assertTrue(actualTitle.contains(expectedTitle));
	}
	
	@When("User searched with shortname {string} and extracted product name")
	public void user_searched_with_shortname(String searchPdtShortName) throws InterruptedException {
		
		landingPage.searchProduct(searchPdtShortName);
	   
		testContext.LandingPagePdtName= landingPage.getTextOfSearchedProduct(searchPdtShortName);
		System.out.println(testContext.LandingPagePdtName);
		
	}
	
	@Then("User click on Top Deals")
	public void user_click_on_Top_Deals()
	{
		landingPage.clickOnTopDeals();
	}
	
	@When("Added {string} itmes of selected product to cart")
	public void added_itmes_of_selected_product_to_cart(String quantity) throws NumberFormatException, InterruptedException {
		landingPage.addItemQuantity(Integer.parseInt(quantity));
		landingPage.clickOnAddToCart();
		landingPage.waitForItemsToBeAdded();
	}

}
