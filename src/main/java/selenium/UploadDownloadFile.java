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

public class UploadDownloadFile {

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
		}
		
		
		
        String updatedPrice = "800";
		
		String fruit="Apple";
		
        updatePriceValue(updatedPrice,downLoadFilePath,fruit);
		
		System.out.println("file updated");
		

		driver.findElement(By.id("fileinput")).sendKeys(downLoadFilePath);
		
		By toastLocator = By.cssSelector(".Toastify__toast-body div:nth-child(2)");
		
		String uploadSuccessMessage =new WebDriverWait(driver,Duration.ofSeconds(5)).
        until(ExpectedConditions.visibilityOfElementLocated(toastLocator)).getText();
		
		Assert.assertEquals("Updated Excel Data Successfully.",uploadSuccessMessage);
		
		new WebDriverWait(driver,Duration.ofSeconds(5)).
        until(ExpectedConditions.invisibilityOfElementLocated(toastLocator));
		
		String prefix_xpath="//div[text()='";
		
		String post_xpath="']//parent::div//following-sibling::div[2]";	
		
		String fruitPrice=driver.findElement(By.xpath(prefix_xpath+fruit+post_xpath)).getText();
		
		System.out.println(fruitPrice);
		
		Assert.assertEquals(fruitPrice, updatedPrice);
		
		f.delete();
		System.out.println("File deleted");
		
		
		
	}
	
	public static int getColNo(XSSFSheet sheet,String CoulumnName)
	{
		TestUtil util = new TestUtil();
		int colNum=util.getColNo(sheet, CoulumnName);
		return colNum;
				
	}
	
	public static int getRowNo(XSSFSheet sheet,String data,String CoulumnName)
	{
		TestUtil util = new TestUtil();
		int rowNum=util.getRowNo(sheet, data,CoulumnName);
		return rowNum;
				
	}
	
		public static void updatePriceValue(String updatedValue,String filePath,String fruitName) throws IOException
		{
			FileInputStream fs = new FileInputStream(filePath);
	        
	        XSSFWorkbook xssfWorkBook = new XSSFWorkbook(fs);
	        
	        XSSFSheet sheet = xssfWorkBook.getSheet("Sheet1");
	        
	        int colNo=getColNo(sheet,"price");
	        
	        int rowNo=getRowNo(sheet,fruitName,"fruit_name");
	        
	        Cell cell=sheet.getRow(rowNo).getCell(colNo);
	        
			cell.setCellValue(updatedValue);
			FileOutputStream fo = new FileOutputStream(filePath);
			
			xssfWorkBook.write(fo);
			
			xssfWorkBook.close();
			
			fs.close();
		}
}

