package selenium;

import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v143.emulation.Emulation;

public class DevTools_VerifyAppResponsiveness {

	public static void main(String[] args) throws InterruptedException {

        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        
        DevTools devTools =driver.getDevTools();
        
        devTools.createSession();
        
        //set parameters for device simulation
        
        devTools.send(Emulation.setDeviceMetricsOverride(768, 1024, 50, true, Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty()));
        
        driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		
		driver.findElement(By.cssSelector(".navbar-toggler")).click();
		
		Thread.sleep(3000);
		
		driver.findElement(By.linkText("Library")).click();
		Thread.sleep(3000);
		
		driver.close();


	}

}
