package selenium;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v143.emulation.Emulation;

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
		driver.get("https://www.bookmyshow.com");
		driver.findElement(By.name("q")).sendKeys("netflix",Keys.ENTER);
		driver.findElements(By.cssSelector(".LC20lb")).get(0).click();
		String title =driver.findElement(By.cssSelector(".our-story-card-title")).getText();
		System.out.println(title);



	}

}
