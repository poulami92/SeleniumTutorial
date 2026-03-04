package selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTableSeachValidation {

	public static void main(String[] args) {


        WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		String vegiName="Grapes";
		
		driver.findElement(By.id("search-field")).sendKeys(vegiName);
		
		List<WebElement> searchList=driver.findElements(By.xpath("//tr//td[1]"));
		
		boolean flag= true;
		
		for(WebElement e:searchList)
		{
			if(!(e.getText().contains(vegiName)))
			{
				flag= false;
				break;
			}
		}
		
		System.out.println(flag);
		
	}

}
