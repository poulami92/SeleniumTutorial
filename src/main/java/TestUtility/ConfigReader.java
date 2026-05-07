package TestUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	
	public Properties prop;
	
	public ConfigReader() throws IOException
	{
		prop = new Properties();
		FileInputStream fs = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\Config\\config.properties");
		prop.load(fs);
	}
	
	public String getUrl() {
        return prop.getProperty("GreenKartUrl");
    }
	public String getBrowser() {
        return prop.getProperty("browser");
    }

}
