package PageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import BasePage.TestBase;

public class LoginPage extends TestBase{
	
	public LoginPage()
	{
		//super(driver);
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(id="userEmail")
	private WebElement userEmail;
	
	@FindBy(id="userPassword")
	private WebElement userPassword;
	
	@FindBy(id="login")
	private WebElement loginBtn;
	
	By loginSuccessMsg = By.id("toast-container");
	
	By errorMessageLocator = By.cssSelector("[class*='flyInOut']");
	
	
	public ProductCatalog loginApplication(String email,String password)
	{
		userEmail.sendKeys(email);
		userPassword.sendKeys(password);
		loginBtn.click();
		return new ProductCatalog();
	}
	
	
	public By getLoginSuccesfullMessageLocator()
	{
		return loginSuccessMsg;
	}
	
	public String getLoginSuccessMessage()
	{
		WebElement loginSucceslMessage= findElement(getLoginSuccesfullMessageLocator());
		return loginSucceslMessage.getText();
	}
	
	public void waitTillLoginSuccessMessageDisappear()
	{
		waitTillElementInvisible(getLoginSuccesfullMessageLocator());
	}
	
	public By getErrorMessageLocator()
	{
		return errorMessageLocator;
	}
	
	public String getErrorMessage()
	{
		return findElement(getErrorMessageLocator()).getText();
	}
	
}
