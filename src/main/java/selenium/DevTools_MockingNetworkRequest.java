package selenium;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v143.emulation.Emulation;
import org.openqa.selenium.devtools.v143.fetch.Fetch;
import org.openqa.selenium.devtools.v143.network.Network;
import org.openqa.selenium.devtools.v143.network.model.Request;
import org.openqa.selenium.devtools.v143.network.model.Response;

public class DevTools_MockingNetworkRequest {

	public static void main(String[] args) throws InterruptedException {

        ChromeDriver driver = new ChromeDriver();
        
        DevTools devTools =driver.getDevTools();
        
        devTools.createSession();
        
        //Enable request pausing--> each request will be paused till client manually send it to server
        
        devTools.send(Fetch.enable(Optional.empty(), Optional.empty()));
        
       //Adding listener to listen every request pause event
        
        devTools.addListener(Fetch.requestPaused(), request ->{
        	
        	String originalUrl = request.getRequest().getUrl();
        	
        	//mock req if pattern matches
        	
        	if(originalUrl.contains("=shetty"))
        	{
        		String mockUrl=originalUrl.replace("=shetty", "=Poulami");
        		devTools.send(Fetch.continueRequest(request.getRequestId(), Optional.of(mockUrl), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty()));
        	}
        	else
        	{
        		devTools.send(Fetch.continueRequest(request.getRequestId(), Optional.of(originalUrl), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty()));
        	}
        });
        
        
        
        driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.cssSelector("button[routerlink*='library']")).click();
		
		Thread.sleep(3000);
		
		System.out.println(driver.findElement(By.cssSelector("p")).getText());
		





	}

}
