package selenium;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v143.emulation.Emulation;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DevTools_SetGeoLocation {

	public static void main(String[] args) throws InterruptedException {

        ChromeDriver driver = new ChromeDriver();
        
        DevTools devTools =driver.getDevTools();
        
        devTools.createSession();
        
        //Set co-ordinates for location
        
        Map<String,Object>coordinates = new HashMap<String,Object>();
		coordinates.put("latitude", 40);
		coordinates.put("longitude", 3);
		coordinates.put("accuracy", 1);
 
        driver.manage().window().maximize();
        
        driver.executeCdpCommand("Emulation.setGeolocationOverride", coordinates);
		driver.get("https://www.google.com");
		driver.findElement(By.name("q")).sendKeys("netflix",Keys.ENTER);
		new WebDriverWait(driver,Duration.ofSeconds(20)).
		until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".LC20lb")))
		.get(0).click();
		//driver.findElements(By.cssSelector(".LC20lb")).get(0).click();
		String title =driver.findElement(By.cssSelector(".our-story-card-title")).getText();
		System.out.println(title);



	}

}
