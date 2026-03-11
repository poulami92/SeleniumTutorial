package selenium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.assertj.core.util.Arrays;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v143.emulation.Emulation;
import org.openqa.selenium.devtools.v143.fetch.Fetch;
import org.openqa.selenium.devtools.v143.fetch.model.RequestPattern;
import org.openqa.selenium.devtools.v143.network.Network;
import org.openqa.selenium.devtools.v143.network.model.ErrorReason;
import org.openqa.selenium.devtools.v143.network.model.Request;
import org.openqa.selenium.devtools.v143.network.model.Response;

public class DevTools_FailNetworkRequest {

	public static void main(String[] args) throws InterruptedException {

        ChromeDriver driver = new ChromeDriver();
        
        DevTools devTools =driver.getDevTools();
        
        devTools.createSession();
        
        //Enable request pausing for matching pattern url till client manually send it to server
        
        RequestPattern reqPattern = new RequestPattern(Optional.of("*GetBook*"),Optional.empty(),Optional.empty());       
        ArrayList<RequestPattern> reqPatternList = new ArrayList<>();
        reqPatternList.add(reqPattern);
        
        devTools.send(Fetch.enable(Optional.of(reqPatternList), Optional.empty()));
         
       //Adding listener to listen paused request event
        
        devTools.addListener(Fetch.requestPaused(), request ->{
        	
        	devTools.send(Fetch.failRequest(request.getRequestId(), ErrorReason.FAILED));
        	
        });
        
        
        
        driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.cssSelector("button[routerlink*='library']")).click();

		





	}

}
