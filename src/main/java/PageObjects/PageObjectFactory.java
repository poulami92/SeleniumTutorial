package PageObjects;

import org.openqa.selenium.WebDriver;

import TestUtility.TestContext;

public class PageObjectFactory {
	
	public GreenKartLandingPage getGreenKartLandingPage()
	{
		return new GreenKartLandingPage();
	}
	
	public GreenKartOffersPage getGreenKartOffersPage()
	{
		return new GreenKartOffersPage();
	}
	
	public GreenKartCheckOutPage getGreenKartCheckOutPage()
	{
		return new GreenKartCheckOutPage();
	}

}
