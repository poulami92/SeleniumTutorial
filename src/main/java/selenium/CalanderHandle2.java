package selenium;

import java.time.Month;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CalanderHandle2 {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		String date = "07-05-2028";
		
		String dateArr[] =date.split("-");
		
		String day = dateArr[0];
		
		String month = dateArr[1];
		
		String year = dateArr[2];
				
		driver.findElement(By.cssSelector(".react-date-picker__inputGroup__year")).click();
		
		driver.findElement(By.cssSelector(".react-calendar__navigation__label__labelText")).click();
		
		driver.findElement(By.cssSelector(".react-calendar__navigation__label__labelText")).click();
		
		//button[text()='2028']
		
		driver.findElement(By.xpath("//button[text()='"+year+"']")).click();
		
		//div[@class='react-calendar__year-view__months']//button[5]
		
		driver.findElement(By.xpath("//div[@class='react-calendar__year-view__months']//button["+Integer.parseInt(month)+"]")).click();
		
		//div[@class='react-calendar__month-view__days']//button[5]
		
		driver.findElement(By.xpath("//div[@class='react-calendar__month-view__days']//button["+Integer.parseInt(day)+"]")).click();
		
		WebElement dateText = driver.findElement(By.xpath("//div[@class='react-date-picker__inputGroup']//input[@type='date']"));
		
		String dateValue = dateText.getAttribute("value");
		
        String dateValueArr[] =dateValue.split("-");
		
		String actualDay = dateValueArr[2];
		
		String actualMonth = dateValueArr[1];
		
		String actualYear = dateValueArr[0];
		
		System.out.println(day.equals(actualDay));
		
		System.out.println(month.equals(actualMonth));
		
		System.out.println(year.equals(actualYear));
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
