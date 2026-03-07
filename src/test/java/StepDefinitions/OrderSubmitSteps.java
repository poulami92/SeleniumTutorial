package StepDefinitions;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.testng.Assert;

import DriverFactory.DriverFactory;
import PageObjects.CartPage;
import PageObjects.CheckOutPage;
import PageObjects.ConfirmationPage;
import PageObjects.LoginPage;
import PageObjects.ProductCatalog;
import TestNGFramework_OrderSubmitTest.BaseSetupTest;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class OrderSubmitSteps{
	
	private ProductCatalog productCatalog;
	private CheckOutPage checkOutPage;
	private ConfirmationPage confirmationPage;
	
	//private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	private LoginPage loginPage = new LoginPage();
	
	

// @Given("User Landed on Ecommerce Page")
// public void UserOnEcommPage()
// {
//	 LaunchApplication();
// }
 
 @Given("User logged in to application")
 public void applicationLogin(Map<String,String> param)
 {
	 productCatalog=loginPage.loginApplication(param.get("Username"), param.get("Password"));
 }
 
 @When("User added product to cart")
 public void userAddedProduct(Map<String,String> param)
 {
	 String productList[]= param.get("Products").split(",");
	 
	 for(String product: productList)
	 {
		productCatalog.addProductToCart(product);
     	String productAddedText=productCatalog.getProductAddedMessage();
     	Assert.assertEquals(productAddedText,"Product Added To Cart");
     	productCatalog.waitTillProductAddedSuccessMessageDisappear();
	 }
 }
 
 @And("User Verify Cart Products and CheckOut")
 public void productCheckOutAndSubmit(Map<String,String> param)
 {
     String productList[]= param.get("Products").split(",");
	 
     
     CartPage cartPage = productCatalog.clickOnCart();
	 
	 for(String product: productList)
	 {
	    boolean match=cartPage.matchCartItem(product);

	    Assert.assertTrue(match);
	 }
	      
	 checkOutPage=cartPage.clickOnCheckout();
 }
 
 @And("User Place Order")
 public void userPlaceOrder()
 {
	 checkOutPage.typeCountryInCountryDropDown("India");
     
     checkOutPage.selectCountryFromDropDown("India");
     
     confirmationPage =checkOutPage.clickPlaceOrder();
 }
 
 @Then("{string} message displayed on confirmation page")
 public void verifyConfirmationMessage(String expectedMsg)
 {
	 String actualConfirmMsg=confirmationPage.getThankYouText();
     Assert.assertEquals(expectedMsg,actualConfirmMsg);
     
     List<String> orderNos= confirmationPage.getOrderNos();
     System.out.println(orderNos);
     
 }
 
 @Then("{string} message displayed on login page")
 public void verifyLoginErrorMessage(String expectedMsg)
 {
	 if(expectedMsg.contains("Login Successfully"))
	 {
	 String loginText= loginPage.getLoginSuccessMessage();
	 Assert.assertEquals(expectedMsg,loginText);
	 loginPage.waitTillLoginSuccessMessageDisappear();
	 }
	 else
	 {
		 String loginErrorText= loginPage.getErrorMessage();
		 Assert.assertEquals(expectedMsg,loginErrorText);
	 }
 	 
 	 
 	 
 	 
     
 }
	           
}
 

