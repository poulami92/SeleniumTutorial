package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptExecutor {

	public static void main(String[] args) throws InterruptedException {
		
        System.setProperty("webdriver.chrome.driver","C:\\Users\\MSUSERSL123\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		WebElement element = driver.findElement(By.xpath("//button[text()='Home']"));
		
		WebElement mousehover = driver.findElement(By.id("mousehover"));
		
		//flash(element,driver);
		
		//drawBorder(element,driver);
		
		//generarteAlert("There is issue",driver);
		
		//clickElement(element,driver);
		
		//pageRefresh(driver);
		
		//getPageTitle(driver);
		
		//getPageText(driver);
		
		//scrollPageDown(driver);
		
		scrollintoView(mousehover,driver);
		
		

	}
	
	public static void flash(WebElement element , WebDriver driver) throws InterruptedException
	{
		String bgColor = element.getCssValue("backgroundColor");
		for(int i=0;i<100;i++)
		{
			changeColor("rgb(0,200,0)",element,driver);
			Thread.sleep(3000);
			changeColor(bgColor,element,driver);
		}
	}
	
	public static void changeColor(String color, WebElement element, WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].style.backgroundColor='"+color+"'", element);
		
	}
	
	public static void drawBorder(WebElement element, WebDriver driver)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].style.border='3px solid red'", element);
	}
	
	public static void generarteAlert(String message, WebDriver driver)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("alert('"+message+"')");
	}
	
	public static void clickElement(WebElement element, WebDriver driver)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();",element);
	}
	
	public static void pageRefresh(WebDriver driver)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("history.go(0)");
	}
	
	public static void getPageTitle(WebDriver driver)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		String title= js.executeScript("return document.title;").toString();
		System.out.println(title);
	}
	
	public static void getPageText(WebDriver driver)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		String text= js.executeScript("return document.documentElement.innerText").toString();
		System.out.println(text);
	}
	
	
	public static void scrollPageDown(WebDriver driver)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}
	
	public static void scrollintoView(WebElement element, WebDriver driver)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);",element);
	}

}
