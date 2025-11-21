package com.CRM.generic.FileUtility;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonUtility {
	       public String getDataFromJson(String key) throws IOException, ParseException {
	    	   FileReader fil = new FileReader("./configAppData/data.json");
	    	  JSONParser parser = new JSONParser();
	    	Object obj = parser.parse(fil);
	    	JSONObject map = (JSONObject)obj;
	    	String data = (String)map.get(key);
	    	return data;
	       }
          
}
