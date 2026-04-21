package TestNgTutorial;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TestNgDataProvider_Json {
	
	@Test(dataProvider="getTestData")
	public void enterTestDate(HashMap<String, String> map)
	{
		System.out.println("Username : "+map.get("username"));
		System.out.println("Password : "+map.get("password"));
	}
	
	@DataProvider
	public Iterator<HashMap<String, String>> getTestData() throws IOException
	{
		List<HashMap<String, String>> data =getJsonDataToMap();
		return data.iterator();
	}
	
	
	public List<HashMap<String, String>> getJsonDataToMap() throws IOException
	{
		Path path = Path.of(System.getProperty("user.dir")+"\\src\\main\\java\\TestNgTutorial\\data.json");
		String jsonData = Files.readString(path);
		ObjectMapper mapper = new ObjectMapper();

		
		List<HashMap<String,String>> data = mapper.readValue(jsonData, new TypeReference<List<HashMap<String,String>>>(){
			
		});
		
		
		return data;
	}

}
