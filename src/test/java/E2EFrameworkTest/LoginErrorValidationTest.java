package E2EFrameworkTest;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.TestNG;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BasePage.TestBase;
import PageObjects.CartPage;
import PageObjects.CheckOutPage;
import PageObjects.ConfirmationPage;
import PageObjects.LoginPage;
import PageObjects.ProductCatalog;

public class LoginErrorValidationTest extends BaseSetupTest{
	
	public LoginErrorValidationTest() throws IOException {
		super();
	}

	@Test
	public void loginErrorValidation() throws InterruptedException {
        
        //Login to application
        
        ProductCatalog productCatalog=loginPage.loginApplication(prop.getProperty("wrong_username"), prop.getProperty("password"));
        String loginErrorText= loginPage.getErrorMessage();      
    	Assert.assertEquals("Incorrect email or password.",loginErrorText);
    	
        
        
        
	}
	
	@Test
    public void productErrorValidation() throws InterruptedException {
        
        //Login to application
        
        ProductCatalog productCatalog=loginPage.loginApplication(prop.getProperty("username"), prop.getProperty("password"));
        String loginText= loginPage.getLoginSuccessMessage();      
    	Assert.assertEquals(loginText,"Login Successfully");
    	loginPage.waitTillLoginSuccessMessageDisappear();
    	
    	//Add Products to Cart
        
        
        String products[] = {"ZARA"};
        
        for(String pdt:products)
        {
        	productCatalog.addProductToCart(pdt);
        	String productAddedText=productCatalog.getProductAddedMessage();
        	Assert.assertEquals(productAddedText,"Product Added To Cart");
        	productCatalog.waitTillProductAddedSuccessMessageDisappear();
        }
        
        CartPage cartPage = productCatalog.clickOnCart();
        
          for(String pdt: products)
          {
        	  boolean match=cartPage.matchCartItem(pdt);
        	  Assert.assertTrue(match);
          }
          

         
        
        
	}
	
	
		
}
