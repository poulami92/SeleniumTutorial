package selenium;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import TestUtility.TestUtil;

public class DownloadFile {

	public static void main(String[] args) throws IOException, InterruptedException{	
		
		String fileDownloadPath=System.getProperty("user.dir");
		String downLoadFilePath=fileDownloadPath+"\\download.xlsx";
		
		Map<String,Object> prefs = new HashMap<>();
		
		prefs.put("profile.default_content_settings.popups", 0);
		prefs.put("download.default_directory", fileDownloadPath);
		
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", prefs);
		
		WebDriver driver = new ChromeDriver(options);
		
		driver.get("https://rahulshettyacademy.com/upload-download-test/index.html");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
		
		driver.findElement(By.cssSelector("#downloadButton")).click();
		
		Thread.sleep(3000);
		
		File f = new File(downLoadFilePath);
		
		if(f.exists())
		{
			System.out.println("File found");
			f.delete();
			System.out.println("File deleted");
		}
		
	}	
		

}

