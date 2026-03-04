package selenium;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeOptionsTest {

	public static void main(String[] args) {
		
		ChromeOptions option = new ChromeOptions();
		
		// Set Https Cerificate Error
		
		option.setAcceptInsecureCerts(true);
		
		// Add Extension to Browser
		
		option.addExtensions(new File("C:\\extensions\\adblocker.crx"));
		
		// Set Proxy to Browser
		
		Proxy proxy = new Proxy();
		
		proxy.setHttpProxy("127.0.0.1:8080");
		
		option.setProxy(proxy);
		
		// Set Download Directory
		
		String downloadPath = "C:\\Downloads\\Selenium";

        Map<String, Object> prefs = new HashMap<>();
        
        prefs.put("download.default_directory", downloadPath);
        
        option.setExperimentalOption("prefs", prefs);
        
        //Open Browser with chrome options
		
		WebDriver driver = new ChromeDriver(option);
		
		driver.get("https://expired.badssl.com/");
		
		System.out.println(driver.getTitle());

	}

}
