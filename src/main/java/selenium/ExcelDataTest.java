package selenium;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataTest {

	public static void main(String[] args) throws IOException {

		ArrayList<String> data= getData("Delete");
		System.out.println(data);
  
	}
	
    public static ArrayList<String> getData(String testCaseName) throws IOException
    {
    	ArrayList<String> data = new ArrayList<>();
    	
    	FileInputStream fs = new FileInputStream("C:\\Users\\MSUSERSL123\\eclipse-workspace\\SeleniumTutorial\\TestData.xlsx");
        
        XSSFWorkbook xssfWorkBook = new XSSFWorkbook(fs);
        
        int sheetCount = xssfWorkBook.getNumberOfSheets();
        
        XSSFSheet sheet = xssfWorkBook.getSheet("TestData");
        
        int rowCount= sheet.getLastRowNum();
        
        Row firstRow = sheet.getRow(0);
        
        int colCount= firstRow.getLastCellNum()-1;
        
        int colOfTestCase=0;
        
        for(int i=0;i<=colCount;i++)
        {
        	String cellValueRow =firstRow.getCell(i).getStringCellValue();
        	
        	if(cellValueRow.equals(testCaseName))
        	{
        		colOfTestCase=i;
        		break;
        	}
        }
        
        System.out.println(testCaseName+" col no :"+colOfTestCase);
        
        int rowOfTestCase=0;
        
        for(int i =0;i<=rowCount;i++)
        {
        	Row row = sheet.getRow(i);
        	String cellValueCol= row.getCell(colOfTestCase).getStringCellValue();
        	if(cellValueCol.equals(testCaseName))
        	{
        		rowOfTestCase=i;
                break;
        	}
        	
        	
        }
        System.out.println(testCaseName +"row no :"+rowOfTestCase);
        
        for(int i=0;i<=colCount;i++)
        {
        	String cellValue;
        	
        	Cell cell=sheet.getRow(rowOfTestCase).getCell(i);
        	
        	if(cell.getCellType()==CellType.STRING)
        	{
        	  cellValue=cell.getStringCellValue();
        	}
        	else
        	{
        		cellValue=String.valueOf((long)cell.getNumericCellValue());
        	}
        		
        	data.add(cellValue);
        }
        
        return data;
    }

}
