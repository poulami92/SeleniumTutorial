package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTable1 {

	public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","C:\\Users\\MSUSERSL123\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		//Find Position of Ivory
		
		int tableRows=driver.findElements(By.xpath("//div[@class='tableFixHead']//table[@id='product']//tbody//tr")).size();
		
		String before_xpath = "//div[@class='tableFixHead']//table[@id='product']//tbody//tr[";
		
		String after_xpath = "]//td[1]";
		
		String position="";
		
		for(int i =1;i<=tableRows;i++)
		{
			String name = driver.findElement(By.xpath(before_xpath+i+after_xpath)).getText();
			
			if(name.equals("Ivory"))
			{
				position = driver.findElement(By.xpath(before_xpath+i+"]//td[2]")).getText();
				break;
			}
		}
		
		System.out.println(position);

	}

}
