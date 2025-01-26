package UtilityLayer;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class JsonSchemaReader {

	public static FileReader jsonSchemaReader(String JsonSchemaPayload) throws FileNotFoundException
	{
		String path=System.getProperty("user.dir") + "/src/test/resources/JsonScema/" + JsonSchemaPayload + ".json";
		
		FileReader file = new FileReader(path);
		return file;
	}
}
