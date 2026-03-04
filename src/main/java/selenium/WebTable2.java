package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTable2 {

	public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","C:\\Users\\MSUSERSL123\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		//Find Position of Ivory
		
		String name = "Ivory";
		
        String before_xpath = "//table[@id='product']//tr//td[text()='";
		
		String after_xpath = "']//following-sibling::td[1]";
		
		String position = driver.findElement(By.xpath(before_xpath+name+after_xpath)).getText();
		
		System.out.println(position);
	}

}
