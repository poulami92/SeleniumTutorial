package selenium;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v143.emulation.Emulation;

public class DevTools_ExecuteCDPCommand {

	public static void main(String[] args) throws InterruptedException {

        ChromeDriver driver = new ChromeDriver();
        
        DevTools devTools =driver.getDevTools();
        
        devTools.createSession();
        
        Map<String,Object> params = new HashMap<>();
        params.put("width", 768);
        params.put("height",1024);
        params.put("deviceScaleFactor", 50);
        params.put("mobile", true);
        
        //devTools.send(Emulation.setDeviceMetricsOverride(768, 1024, 50, true, Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty()));
        
        driver.executeCdpCommand("Emulation.setDeviceMetricsOverride",params);

        
        driver.manage().window().maximize();
        
        driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		
		driver.findElement(By.cssSelector(".navbar-toggler")).click();
		
		Thread.sleep(3000);
		
		driver.findElement(By.linkText("Library")).click();
		Thread.sleep(3000);
		
		driver.close();


	}

}
