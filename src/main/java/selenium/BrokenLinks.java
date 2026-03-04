package selenium;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinks {

	public static void main(String[] args) throws IOException, URISyntaxException {
		
       //System.setProperty("webdriver.chrome.driver","C:\\Users\\MSUSERSL123\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
	
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/");
		
		//gel all the links and images
		
		List<WebElement> linksList = driver.findElements(By.tagName("a"));
		
		List<WebElement> imagesList = driver.findElements(By.tagName("img"));
		
		//add imagelist to linkslist
		
		linksList.addAll(imagesList);
		
		List<WebElement> activeLinks = new ArrayList<WebElement>();
		
		//filter out links having href=null
		
		for(WebElement el : linksList)
		{
			if(el.getAttribute("href")!=null && !(el.getAttribute("href").isEmpty()))
			{
				activeLinks.add(el);
				
			}
		}
		
		//check href url is working or not by using HTTP library
		
		for(WebElement el : activeLinks)
		{
			String hrefValue = el.getAttribute("href");
			
			URL linKURL = new URI(hrefValue).toURL();
			
			HttpURLConnection httpConn= (HttpURLConnection)linKURL.openConnection();
			
			httpConn.setConnectTimeout(9000);
			
			httpConn.connect();
			
			int resMessage= httpConn.getResponseCode();
			
			httpConn.disconnect();
			
			System.out.println(hrefValue+ "--> "+resMessage);	
		}
		
		driver.close();
		

	}

}
