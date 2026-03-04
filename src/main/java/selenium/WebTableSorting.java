package selenium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTableSorting {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		//verifySortingWithOutStream(driver);
		
		verifySortingWithStream(driver);

	}
	
	public static void verifySortingWithOutStream(WebDriver driver)
	{
        driver.findElement(By.xpath("//th[@aria-sort='descending']")).click();
		
		List<WebElement> sortedElements= driver.findElements(By.xpath("//tbody//tr//td[1]"));
		
        List<String> actualSortedNames = new ArrayList<>();
        
		
		for(WebElement el : sortedElements)
		{
			actualSortedNames.add(el.getText());			
		}
		
		List<String> expectedSortedNames = new ArrayList<>(actualSortedNames);
		
		Collections.sort(expectedSortedNames);
		
		
		System.out.println(actualSortedNames.equals(expectedSortedNames));
	}
	
	public static void verifySortingWithStream(WebDriver driver)
	{
        driver.findElement(By.xpath("//th[@aria-sort='descending']")).click();
		
		List<WebElement> sortedElements= driver.findElements(By.xpath("//tbody//tr//td[1]"));
		
		List<String> actualSortedNames=sortedElements.stream().map(s->s.getText()).collect(Collectors.toList());
		
		List<String> expectedSortedNames=actualSortedNames.stream().sorted().collect(Collectors.toList());
		
		System.out.println(actualSortedNames.equals(expectedSortedNames));
		
        
	}
	

}
