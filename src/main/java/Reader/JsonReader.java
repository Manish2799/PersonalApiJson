package Reader;

import java.io.FileInputStream;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonReader {

	public static <T>T Desrilization(String JsonPayloadName, Class<T> pojoclassname,String jsonNodeName) throws IOException
	{
		String path= System.getProperty("user.dir")+ "/src/test/resources/JsonPayload/" + JsonPayloadName+ ".json";

		FileInputStream fis= new FileInputStream(path);
		
		ObjectMapper mapper= new ObjectMapper();
		
		JsonNode node=mapper.readTree(fis);
		
	return	mapper.treeToValue(node.get(jsonNodeName), pojoclassname);
		
		
	}
	
	public static String serialization(Object pojoclass) throws JsonProcessingException
	{
		ObjectMapper mapper= new ObjectMapper();
		
		return mapper.writeValueAsString(pojoclass);
		
	}
}
