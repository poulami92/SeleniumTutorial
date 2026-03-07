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

import PageObjects.GreenKartOffersPage;
import TestUtility.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GreenKartOffersPageSteps {

	TestContext testContext;
	GreenKartOffersPage offersPage;
	
	public GreenKartOffersPageSteps(TestContext testContext) 
	{
		this.testContext=testContext;
		offersPage= testContext.getPageObjectFactory().getGreenKartOffersPage();
	}

	@Then("User searched for same shortname {string} in offers page")
	public void user_searched_for_same_shortsame_in_offers_page(String searchPdtShortName) {
		
		offersPage.enterProduct(searchPdtShortName);
	}
	
	@Then("Check product exists")
	public void check_product_exists() {
	    String offerPagePdtName=offersPage.getTextOfSearchedItem();
	    Assert.assertEquals(offerPagePdtName, testContext.LandingPagePdtName);
	}

}
