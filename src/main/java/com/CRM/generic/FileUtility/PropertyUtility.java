package com.CRM.generic.FileUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyUtility {
   public String getDataFromPropertyFile(String key) throws IOException{
	   FileInputStream fis = new FileInputStream("./configAppData/data.properties");
	   Properties p = new Properties();
	   p.load(fis);
	   String data = p.getProperty(key);
	   return data;
	   }
   }
