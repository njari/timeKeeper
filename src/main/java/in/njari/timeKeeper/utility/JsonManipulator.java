package in.njari.timeKeeper.utility;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonManipulator {
	
	Logger log = LoggerFactory.getLogger(JsonManipulator.class);
	
	// String json to an object 
	
	 public static <T> T createObjectInstance(String content, Class<T> valueType) {
		 ObjectMapper objectMapper = new ObjectMapper();
		 try {
			return objectMapper.readValue(content, valueType);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
	 }

}
