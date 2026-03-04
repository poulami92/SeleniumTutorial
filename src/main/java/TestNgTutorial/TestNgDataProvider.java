package TestNgTutorial;

import java.util.ArrayList;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestNgDataProvider {
	
	@Test(dataProvider="getTestData")
	public void enterTestDate(String un,String pwd)
	{
		System.out.println("Username : "+un);
		System.out.println("Password : "+pwd);
	}
	
	@DataProvider
	public Object[][] getTestData()
	{
		Object[][] obj = {
			{"poulami1","pwd123"},
			{"poulami2","pwd124"},
			{"poulami3","pwd125"},
			{"poulami4","pwd126"},
		};
		
		return obj;
		
	}

}
