package com.ecom.qa.data;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DataReader {
	
	//Read a json file and conver into String
	
	public List<HashMap<String, String>> getJsonToMap() throws IOException

	{
		String stringData = FileUtils.readFileToString(new File(System.getProperty("user.dir")+"/src/test/java/com/ecom/qa/fileUtils/productData.json"),
				                                      "UTF-8");
		//Convert String to HasMap -Using Jakson Data Binding
		
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String, String>> data = mapper.readValue(stringData, new TypeReference<List<HashMap<String,String>>>() {
		});
		
		return data;
	}
}
