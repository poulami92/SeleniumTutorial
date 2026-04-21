package TestUtility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import BasePage.TestBase;
import DriverFactory.DriverFactory;

public class TestUtil {
	
	public String getSecreenShot(String testCaseName ) throws IOException
	{
        TakesScreenshot ts = (TakesScreenshot)DriverFactory.getDriver();
		
		File src = ts.getScreenshotAs(OutputType.FILE);
		
		String destLoc= System.getProperty("user.dir")+"\\ExtentReports\\"+testCaseName+".png";
		
		File dest = new File(destLoc);
		
		FileHandler.copy(src, dest);
		
		return destLoc;
	}
	
	public ExtentReports getExtentReporter()
	{
		String path = System.getProperty("user.dir")+"\\ExtentReports\\index.html";
		ExtentSparkReporter extentSpark = new ExtentSparkReporter(path);
		
		extentSpark.config().setReportName("Web Automation Results");
		extentSpark.config().setDocumentTitle("Test Results");
		
		ExtentReports extentReport = new ExtentReports();
		extentReport.attachReporter(extentSpark);
		
		extentReport.setSystemInfo("Tester","Poulami");
		
		return extentReport;
	}
	
	
	public int getRowCount(XSSFSheet sheet)
	{
		return sheet.getLastRowNum();
	}
	
	public int getColCount(XSSFSheet sheet)
	{
        Row firstRow = sheet.getRow(0);
        
        return firstRow.getLastCellNum()-1;
	}
	
	public int getColNo(XSSFSheet sheet,String columnName)
	{
		Row firstRow=sheet.getRow(0);
		
		int colCount=getColCount(sheet);
		
		String cellValue;
		
		Cell cell;
		
		int columnNo=0;
		
		for(int i=0;i<=colCount;i++)
		{
			cell = firstRow.getCell(i);
			
			cellValue = getCellValue(cell);
	
			if(cellValue.equals(columnName))
			{
				columnNo=i;
				break;
			}
		}
		
		return columnNo;
		
	}
	
	public int getRowNo(XSSFSheet sheet,String data,String ColumnName)
	{
		int colNo=getColNo(sheet,ColumnName);
		int rowCount=getRowCount(sheet);
		String cellValue;
		Cell cell;
		int dataRowNo=0;
		
		for(int i=1;i<=rowCount;i++)
		{
			cell = sheet.getRow(i).getCell(colNo);
			cellValue = getCellValue(cell);
			if(cellValue.equals(data))
			{
				dataRowNo=i;
				break;
			}
			
		}
		
		return dataRowNo;
		
	}
	
	public String getCellValue(Cell cell)
	{
		String cellValue;
		
		if(cell.getCellType()==CellType.STRING)
		{
			cellValue=cell.getStringCellValue();
		}
		else
		{
			cellValue=String.valueOf((long)cell.getNumericCellValue());
		}
		
		return cellValue;
	}
	
}
