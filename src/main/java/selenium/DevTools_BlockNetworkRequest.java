package selenium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v143.emulation.Emulation;
import org.openqa.selenium.devtools.v143.fetch.Fetch;
import org.openqa.selenium.devtools.v143.fetch.model.RequestPattern;
import org.openqa.selenium.devtools.v143.network.Network;
import org.openqa.selenium.devtools.v143.network.model.BlockPattern;
import org.openqa.selenium.devtools.v143.network.model.ErrorReason;
import org.openqa.selenium.devtools.v143.network.model.Request;
import org.openqa.selenium.devtools.v143.network.model.Response;

import com.google.common.collect.ImmutableList;

public class DevTools_BlockNetworkRequest {

	public static void main(String[] args) throws InterruptedException {

        ChromeDriver driver = new ChromeDriver();
        
        DevTools devTools =driver.getDevTools();
        
        devTools.createSession();
        
        devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty()));
      
        devTools.send(Network.setBlockedURLs(Optional.empty(), Optional.of(Arrays.asList("*.jpg", "*.css"))));

        
        driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.linkText("Browse Products")).click();
		driver.findElement(By.linkText("Selenium")).click();
		driver.findElement(By.cssSelector(".add-to-cart")).click();
		System.out.println(driver.findElement(By.cssSelector("p")).getText());


		





	}

}
