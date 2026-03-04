package selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTablePagination {

	public static void main(String[] args) {


        WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		String vegiName="Cherry";
		
		//td[text()='Cherry']//following-sibling::td[1]
		
		String before_xpath="//td[text()='";
		
		String after_xpath="']//following-sibling::td[1]";
		
		List<WebElement> searchList=getSearchList(before_xpath,after_xpath,vegiName,driver);
		
		while(searchList.isEmpty())
		{
			driver.findElement(By.xpath("//a[@aria-label='Next']")).click();
			searchList=getSearchList(before_xpath,after_xpath,vegiName,driver);
		}
		
		String price=searchList.get(0).getText();
		
		System.out.println(price);

	}
	
	public static List<WebElement> getSearchList(String before_xpath,String after_xpath,String vegiName,WebDriver driver)
	{
		return driver.findElements(By.xpath(before_xpath+vegiName+after_xpath));
	}

}
