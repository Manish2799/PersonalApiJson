package Reader;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {

	public static String getProperty(String keyname) throws IOException
	{
		Properties prop= new Properties();
		
		String path=System.getProperty("user.dir")+ "/src/main/resources/Configuration/config.properties";
		
		FileInputStream fis= new FileInputStream(path);
		
		prop.load(fis);
		
		return prop.getProperty(keyname);
		
	}
}
