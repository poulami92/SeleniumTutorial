package TestNGFramework_OrderSubmitTest;

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
import PageObjects.OrdersPage;
import PageObjects.ProductCatalog;

public class OrderSubmitE2ETest extends BaseSetupTest{
	
	List<String> orderNos;
	String products[]={"ZARA","ADIDAS"};
	
	public OrderSubmitE2ETest() throws IOException {
		super();
	}

	@Test
	public void submitOrderTest() throws InterruptedException {
        
        //Login to application
        
        ProductCatalog productCatalog=loginPage.loginApplication(prop.getProperty("username"), prop.getProperty("password"));
        String loginText= loginPage.getLoginSuccessMessage();      
    	Assert.assertEquals(loginText,"Login Successfully");
    	loginPage.waitTillLoginSuccessMessageDisappear();
    	
    	//Add Products to Cart
        
        for(String pdt:products)
        {
        	productCatalog.addProductToCart(pdt);
        	String productAddedText=productCatalog.getProductAddedMessage();
        	Assert.assertEquals(productAddedText,"Product Added To Cart");
        	productCatalog.waitTillProductAddedSuccessMessageDisappear();
        }
        
        //Click on Cart Icon
        
        CartPage cartPage = productCatalog.clickOnCart();
        
        //Verify each Cart Item
        
        for(String pdt:products) 
        {
          boolean match=cartPage.matchCartItem(pdt);

          Assert.assertTrue(match);
        }
        
        //Click on Ckeckout Button
        
        CheckOutPage checkOutPage=cartPage.clickOnCheckout();
        
        //Select Country from DropDown
        
        checkOutPage.typeCountryInCountryDropDown("India");
        
        checkOutPage.selectCountryFromDropDown("India");
        
        //Click on Checkout button
        
        ConfirmationPage confirmationPage =checkOutPage.clickPlaceOrder();
       
        //Verify Thank You Message
        
        String confirmMsg=confirmationPage.getThankYouText();
        Assert.assertEquals("THANKYOU FOR THE ORDER.",confirmMsg);
        
        //Get Order Nos
        
        orderNos= confirmationPage.getOrderNos();
        System.out.println(orderNos);
        
	}
	
	
	@Test(dependsOnMethods="submitOrderTest")
	public void orderHistoryTest() throws InterruptedException {
        
        //Login to application
        
        ProductCatalog productCatalog=loginPage.loginApplication(prop.getProperty("username"), prop.getProperty("password"));
        String loginText= loginPage.getLoginSuccessMessage();      
    	Assert.assertEquals(loginText,"Login Successfully");
    	loginPage.waitTillLoginSuccessMessageDisappear();
    	
    	OrdersPage ordersPage= productCatalog.clickOnOrders();
    	
    	for(String orderNo:orderNos) 
        {
          boolean match=ordersPage.verifyOrderId(orderNo);

          Assert.assertTrue(match);
        }
        
        
        
        
	}
	
	
		
}
