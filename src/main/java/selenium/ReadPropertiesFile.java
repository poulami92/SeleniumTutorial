package selenium;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadPropertiesFile {

	public static void main(String[] args) throws IOException {

       Properties prop = new Properties();
       FileInputStream fs = new FileInputStream("C:\\Users\\MSUSERSL123\\eclipse-workspace\\SeleniumTutorial\\src\\main\\java\\selenium\\config.properties");
       
       prop.load(fs);
       
       System.out.println(prop.getProperty("age"));
	}

}
