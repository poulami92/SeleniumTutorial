package TestNgTutorial;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class TestNgDataProvider_Excel {
	
	@Test(dataProvider="getTestData")
	public void enterTestDate(String un,String pwd)
	{
		System.out.println("Username : "+un);
		System.out.println("Password : "+pwd);
	}
	
	@DataProvider
	public Iterator<Object[]> getTestData() throws IOException
	{
       
		FileInputStream fs = new FileInputStream("C:\\Users\\MSUSERSL123\\eclipse-workspace\\SeleniumTutorial\\TestData.xlsx");
        
        XSSFWorkbook xssfWorkBook = new XSSFWorkbook(fs);
        
        XSSFSheet sheet = xssfWorkBook.getSheet("TestNgData");
		
        int rowCount= sheet.getLastRowNum();
        
        Row firstRow = sheet.getRow(0);
        
        int colCount= firstRow.getLastCellNum()-1;
        
        ArrayList<Object[]> dataList = new ArrayList<>();
        
        for(int i=1;i<=rowCount;i++)
        {
        	Row row = sheet.getRow(i);
        	Object[]data = new Object[colCount+1];
        	
        	for(int j=0;j<=colCount;j++)
        	{
        		
        		Cell cell=row.getCell(j);
        		
        		String cellValue=cell.getStringCellValue();
        		
        		data[j]=cellValue;
        	
        	}
        	dataList.add(data);
        
        }
        
        
        return dataList.iterator();
	}

}
