package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDrop {

	public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\MSUSERSL123\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.selenium.dev/selenium/web/mouse_interaction.html");
		
		Actions action = new Actions(driver);
		
		WebElement dragElem = driver.findElement(By.id("draggable"));
		
		WebElement dropElem = driver.findElement(By.id("droppable"));
		
		//action.clickAndHold(dragElem).moveToElement(dropElem).release().build().perform();
		
		action.dragAndDrop(dragElem, dropElem).build().perform();
		
		

	}

}
