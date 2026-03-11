package selenium;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.openqa.selenium.By;
import org.openqa.selenium.HasAuthentication;
import org.openqa.selenium.Keys;
import org.openqa.selenium.UsernameAndPassword;
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
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

import com.google.common.base.Predicate;
import com.google.common.collect.ImmutableList;

public class Selenium_4__LogJsErrorToConsole {

	public static void main(String[] args) throws InterruptedException {

        ChromeDriver driver = new ChromeDriver();
		
		//listeners - OnTestFailure
		
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.linkText("Browse Products")).click();
		driver.findElement(By.partialLinkText("Selenium")).click();
		driver.findElement(By.cssSelector(".add-to-cart")).click();
		driver.findElement(By.linkText("Cart")).click();
		driver.findElement(By.id("exampleInputEmail1")).clear();
		driver.findElement(By.id("exampleInputEmail1")).sendKeys("2");
		
		//listeners - OnTestFailure
		
		//Get browser log entries and store into object
		
		LogEntries entries=driver.manage().logs().get(LogType.BROWSER);
		
		//Get list of all log entries
		
		List<LogEntry> logs=entries.getAll();
		
		//Get log entry message
		
		for(LogEntry log: logs)
		{
			System.out.println(log.getMessage());
		}



	}

}
